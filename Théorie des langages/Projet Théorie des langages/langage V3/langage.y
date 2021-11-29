%{
  #include <stdio.h>
  #include <stdlib.h>
  #include <cmath>   
  #include <map>
  #include <vector>
  #include <string>
  #include <iostream>
  #include <stack>

  using namespace std;

  extern int yylex ();
  extern char* yytext;
  extern FILE* yyin;
  int yyerror(char *s);

  class instruction{
  public:
    instruction (const int &c, const double &v=0, const string &n="") {code = c; value = v; name = n;};  
    int code; 
    double value;     // éventuellement une valeur si besoin
    string name;      // ou une référence pour la table des données 
  };

  // Déclaration de la map qui associe
  // les noms des variables à leur valeur
  // (La table de symboles)
  map<string,double> variables;
  int ic = 0;

  // Cette map sert à stocker les adresses associées aux labels (GoTo).
  // Pour info, il est possible de faire un saut vers une étiquette
  // qui n'est pas encore déclarée (Saut vers le futur)
  // En gros, les sauts GoTo ne se font pas uniquement vers l'arrière.
  // Je vous laisse gérer les problèmes créés par le Goto :
  // - Saut vers une étiquette inexistante (ni avant, ni après)
  // - Duplication de labels (Déterminisme !!!)
  // Ne parlons pas, comme dans l'exmeple, des sauts de blocs de déclarations, 
  // ou des bloc entremêlés, ou... ou ...
  // Vous avez compris pourquoi il est banni ?
  map<string,int> adresses;

  
  // Structure pour accueillir le code généré 
  // (sone de code ou code machine ou assembleur)
  vector <instruction> code_genere;    

  // Remarquez les paramètres par défaut pour faciliter les appels depuis la grammaire
  int add_instruction(const int &c, const double &v=0, const string &n="") {
      code_genere.push_back(instruction(c,v,n)); 
      ic++;
      return 0; 
   }; 


%}

%code requires
  {
    typedef struct adr {
        int jmp;  // adresse du jmp
        int jc;  // adrese  du jc
    } type_adresse;
  }

%union {
  double valeur;
  char nom[50];
  type_adresse adresse;  
}

%token <valeur> NUM
%token <nom> VAR
%type <valeur> expr 
%token SIN
%token COS
%token <adresse> SI
%token ALORS
%token SINON
%token FINSI
%token SUP
%token PRINT
%token ASSIGN
%token GOTO
%token <nom> LABEL
%token JMP
%token JMPCOND

%right ADD SUB   // N'oubliez pas de remettre left !
%left MULT DIV

%%
bloc:  /* Epsilon */
     | bloc label instruction '\n'   

label : // Epsilon
      | LABEL ':'  { // Lorsque je rencontre un label
                     // je stocke le numéro de l'instruction actelle
                     // dans la table des adresses. C'est tout!   
                     adresses [$1] = ic;}

instruction :   /* Epsilon, ligne vide */
            | expr         {  }
            | PRINT expr   { add_instruction(PRINT); }
            | VAR '=' expr { add_instruction(ASSIGN, 0, $1); }
            | GOTO LABEL   {  // J'insère un JMP vers une adresse que je ne connais pas encore.
                              // J'utiliserai la table des adresses pour la récupérer lors de l'exécution
                              add_instruction(JMP, -999, $2); 
                           }
            | SI '(' condition ')' '\n' { // Je sauvegarde l'endroit actuel pour revenir mofifier l'adresse 
                                          // lorsqu'elle sera connue (celle du JC)
                                          $1.jc = ic;
                                          add_instruction(JMPCOND); }
              ALORS '\n'
                bloc                    { // Je sauvegarde l'endroit actuel pour revenir mofifier l'adresse 
                                          // lorsqu'elle sera connue (celle du JMP)
                                          $1.jmp = ic;
                                          add_instruction(JMP);
                                          // Je mets à jour l'adresse du saut conditionnel
                                          code_genere[$1.jc].value = ic;
                                        }
              SINON '\n' 
                bloc                                  
              FINSI                     { // Je mets à jour l'adresse du saut inconditionnel
                                          code_genere[$1.jmp].value = ic;}                  

expr:  NUM               { add_instruction (NUM, $1);   }
     | VAR               { add_instruction (VAR, 0, $1);  }
     | SIN '(' expr ')'  {  }
     | COS '(' expr ')'  {  }
     | '(' expr ')'      {  }
     | expr ADD expr     { add_instruction (ADD); }
     | expr SUB expr     {  }   		
     | expr MULT expr    { add_instruction (MULT); }		
     | expr DIV expr     {  }   


condition :  expr          {}
          |  expr SUP expr {}
%%

int yyerror(char *s) {					
    printf("%s : %s\n", s, yytext);
}


// Petite fonction pour mieux voir le code généré 
// (au lieu des nombres associés au tokens)
string print_code(int ins) {
  switch (ins) {
    case ADD      : return "ADD";
    case MULT     : return "MUL";    
    case NUM      : return "NUM";
    case VAR      : return "VAR";
    case PRINT    : return "OUT";
    case ASSIGN   : return "MOV";
    case JMP      : return "JMP";
    case JMPCOND  : return "JC ";
    default : return "";
  }
}

// Fonction qui exécute le code généré sur un petit émulateur
void execution ( const vector <instruction> &code_genere, 
                 map<string,double> &variables )
{
printf("\n------- Exécution du programme ---------\n");
stack<int> pile;

int ic = 0;  // compteur instruction
double r1, r2;  // des registres

printf("Quelle est la réponse à la grande question sur la vie, l'univers et le reste ?\n");

  while (ic < code_genere.size()){   // tant que nous ne sommes pas à la fin du programme
      auto ins = code_genere[ic];
      switch (ins.code){
        case ADD:
            r1 = pile.top();    // Récupérer la tête de pile;
            pile.pop();

            r2 = pile.top();    // Récupérer la tête de pile;
            pile.pop();

            pile.push(r1+r2);
            ic++;
          break;
        case MULT:
            r1 = pile.top();    // Récupérer la tête de pile;
            pile.pop();

            r2 = pile.top();    // Récupérer la tête de pile;
            pile.pop();

            pile.push(r1*r2);
            ic++;
          break;

        case ASSIGN:
            r1 = pile.top();    // Récupérer la tête de pile;
            pile.pop();
            variables[ins.name] = r1;
            ic++;
          break;

        case PRINT:
            r1 = pile.top();    // Récupérer la tête de pile;
            pile.pop();
            cout << "$ " << r1 << endl; 
            ic++;
        break;

        case NUM:   // pour un nombre, on empile
            pile.push(ins.value);
            ic++;
          break;

        case JMP:
            if (ins.value != -999) // Est-ce un GoTo ?
              ic = ins.value;
            else
              // je récupère l'adresse à partir de la table
              ic = adresses[ins.name];
          break;

        case JMPCOND: 
             r1 = pile.top();    // Rrécupérer la tête de pile;
             pile.pop();
             if ( r1 != 0 ) 
                ic++;
             else 
                ic = (int)ins.value;             
          break;

        case VAR:    // je consulte la table de symbole et j'empile la valeur de la variable
             // Si elle existe bien sur... 
            try {
                pile.push(variables.at(ins.name));
                ic++;
            }
          catch(...) {
                variables[ins.name] = 0;
                pile.push(variables.at(ins.name));
                ic++;
            }
          break;
      }
  }
}

int main(int argc, char **argv) {
  printf("-----------------\nLangage V3.0 / Deep Thought\n");

  // Code pour traiter un fichier au lieu de l'entrée clavier
  if ( argc > 1 )
    yyin = fopen( argv[1], "r" );
  else
    yyin = stdin;

  yyparse();						


  for (int i = 0; i < code_genere.size(); i++){
    auto instruction = code_genere [i];
    cout << i 
         << '\t'
         << print_code(instruction.code) 
         << '\t'
         << instruction.value 
         << '\t' 
         << instruction.name 
         << endl;
  }

  execution(code_genere, variables);

  return 0;
}