%{
#include <iostream>
using namespace std;
%}

%option noyywrap 

%%

alignas|alignof|andb|and_eqb|asmun|auto|bitorb|bool|break|case|catch|char|char8_tc|char16_t|char32_t|class|complb|conceptc|const|const_cast|constevalc|constexpr|constinitc|continue|co_awaitc|co_returnc|co_yieldc|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|exportc|extern|false|float|for|friend|goto|if|inline|int|long|mutable|namespace|new|noexcept|notb|not_eqb|nullptr|operator|orb|or_eqb|private|protected|public|register|reinterpret_cast|requiresc|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|true|try|typedef|typeid|typename|union|unsigned|using|void|volatile|wchar_t|while|xorb|xor_eqb	{ cout << "Mot réservé : " << yytext << endl; }
(\/\/(.*)\n)|(\/\*((.|\n)*?)\*\/)		{ cout << "Un commentaire : " << yytext << endl; }
[a-zA-Z_][a-zA-Z0-9_]* 	{ cout << "Un identificateur : " << yytext << endl; }
[\+=>]    				{ cout << "Un opérateur : " << yytext << endl;}
[\(\)]    				{ cout << "Parenthèses : " << yytext << endl;}
[\.,!\?]    			{ cout << "Une ponctuation : " << yytext << endl;}              
[;]    					{ cout << "Un séparateur : " << yytext << endl;}
[0-9]+\.[0-9]+ 			{ cout << "Un nombre à virgule : " << yytext << endl; }
[0-9]+ 					{ cout << "Un nombre entier : " << yytext << endl; } 

\n 						{}
\r      				{}
. 						{}

%%

int main( int argc, char **argv )
{
	if ( argc > 1 )
		yyin = fopen( argv[1], "r" );
	else
		yyin = stdin;
	yylex();
	printf("\n");
}

