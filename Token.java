// Token class definition
// Token is a class to represent lexical tokens in the Clite programming 
// language, described in Programming Languages: Principles and Paradigms, 
// 2nd ed., by Allen B. Tucker and Robert E. Noonan, McGraw Hill, 2007.

public class Token {

  private TokenClass symbol;	// current token
  private String lexeme;	// lexeme

  public Token () { }

  public Token (TokenClass symbol) {
    this (symbol, null);
  }

  public Token (TokenClass symbol, String lexeme) {
    this . symbol = symbol;
    this . lexeme  = lexeme;
  }

  public TokenClass symbol () { return symbol; }

  public String lexeme () { return lexeme; }

  public String toString () {
    switch (symbol) {
      case DOLLAR :    return "(operator, $) ";
      case BOOL :      return "(keyword, bool) ";
      case CHAR :      return "(keyword, char) ";
      case ELSE :      return "(keyword, else) ";
      case FLOAT :     return "(keyword, float) ";
      case IF :        return "(keyword, if) ";
      case INT :       return "(keyword, int) ";
      case MAIN :      return "(keyword, main) ";
      case WHILE :     return "(keyword, while) ";
      case COMMA :     return "(punctuation, ,) ";
      case SEMICOLON : return "(punctuation, ;) ";
      case LBRACE :    return "(punctuation, {) ";
      case RBRACE :    return "(punctuation, }) ";
      case LPAREN :    return "(operator, () ";
      case RPAREN :    return "(operator, )) ";
      case LBRACK :    return "(operator, [) ";
      case RBRACK :    return "(operator, ]) ";
      case ASSIGN :    return "(operator, =) ";
      case OR :        return "(operator, ||) ";
      case AND :       return "(operator, &&) ";
      case PLUS :      return "(operator, +) ";
      case MINUS :     return "(operator, -) ";
      case TIMES :     return "(operator, *) ";
      case SLASH :     return "(operator, /) ";
      case MOD :       return "(operator, %) ";
      case EQ :        return "(operator, ==) ";
      case NE :        return "(operator, !=) ";
      case LT :        return "(operator, <) ";
      case LE :        return "(operator, <=) ";
      case GT :        return "(operator, >) ";
      case GE :        return "(operator, >=) ";
      case NOT :       return "(operator, !) ";
      case ID :        return "(identifier, " + lexeme + ") ";
      case IDF :       return "(identifier, " + lexeme + ") ";
      case INTEGER :   return "(integer, " + lexeme + ") ";
      case LITERAL  :  return "(literal, " + lexeme + ") ";
      case START  :    return "(start php, <?php) ";
      case FINISH  :      return "(end php, ?>) ";
      default : 
	ErrorMessage . print (0, "Unrecognized token");
        return null;
    }
  }

}
