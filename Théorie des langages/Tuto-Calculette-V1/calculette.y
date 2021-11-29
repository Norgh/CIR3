%{
  #include <stdio.h>
  #include <stdlib.h>
  #include <math.h>    
  extern int yylex ();
  extern char* yytext;
  extern FILE* yyin;
  int yyerror(char *s);
%}

%code requires
  {
    #define YYSTYPE double
  }

%token NUM
%token SIN
%token COS

%left '+' '-'
%left '*' '/'

%%
ligne:            { }
     | ligne expr '\n'  { printf("Résultat du calcul : %g\n", $2); } 

expr:  NUM               { $$ = $1; }
     | SIN '(' expr ')'  { $$ = sin($3); printf ("sin(%g) = %g\n", $3, $$ ); }
     | COS '(' expr ')'  { $$ = cos($3); printf ("cos(%g) = %g\n", $3, $$ ); }
     | '(' expr ')'      { $$ = $2; }
     | expr '+' expr     { $$ = $1 + $3; printf ("%g + %g = %g\n", $1, $3, $$ );}
     | expr '-' expr     { $$ = $1 - $3; printf ("%g - %g = %g\n", $1, $3, $$ );}   		
     | expr '*' expr     { $$ = $1 * $3; printf ("%g * %g = %g\n", $1, $3, $$ );}		
     | expr '/' expr     { $$ = $1 / $3; printf ("%g / %g = %g\n", $1, $3, $$ );}    
%%

int yyerror(char *s) {					
    printf("%s : %s\n", s, yytext);
}

int main(int argc, char **argv) {
  printf("Calculette V1.0\n");

  // Code pour traiter un fichier au lieu de l'entrée clavier
  if ( argc > 1 )
    yyin = fopen( argv[1], "r" );
  else
    yyin = stdin;

  yyparse();						

  return 0;
}