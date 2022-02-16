%option noyywrap

%{
  #include <stdio.h>
  #include <stdlib.h>
  #include "calculette.bison.hpp"
%}

%%

[0-9]+(\.[0-9]*)?([Ee][+-]?[0-9]+)? {  yylval = atof(yytext); return NUM; }
\n     {  return '\n'; }
\r     { }
" "    { }
\t     { }
Sin|SIN|sin|sinus|Sinus|SINUS { return SIN; }
Cos|COS|cos|cosinus|Cosinus|COSINUS { return COS; }
Tan|TAN|tan|tangente|Tangente|TANGENTE { return TAN; }
un      { yylval = 1. ; return NUM; }
deux    { yylval = 2. ; return NUM; }
trois   { yylval = 3. ; return NUM; }
plus    { return '+';}
fois    { return '*'; }
" "    {}
\+     {  return yytext[0];  }  // la même chose que return '+'  
"-"    {  return '-'; }
"*"    {  return '*'; }
"/"    {  return '/'; }
\(    {  return '('; }
\)    {  return ')'; }
.      {  printf ("lex error : %c\n", yytext); return 0; }

%%

