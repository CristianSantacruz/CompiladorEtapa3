package compilador.etapa.pkg2;
import static compilador.etapa.pkg2.Token.*;
/*
 * INTEGRANTES:
 *  QUIMBITA LILIAN
 *  SANTACRUZ CRISTIAN
*/

%%
%class Lexer
%type Token
%line
%column

palabrasReservadas = ("int"|"float"|"bool"|"char"|"string"|"then"|"input"|"output"|"return")
boolean = ("true"|"false")
caracteresEspeciales = (":"|"&"|"$")
char = ("'")
//string = "\""({digito}|{caracter}|" ")*"\""
identificador = [a-zA-Z]+[a-zA-Z|0-9]*
digitos = [0-9]
espacios = [ \t\r\n]

%{
public String lexeme;
%}
%%
"/*"[^"*/"]*"*/"+   { }
"//".*              { }

"{"	{lexeme=yytext(); return ALLAVE;}
"}"	{lexeme=yytext(); return CLLAVE;}
";"	{lexeme=yytext(); return PYCOMA;}
","	{lexeme=yytext(); return COMA;}
")"	{lexeme=yytext(); return CPAREN;}
"("	{lexeme=yytext(); return APAREN;}
"["	{lexeme=yytext(); return ACORCH;}
"]"	{lexeme=yytext(); return CCORCH;}

"+"     {lexeme=yytext(); return SUMA;}
"-"	{lexeme=yytext(); return RESTA;}
"*"	{lexeme=yytext(); return MULTIPLICACION;}
"/"	{lexeme=yytext(); return DIVISION;}
"++"	{lexeme=yytext(); return AUMENTAR;}
"--"	{lexeme=yytext(); return DISMINUIR;}
"="	{lexeme=yytext(); return ASIGNADOR;}
">"	{lexeme=yytext(); return MAYOR;}
"<"	{lexeme=yytext(); return MENOR;}
"=="	{lexeme=yytext(); return IGUAL;}
">="	{lexeme=yytext(); return MAYORIGUAL;}
"<="	{lexeme=yytext(); return MENORIGUAL;}

"if"		{lexeme=yytext(); return SI;}
"else if"	{lexeme=yytext(); return SINO;}
"else"		{lexeme=yytext(); return NO;}
"for"		{lexeme=yytext(); return PARA;}
"while"		{lexeme=yytext(); return MIENTRAS;}
"void"		{lexeme=yytext(); return VOID;}
"main"		{lexeme=yytext(); return MAIN;}
"int"		{lexeme=yytext(); return T_ENTERO;}
"float"		{lexeme=yytext(); return T_DECIMAL;}
"bool"		{lexeme=yytext(); return T_BOLEANO;}

{espacios}               { }
{palabrasReservadas}     {lexeme=yytext(); return KEYWORD;}
{boolean}                {lexeme=yytext(); return BOOL;}
{char}+.*+{char}         {lexeme=yytext(); return CHAR;}
//{string}                 {lexeme=yytext(); return STRING;}
{identificador}          {lexeme=yytext(); return IDENTIFICADOR;}
{caracteresEspeciales}   {lexeme=yytext(); return CARACTER;}
{digitos}+               {lexeme=yytext(); return ENTERO;}
{digitos}","+ {digitos}+ {lexeme=yytext(); return FLOTANTE;}
.                        {System.out.println("Error Léxico   Línea: " + (yyline+1) + "   Columna: " + (yycolumn+1) + "   Caracter: " + yytext());}
