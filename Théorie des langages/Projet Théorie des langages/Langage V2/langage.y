%{
  #include <stdio.h>
  #include <stdlib.h>
  #include <cmath>   
  #include <map>
  #include <vector>
  #include <string>
  #include <iostream>

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
  map<string,double> variables ;

  // Structure pour accueillir le code généré 
  // (sone de code ou code machine ou assembleur)
  vector <instruction> code_genere;    
  int ic = 0; // compteur instruction

  // Remarquez les paramètres par défaut pour faciliter les appels depuis la grammaire
  int add_instruction(const int &c, const double &v=0, const string &n="") {
      code_genere.push_back(instruction(c,v,n)); 
      ic++;
      return 0; 
   }; 


%}

%union {
  double valeur;
  char nom[50];
}

%token <valeur> NUM
%token <nom> VAR
%type <valeur> expr 
%token SIN
%token COS
%token SI
%token ALORS
%token SINON
%token FINSI
%token SUP

%right ADD SUB
%left MULT DIV

%%
bloc:  /* Epsilon */
     | bloc instruction '\n'   

instruction :   /* Epsilon, ligne vide */
            | expr         { printf ("\n"); }
            | VAR '=' expr {  }
            | SI '(' expr SUP expr ')' '\n'
              ALORS '\n'
                bloc
              SINON '\n'
                bloc
              FINSI               {  }

expr:  NUM               { add_instruction (NUM, $1);   }
     | VAR               {  }
     | SIN '(' expr ')'  {  }
     | COS '(' expr ')'  {  }
     | '(' expr ')'      {  }
     | expr ADD expr     { add_instruction (ADD); }
     | expr SUB expr     {  }   		
     | expr MULT expr    { add_instruction (MULT); }		
     | expr DIV expr     {  }    
%%

int yyerror(char *s) {					
    printf("%s : %s\n", s, yytext);
}



string print_code(int ins) {
  switch (ins) {
    case ADD      : return "ADD";
    case MULT     : return "MUL";    
    case NUM      : return "NUM";
    case VAR      : return "VAR";
    default : return "";
  }
}


int main(int argc, char **argv) {
  printf("-----------------\nLangage  V1.0\n");

  // Code pour traiter un fichier au lieu de l'entrée clavier
  if ( argc > 1 )
    yyin = fopen( argv[1], "r" );
  else
    yyin = stdin;

  yyparse();						

  for (auto instruction : code_genere){
    cout << print_code(instruction.code) << "\t" <<  instruction.value << endl;
  }



  return 0;
}