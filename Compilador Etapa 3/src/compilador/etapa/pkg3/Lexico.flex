package compilador.etapa.pkg3;

import java_cup.runtime.*;
import java.io.Reader;

%%
%class AnalizadorLexico

%line
%column
%cup

%{
    
/*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    

/* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    
private Symbol symbol(int type, Object value) {

        return new Symbol(type, yyline, yycolumn, value);
    
	}

%}

palabrasReservadas = ("int"|"float"|"bool"|"char"|"string"|"then"|"input"|"output"|"return")
boolean = ("true"|"false")
caracteresEspeciales = (":"|"&"|"$")
char = ("'")
identificador = [a-zA-Z]+[a-zA-Z|0-9]*
digitos = [0-9]
espacios = [ \t\r\n]

%%

<YYINITIAL> {
"/*"[^"*/"]*"*/"+   { }
"//".*              { }

"{"	{ return symbol(sym.ALLAVE); }
"}"	{ return symbol(sym.CLLAVE); }
";"     { return symbol(sym.PYCOMA); }
","	{ return symbol(sym.COMA); }
")"	{ return symbol(sym.CPAREN); }
"("	{ return symbol(sym.APAREN); }
"["	{ return symbol(sym.ACORCH); }
"]"	{ return symbol(sym.CCORCH); }

"+"     { return symbol(sym.SUMA); }
"-"	{ return symbol(sym.RESTA); }
"*"	{ return symbol(sym.MULTIPLICACION); }
"/"	{ return symbol(sym.DIVISION); }
"++"	{ return symbol(sym.AUMENTAR); }
"--"	{ return symbol(sym.DISMINUIR); }
"="	{ return symbol(sym.ASIGNADOR); }
">"	{ return symbol(sym.MAYOR); }
"<"	{ return symbol(sym.MENOR); }
"=="	{ return symbol(sym.IGUAL); }
">="	{ return symbol(sym.MAYORIGUAL); }
"<="	{ return symbol(sym.MENORIGUAL); }

"if"        { return symbol(sym.SI); }
"else if"   { return symbol(sym.SINO); }
"else"      { return symbol(sym.NO); }
"for"       { return symbol(sym.PARA); }
"while"     { return symbol(sym.MIENTRAS); }
"void"      { return symbol(sym.VOID); }
"main"      { return symbol(sym.MAIN); }
"int"       { return symbol(sym.T_ENTERO); }
"float"     { return symbol(sym.T_DECIMAL); }
"bool"      { return symbol(sym.T_BOLEANO); }

{espacios}               { }
{palabrasReservadas}     { return symbol(sym.KEYWORD); }
{boolean}                { return symbol(sym.BOOL); }
{char}+.*+{char}         { return symbol(sym.CHAR); }
{identificador}          { return symbol(sym.IDENTIFICADOR); }
{caracteresEspeciales}   { return symbol(sym.CARACTER); }
{digitos}+               { return symbol(sym.ENTERO); }
{digitos}","+ {digitos}+ { return symbol(sym.FLOTANTE); }

}

[^]                    { throw new Error("Caracter ilegal <"+yytext()+">"); }