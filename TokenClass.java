// TokenClass enumeration definition
// TokenClass is an enumeration to represent lexical token classes in the 
// Clite programming language.

public enum TokenClass {
  EOF, 
  // keywords
  BOOL, CHAR, ELSE, FLOAT, IF, INT, MAIN, WHILE, START, FINISH,
  // punctuation
  COMMA, SEMICOLON, LBRACE, RBRACE,
  // operators
  LPAREN, RPAREN, LBRACK, RBRACK, ASSIGN, OR, AND, EQ, NE, LT, LE, GT, GE, DOLLAR,
  PLUS, MINUS, TIMES, SLASH, MOD, NOT,
  // ids and literals
  ID, IDF, INTEGER, BOOLEAN, FLOATLIT, CHARLIT, LITERAL
}
