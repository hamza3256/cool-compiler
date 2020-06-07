/**
 * Define a lexer rules for Cool
 */
lexer grammar CoolLexer;

tokens {
  ERROR
}

@members{
 public void invalidToken(){
   Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
   String text = t.getText();
   reportError(text);
 }

 public void reportError(String errorString){
   setText(errorString);
   setType(ERROR);
 }

 public void processString() {
   Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
   String str = t.getText();
   str = str.substring(1,str.length()-1);
   str = str.replace("\\b","\b").replace("\\n","\n").replace("\\t","\t").replace("\\f","\f").replace("\\\n","\n").replace("\0", "\\\0").replace("\\0", "\0");
   if(str.length() > 1024){
     reportError("String constant too long");	// String const can have maximum length of 1024
     return;
   }
   setText(str);
 }
}

/* Punctuation */

PERIOD              : '.';
COMMA               : ',';
AT                  : '@';
SEMICOLON           : ';';
COLON               : ':';

CUR_OPEN          : '{' ;
CUR_CLOSE         : '}' ;
PAR_OPEN         : '(' ;
PAR_CLOSE        : ')' ;

/* Operators */

PLUS_OP       : '+';
MINUS_OP      : '-';
MULT_OP       : '*';
DIV_OP        : '/';

INT_COMPLEMENT_OP     : '~';

LESS_OP               : '<';
LESS_EQ_OP           : '<=';
EQ_OP                 : '=' ;
ASSIGN_OP 	          : '<-';
RIGHTARROW             : '=>';

BOOL_CONST   : T R U E | F A L S E;


CLASS
   : C L A S S
   ;

ELSE
   : E L S E
   ;

FALSE
   : F A L S E
   ;

FI
   : F I
   ;

IF
   : I F
   ;

IN
   : I N
   ;

INHERITS
   : I N H E R I T S
   ;

ISVOID
   : I S V O I D
   ;

LET
   : L E T
   ;

LOOP
   : L O O P
   ;

POOL
   : P O O L
   ;

THEN
   : T H E N
   ;

WHILE
   : W H I L E
   ;

CASE
   : C A S E
   ;

ESAC
   : E S A C
   ;

NEW
   : N E W
   ;

OF
   : O F
   ;

NOT
   : N O T
   ;

TRUE
   : T R U E
   ;
   // primitives



INT
   : [0-9]+
   ;
TYPEID
   : [A-Z] [A-Za-z1-9_]*
   ;
OBJECTID
   : [a-z] [A-Za-z1-9_]*
   ;
ASSIGNMENT
   : '<-'
   ;
CASE_ARROW
   : '=>'
   ;
ADD
   : '+'
   ;
MINUS
   : '-'
   ;
MULTIPLY
   : '*'
   ;
DIVISION
   : '/'
   ;
LESS_THAN
   : '<'
   ;
LESS_EQUAL
   : '<='
   ;
EQUAL
   : '='
   ;
INTEGER_NEGATIVE
   : '~'
   ;
fragment A
   : [aA]
   ;
fragment C
   : [cC]
   ;
fragment D
   : [dD]
   ;
fragment E
   : [eE]
   ;
fragment F
   : [fF]
   ;
fragment H
   : [hH]
   ;
fragment I
   : [iI]
   ;
fragment L
   : [lL]
   ;
fragment N
   : [nN]
   ;
fragment O
   : [oO]
   ;
fragment P
   : [pP]
   ;
fragment R
   : [rR]
   ;
fragment S
   : [sS]
   ;
fragment T
   : [tT]
   ;
fragment U
   : [uU]
   ;
fragment V
   : [vV]
   ;
fragment W
   : [wW]
   ;

/* fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ; */
fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;


   // comments
fragment OPEN	: '(*';
fragment CLOSE	: '*)';
COMMENT 	: '--'  ~('\n' | '\r')* -> skip;
MULTCOMMENT	: OPEN (MULTCOMMENT|.)*?
 		(CLOSE	{skip();}
 		|EOF	{reportError("EOF in comment");}
 		)  ;
COMMENTCLOSE	: '*)'  {reportError("Unmatched *)");} ;
BEGIN_COMMENT: '(*' -> pushMode(COMMENT_MODE);
mode COMMENT_MODE;
EOF_COM    : EOF {reportError("EOF in comment");};
END_COMMENT: '*)' -> popMode;
mode DEFAULT_MODE;

BEGIN_UNMATCHED: '*)'
	{ setText("Unmatched *)"); }
	-> type(ERROR);

ONE_LINE_COMMENT: '--' -> pushMode(EDIT_MODE);
mode EDIT_MODE;
END_ONE_COMMENT: ( '\n') -> skip, popMode;
mode DEFAULT_MODE;


BLOCK_COMMENT : '(*' (BLOCK_COMMENT|.)*? ('*)' |
EOF {System.err.println("EOF in comment");}) -> skip
  ;

WHITESPACE
 : (' ' | '\n' | '\t' | '\r' | '\f' | '\u000B')+ -> skip
 ;


fragment VALID : ~('\n' | '"' | [\u0000] );
fragment ESC: '\\'.;



STR_CONST: '"'(ESC|VALID)*?
  ('\n'	{reportError("Unterminated string constant");}
  | (('\\'~[\u0000] | ~[\u0000]*) ('\u0000'))+ ('\\'~[\u0000] | VALID* [EOF\\n\"])+ {reportError("String contains null character.");}
  | '\u0000' {reportError("String contains null character.");}
  | '"' {processString();}
  | EOF {reportError("EOF in string constant");}
  );

INVALID	: . {invalidToken();} ;
