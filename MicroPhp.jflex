%%
%{
  private void echo () { System . out . print (yytext ()); }

  public int position () { return yycolumn; }
%}

%class    MicroPhpLexer
%function nextToken
%type	  Token
%unicode
%line
%column
%eofval{
  { return new Token (TokenClass . EOF); }
%eofval}

Comment		= "//".*
WhiteSpace	= [ \t\n]
IdentifierFunc	= ([:letter:] | "_"?) (([:letter:] | [:digit:])* | "_"?)*
IdentifierVar = "$" ([:letter:] | "_"?) (([:letter:] | [:digit:])* | "_"?)*
Integer		= [:digit:] [:digit:]*
Literal		= Integer?

%%
{Comment}		{ echo (); }
{WhiteSpace}	{ echo (); }
"$"		{ echo (); return new Token (TokenClass . DOLLAR); }
","		{ echo (); return new Token (TokenClass . COMMA); }
";"		{ echo (); return new Token (TokenClass . SEMICOLON); }
"{"		{ echo (); return new Token (TokenClass . LBRACE); }
"}"		{ echo (); return new Token (TokenClass . RBRACE); }
"("		{ echo (); return new Token (TokenClass . LPAREN); }
")"		{ echo (); return new Token (TokenClass . RPAREN); }
"["		{ echo (); return new Token (TokenClass . LBRACK); }
"]"		{ echo (); return new Token (TokenClass . RBRACK); }
"="		{ echo (); return new Token (TokenClass . ASSIGN); }
"||"		{ echo (); return new Token (TokenClass . OR); }
"&&"		{ echo (); return new Token (TokenClass . AND); }
"+"		{ echo (); return new Token (TokenClass . PLUS); }
"-"		{ echo (); return new Token (TokenClass . MINUS); }
"*"		{ echo (); return new Token (TokenClass . TIMES); }
"/"		{ echo (); return new Token (TokenClass . SLASH); }
"%"		{ echo (); return new Token (TokenClass . MOD); }
"=="		{ echo (); return new Token (TokenClass . EQ); }
"!="		{ echo (); return new Token (TokenClass . NE); }
"<"		{ echo (); return new Token (TokenClass . LT); }
"<="		{ echo (); return new Token (TokenClass . LE); }
">"		{ echo (); return new Token (TokenClass . GT); }
">="		{ echo (); return new Token (TokenClass . GE); }
"!"		{ echo (); return new Token (TokenClass . NOT); }
else	{ echo (); return new Token (TokenClass . ELSE); }
if 		{ echo (); return new Token (TokenClass . IF); }
while	{ echo (); return new Token (TokenClass . WHILE); }
"<?php"	{ echo (); return new Token (TokenClass . START); }
"?>"	{ echo (); return new Token (TokenClass . FINISH); }
{Integer}	{ echo (); return new Token (TokenClass . INTEGER, yytext ()); }
{IdentifierVar}	{ echo (); return new Token (TokenClass . ID, yytext ()); }
{IdentifierFunc}	{echo (); return new Token (TokenClass . IDF, yytext ()); }
{Literal}	{ echo (); return new Token (TokenClass . LITERAL, yytext ()); }
.		{ echo (); ErrorMessage . print (yychar, "Illegal character"); }