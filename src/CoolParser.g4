/**
 * Define a grammar for Cool
 */
parser grammar CoolParser;

options { tokenVocab = CoolLexer; }

@parser::members {
    String file = _input.getSourceName();
}


/*  Starting point for parsing a Cool file  */
error : ERROR | expression LESS_EQ_OP expression LESS_EQ_OP expression
    {}
    ;

program
	: (coolClass SEMICOLON)+ EOF
	;
coolClass locals [String fileName]
	: CLASS TYPEID (INHERITS TYPEID)? CUR_OPEN (feature SEMICOLON)* CUR_CLOSE {$fileName = getSourceName();}
    ;

feature
	: OBJECTID COLON TYPEID (ASSIGN_OP expression )? #attribute
	| OBJECTID PAR_OPEN (formal (COMMA formal)*)? PAR_CLOSE COLON TYPEID CUR_OPEN expression CUR_CLOSE #method
	;

formal
	: OBJECTID COLON TYPEID
	;

string_
    : STR_Q (WORD | SLASH | COMMA | PERIOD | UNDERSCORE)* STR_Q;

expression
	:
	expression PERIOD OBJECTID PAR_OPEN (expression (COMMA expression)*)? PAR_CLOSE #dispatch
	| OBJECTID PAR_OPEN (expression (COMMA expression)*)? PAR_CLOSE #selfdispatch
	| expression AT TYPEID PERIOD OBJECTID PAR_OPEN (expression (COMMA expression)*)? PAR_CLOSE #staticdispatch
		| expression (MULT_OP | DIV_OP) expression #multdiv
        | expression (PLUS_OP | MINUS_OP) expression #plusminus
    	| expression LESS_OP expression #less
    	| expression LESS_EQ_OP expression #less_eq
    	| expression EQ_OP expression # eq
      | INT #int
    	| STR_CONST #str
      | BOOL_CONST #bool
    	| OBJECTID #OBJECTID
    	| OBJECTID ASSIGN_OP expression #assign
      | TRUE # true
      | FALSE # false
    	| NOT expression #bool_complement
    	| PAR_OPEN expression PAR_CLOSE #paren_expr

	| IF expression THEN expression ELSE expression FI #if
	| WHILE expression LOOP expression POOL #loop
  | '{' (expression ';')+ '}' # block
	| CUR_OPEN (expression SEMICOLON)+ CUR_CLOSE #block
  | CASE expression OF (OBJECTID COLON TYPEID RIGHTARROW expression SEMICOLON)+ ESAC #case
	| LET OBJECTID COLON TYPEID IN expression #let
	| LET OBJECTID COLON TYPEID ASSIGN_OP expression IN expression #letInit
	| NEW TYPEID #new
	| ISVOID expression #isvoid
	| INT_COMPLEMENT_OP expression #int_complement
	;
