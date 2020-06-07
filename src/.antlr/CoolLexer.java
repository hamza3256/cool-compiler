// Generated from d:\GitHub\Team_Dijkstra\src\CoolLexer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, PERIOD=2, COMMA=3, AT=4, SEMICOLON=5, COLON=6, CURLY_OPEN=7, 
		CURLY_CLOSE=8, PARENT_OPEN=9, PARENT_CLOSE=10, PLUS_OPERATOR=11, MINUS_OPERATOR=12, 
		MULT_OPERATOR=13, DIV_OPERATOR=14, INT_COMPLEMENT_OPERATOR=15, LESS_OPERATOR=16, 
		LESS_EQ_OPERATOR=17, EQ_OPERATOR=18, ASSIGN_OPERATOR=19, RIGHTARROW=20, 
		CLASS=21, ELSE=22, FALSE=23, FI=24, IF=25, IN=26, INHERITS=27, ISVOID=28, 
		LET=29, LOOP=30, POOL=31, THEN=32, WHILE=33, CASE=34, ESAC=35, NEW=36, 
		OF=37, NOT=38, TRUE=39, INT=40, TYPEID=41, OBJECTID=42, ASSIGNMENT=43, 
		CASE_ARROW=44, ADD=45, MINUS=46, MULTIPLY=47, DIVISION=48, LESS_THAN=49, 
		LESS_EQUAL=50, EQUAL=51, INTEGER_NEGATIVE=52, COMMENT=53, MULTCOMMENT=54, 
		COMMENTCLOSE=55, BEGIN_COMMENT=56, EOF_COM=57, END_COMMENT=58, ONE_LINE_COMMENT=59, 
		END_ONE_COMMENT=60, BLOCK_COMMENT=61, WHITESPACE=62, STR_CONST=63;
	public static final int
		COMMENT_MODE=1, EDIT_MODE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "COMMENT_MODE", "EDIT_MODE"
	};

	public static final String[] ruleNames = {
		"PERIOD", "COMMA", "AT", "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", 
		"PARENT_OPEN", "PARENT_CLOSE", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", 
		"DIV_OPERATOR", "INT_COMPLEMENT_OPERATOR", "LESS_OPERATOR", "LESS_EQ_OPERATOR", 
		"EQ_OPERATOR", "ASSIGN_OPERATOR", "RIGHTARROW", "CLASS", "ELSE", "FALSE", 
		"FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "POOL", "THEN", 
		"WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "INT", "TYPEID", 
		"OBJECTID", "ASSIGNMENT", "CASE_ARROW", "ADD", "MINUS", "MULTIPLY", "DIVISION", 
		"LESS_THAN", "LESS_EQUAL", "EQUAL", "INTEGER_NEGATIVE", "A", "C", "D", 
		"E", "F", "H", "I", "L", "N", "O", "P", "R", "S", "T", "U", "V", "W", 
		"UNICODE", "HEX", "OPEN", "CLOSE", "COMMENT", "MULTCOMMENT", "COMMENTCLOSE", 
		"BEGIN_COMMENT", "EOF_COM", "END_COMMENT", "BEGIN_UNMATCHED", "ONE_LINE_COMMENT", 
		"END_ONE_COMMENT", "BLOCK_COMMENT", "WHITESPACE", "VALID", "ESC", "STR_CONST", 
		"ERROR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'.'", "','", "'@'", "';'", "':'", "'{'", "'}'", "'('", "')'", 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'(*'", null, null, 
		"'--'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "PERIOD", "COMMA", "AT", "SEMICOLON", "COLON", "CURLY_OPEN", 
		"CURLY_CLOSE", "PARENT_OPEN", "PARENT_CLOSE", "PLUS_OPERATOR", "MINUS_OPERATOR", 
		"MULT_OPERATOR", "DIV_OPERATOR", "INT_COMPLEMENT_OPERATOR", "LESS_OPERATOR", 
		"LESS_EQ_OPERATOR", "EQ_OPERATOR", "ASSIGN_OPERATOR", "RIGHTARROW", "CLASS", 
		"ELSE", "FALSE", "FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", 
		"POOL", "THEN", "WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "INT", 
		"TYPEID", "OBJECTID", "ASSIGNMENT", "CASE_ARROW", "ADD", "MINUS", "MULTIPLY", 
		"DIVISION", "LESS_THAN", "LESS_EQUAL", "EQUAL", "INTEGER_NEGATIVE", "COMMENT", 
		"MULTCOMMENT", "COMMENTCLOSE", "BEGIN_COMMENT", "EOF_COM", "END_COMMENT", 
		"ONE_LINE_COMMENT", "END_ONE_COMMENT", "BLOCK_COMMENT", "WHITESPACE", 
		"STR_CONST"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



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
	   String text = t.getText();
	   text = text.substring(1,text.length() - 1);	// removing opening and closing quotes
	   //System.err.println(text);
	   text = text.replace("\\b","\b").replace("\\n","\n").replace("\\t","\t").replace("\\f","\f").replace("\\\n","\n").replace("\\0", "0").replaceAll("\\\\(.)","$1"); // Checking for escaped sequences
	   //System.err.println(text);
	   if(text.contains("\0")) {
	     reportError("String contains escaped null character");
	     return;
	   }
	   if(text.length() > 1024){
	     reportError("String constant too long");	// String const can have maximum length of 1024
	     return;
	   }
	   setText(text);
	 }


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 73:
			MULTCOMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 74:
			COMMENTCLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 76:
			EOF_COM_action((RuleContext)_localctx, actionIndex);
			break;
		case 78:
			BEGIN_UNMATCHED_action((RuleContext)_localctx, actionIndex);
			break;
		case 81:
			BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 85:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 86:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void MULTCOMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		case 1:
			reportError("EOF in comment");
			break;
		}
	}
	private void COMMENTCLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			reportError("Unmatched *)");
			break;
		}
	}
	private void EOF_COM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			reportError("EOF in comment");
			break;
		}
	}
	private void BEGIN_UNMATCHED_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 setText("Unmatched *)"); 
			break;
		}
	}
	private void BLOCK_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			System.err.println("EOF in comment");
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			reportError("Unterminated string constant");
			break;
		case 7:
			reportError("String contains null character.");
			break;
		case 8:
			processString();
			break;
		case 9:
			reportError("EOF in string constant");
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			invalidToken();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u0203\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\6(\u013b"+
		"\n(\r(\16(\u013c\3)\3)\7)\u0141\n)\f)\16)\u0144\13)\3*\3*\7*\u0148\n*"+
		"\f*\16*\u014b\13*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3"+
		"C\3D\3D\3E\3E\3F\3F\3F\3F\3F\3F\3G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3J\7"+
		"J\u0198\nJ\fJ\16J\u019b\13J\3J\3J\3K\3K\3K\7K\u01a2\nK\fK\16K\u01a5\13"+
		"K\3K\3K\3K\3K\3K\5K\u01ac\nK\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3N\3N\3N\3"+
		"O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\3"+
		"S\3S\3S\3S\7S\u01d6\nS\fS\16S\u01d9\13S\3S\3S\3S\3S\5S\u01df\nS\3S\3S"+
		"\3T\6T\u01e4\nT\rT\16T\u01e5\3T\3T\3U\3U\3V\3V\3V\3W\3W\3W\7W\u01f2\n"+
		"W\fW\16W\u01f5\13W\3W\3W\3W\3W\3W\3W\3W\3W\5W\u01ff\nW\3X\3X\3X\5\u01a3"+
		"\u01d7\u01f3\2Y\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087"+
		"\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\67\u00978\u0099"+
		"9\u009b:\u009d;\u009f<\u00a1\2\u00a3=\u00a5>\u00a7?\u00a9@\u00ab\2\u00ad"+
		"\2\u00afA\u00b1\3\5\2\3\4\34\3\2\62;\3\2C\\\6\2\62;C\\aac|\3\2c|\4\2C"+
		"Ccc\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2JJjj\4\2KKkk\4\2NNnn\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\5\2\62"+
		";CHch\4\2\f\f\17\17\4\2\13\17\"\"\5\2\2\2\f\f$$\3\2\2\2\2\u01f9\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a7\3\2\2"+
		"\2\2\u00a9\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\3\u009d\3\2\2\2\3\u009f"+
		"\3\2\2\2\4\u00a5\3\2\2\2\5\u00b3\3\2\2\2\7\u00b5\3\2\2\2\t\u00b7\3\2\2"+
		"\2\13\u00b9\3\2\2\2\r\u00bb\3\2\2\2\17\u00bd\3\2\2\2\21\u00bf\3\2\2\2"+
		"\23\u00c1\3\2\2\2\25\u00c3\3\2\2\2\27\u00c5\3\2\2\2\31\u00c7\3\2\2\2\33"+
		"\u00c9\3\2\2\2\35\u00cb\3\2\2\2\37\u00cd\3\2\2\2!\u00cf\3\2\2\2#\u00d1"+
		"\3\2\2\2%\u00d4\3\2\2\2\'\u00d6\3\2\2\2)\u00d9\3\2\2\2+\u00dc\3\2\2\2"+
		"-\u00e2\3\2\2\2/\u00e7\3\2\2\2\61\u00ed\3\2\2\2\63\u00f0\3\2\2\2\65\u00f3"+
		"\3\2\2\2\67\u00f6\3\2\2\29\u00ff\3\2\2\2;\u0106\3\2\2\2=\u010a\3\2\2\2"+
		"?\u010f\3\2\2\2A\u0114\3\2\2\2C\u0119\3\2\2\2E\u011f\3\2\2\2G\u0124\3"+
		"\2\2\2I\u0129\3\2\2\2K\u012d\3\2\2\2M\u0130\3\2\2\2O\u0134\3\2\2\2Q\u013a"+
		"\3\2\2\2S\u013e\3\2\2\2U\u0145\3\2\2\2W\u014c\3\2\2\2Y\u014f\3\2\2\2["+
		"\u0152\3\2\2\2]\u0154\3\2\2\2_\u0156\3\2\2\2a\u0158\3\2\2\2c\u015a\3\2"+
		"\2\2e\u015c\3\2\2\2g\u015f\3\2\2\2i\u0161\3\2\2\2k\u0163\3\2\2\2m\u0165"+
		"\3\2\2\2o\u0167\3\2\2\2q\u0169\3\2\2\2s\u016b\3\2\2\2u\u016d\3\2\2\2w"+
		"\u016f\3\2\2\2y\u0171\3\2\2\2{\u0173\3\2\2\2}\u0175\3\2\2\2\177\u0177"+
		"\3\2\2\2\u0081\u0179\3\2\2\2\u0083\u017b\3\2\2\2\u0085\u017d\3\2\2\2\u0087"+
		"\u017f\3\2\2\2\u0089\u0181\3\2\2\2\u008b\u0183\3\2\2\2\u008d\u0185\3\2"+
		"\2\2\u008f\u018b\3\2\2\2\u0091\u018d\3\2\2\2\u0093\u0190\3\2\2\2\u0095"+
		"\u0193\3\2\2\2\u0097\u019e\3\2\2\2\u0099\u01ad\3\2\2\2\u009b\u01b2\3\2"+
		"\2\2\u009d\u01b7\3\2\2\2\u009f\u01ba\3\2\2\2\u00a1\u01bf\3\2\2\2\u00a3"+
		"\u01c6\3\2\2\2\u00a5\u01cb\3\2\2\2\u00a7\u01d0\3\2\2\2\u00a9\u01e3\3\2"+
		"\2\2\u00ab\u01e9\3\2\2\2\u00ad\u01eb\3\2\2\2\u00af\u01ee\3\2\2\2\u00b1"+
		"\u0200\3\2\2\2\u00b3\u00b4\7\60\2\2\u00b4\6\3\2\2\2\u00b5\u00b6\7.\2\2"+
		"\u00b6\b\3\2\2\2\u00b7\u00b8\7B\2\2\u00b8\n\3\2\2\2\u00b9\u00ba\7=\2\2"+
		"\u00ba\f\3\2\2\2\u00bb\u00bc\7<\2\2\u00bc\16\3\2\2\2\u00bd\u00be\7}\2"+
		"\2\u00be\20\3\2\2\2\u00bf\u00c0\7\177\2\2\u00c0\22\3\2\2\2\u00c1\u00c2"+
		"\7*\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\7+\2\2\u00c4\26\3\2\2\2\u00c5\u00c6"+
		"\7-\2\2\u00c6\30\3\2\2\2\u00c7\u00c8\7/\2\2\u00c8\32\3\2\2\2\u00c9\u00ca"+
		"\7,\2\2\u00ca\34\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc\36\3\2\2\2\u00cd\u00ce"+
		"\7\u0080\2\2\u00ce \3\2\2\2\u00cf\u00d0\7>\2\2\u00d0\"\3\2\2\2\u00d1\u00d2"+
		"\7>\2\2\u00d2\u00d3\7?\2\2\u00d3$\3\2\2\2\u00d4\u00d5\7?\2\2\u00d5&\3"+
		"\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7/\2\2\u00d8(\3\2\2\2\u00d9\u00da"+
		"\7?\2\2\u00da\u00db\7@\2\2\u00db*\3\2\2\2\u00dc\u00dd\5m\66\2\u00dd\u00de"+
		"\5y<\2\u00de\u00df\5k\65\2\u00df\u00e0\5\u0083A\2\u00e0\u00e1\5\u0083"+
		"A\2\u00e1,\3\2\2\2\u00e2\u00e3\5q8\2\u00e3\u00e4\5y<\2\u00e4\u00e5\5\u0083"+
		"A\2\u00e5\u00e6\5q8\2\u00e6.\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\5"+
		"k\65\2\u00e9\u00ea\5y<\2\u00ea\u00eb\5\u0083A\2\u00eb\u00ec\5q8\2\u00ec"+
		"\60\3\2\2\2\u00ed\u00ee\5s9\2\u00ee\u00ef\5w;\2\u00ef\62\3\2\2\2\u00f0"+
		"\u00f1\5w;\2\u00f1\u00f2\5s9\2\u00f2\64\3\2\2\2\u00f3\u00f4\5w;\2\u00f4"+
		"\u00f5\5{=\2\u00f5\66\3\2\2\2\u00f6\u00f7\5w;\2\u00f7\u00f8\5{=\2\u00f8"+
		"\u00f9\5u:\2\u00f9\u00fa\5q8\2\u00fa\u00fb\5\u0081@\2\u00fb\u00fc\5w;"+
		"\2\u00fc\u00fd\5\u0085B\2\u00fd\u00fe\5\u0083A\2\u00fe8\3\2\2\2\u00ff"+
		"\u0100\5w;\2\u0100\u0101\5\u0083A\2\u0101\u0102\5\u0089D\2\u0102\u0103"+
		"\5}>\2\u0103\u0104\5w;\2\u0104\u0105\5o\67\2\u0105:\3\2\2\2\u0106\u0107"+
		"\5y<\2\u0107\u0108\5q8\2\u0108\u0109\5\u0085B\2\u0109<\3\2\2\2\u010a\u010b"+
		"\5y<\2\u010b\u010c\5}>\2\u010c\u010d\5}>\2\u010d\u010e\5\177?\2\u010e"+
		">\3\2\2\2\u010f\u0110\5\177?\2\u0110\u0111\5}>\2\u0111\u0112\5}>\2\u0112"+
		"\u0113\5y<\2\u0113@\3\2\2\2\u0114\u0115\5\u0085B\2\u0115\u0116\5u:\2\u0116"+
		"\u0117\5q8\2\u0117\u0118\5{=\2\u0118B\3\2\2\2\u0119\u011a\5\u008bE\2\u011a"+
		"\u011b\5u:\2\u011b\u011c\5w;\2\u011c\u011d\5y<\2\u011d\u011e\5q8\2\u011e"+
		"D\3\2\2\2\u011f\u0120\5m\66\2\u0120\u0121\5k\65\2\u0121\u0122\5\u0083"+
		"A\2\u0122\u0123\5q8\2\u0123F\3\2\2\2\u0124\u0125\5q8\2\u0125\u0126\5\u0083"+
		"A\2\u0126\u0127\5k\65\2\u0127\u0128\5m\66\2\u0128H\3\2\2\2\u0129\u012a"+
		"\5{=\2\u012a\u012b\5q8\2\u012b\u012c\5\u008bE\2\u012cJ\3\2\2\2\u012d\u012e"+
		"\5}>\2\u012e\u012f\5s9\2\u012fL\3\2\2\2\u0130\u0131\5{=\2\u0131\u0132"+
		"\5}>\2\u0132\u0133\5\u0085B\2\u0133N\3\2\2\2\u0134\u0135\7v\2\2\u0135"+
		"\u0136\5\u0081@\2\u0136\u0137\5\u0087C\2\u0137\u0138\5q8\2\u0138P\3\2"+
		"\2\2\u0139\u013b\t\2\2\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013dR\3\2\2\2\u013e\u0142\t\3\2\2"+
		"\u013f\u0141\t\4\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143T\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0149\t\5\2\2\u0146\u0148\t\4\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aV\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014c\u014d\7>\2\2\u014d\u014e\7/\2\2\u014eX\3\2\2\2\u014f\u0150"+
		"\7?\2\2\u0150\u0151\7@\2\2\u0151Z\3\2\2\2\u0152\u0153\7-\2\2\u0153\\\3"+
		"\2\2\2\u0154\u0155\7/\2\2\u0155^\3\2\2\2\u0156\u0157\7,\2\2\u0157`\3\2"+
		"\2\2\u0158\u0159\7\61\2\2\u0159b\3\2\2\2\u015a\u015b\7>\2\2\u015bd\3\2"+
		"\2\2\u015c\u015d\7>\2\2\u015d\u015e\7?\2\2\u015ef\3\2\2\2\u015f\u0160"+
		"\7?\2\2\u0160h\3\2\2\2\u0161\u0162\7\u0080\2\2\u0162j\3\2\2\2\u0163\u0164"+
		"\t\6\2\2\u0164l\3\2\2\2\u0165\u0166\t\7\2\2\u0166n\3\2\2\2\u0167\u0168"+
		"\t\b\2\2\u0168p\3\2\2\2\u0169\u016a\t\t\2\2\u016ar\3\2\2\2\u016b\u016c"+
		"\t\n\2\2\u016ct\3\2\2\2\u016d\u016e\t\13\2\2\u016ev\3\2\2\2\u016f\u0170"+
		"\t\f\2\2\u0170x\3\2\2\2\u0171\u0172\t\r\2\2\u0172z\3\2\2\2\u0173\u0174"+
		"\t\16\2\2\u0174|\3\2\2\2\u0175\u0176\t\17\2\2\u0176~\3\2\2\2\u0177\u0178"+
		"\t\20\2\2\u0178\u0080\3\2\2\2\u0179\u017a\t\21\2\2\u017a\u0082\3\2\2\2"+
		"\u017b\u017c\t\22\2\2\u017c\u0084\3\2\2\2\u017d\u017e\t\23\2\2\u017e\u0086"+
		"\3\2\2\2\u017f\u0180\t\24\2\2\u0180\u0088\3\2\2\2\u0181\u0182\t\25\2\2"+
		"\u0182\u008a\3\2\2\2\u0183\u0184\t\26\2\2\u0184\u008c\3\2\2\2\u0185\u0186"+
		"\7w\2\2\u0186\u0187\5\u008fG\2\u0187\u0188\5\u008fG\2\u0188\u0189\5\u008f"+
		"G\2\u0189\u018a\5\u008fG\2\u018a\u008e\3\2\2\2\u018b\u018c\t\27\2\2\u018c"+
		"\u0090\3\2\2\2\u018d\u018e\7*\2\2\u018e\u018f\7,\2\2\u018f\u0092\3\2\2"+
		"\2\u0190\u0191\7,\2\2\u0191\u0192\7+\2\2\u0192\u0094\3\2\2\2\u0193\u0194"+
		"\7/\2\2\u0194\u0195\7/\2\2\u0195\u0199\3\2\2\2\u0196\u0198\n\30\2\2\u0197"+
		"\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u019c\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u019d\bJ\2\2\u019d"+
		"\u0096\3\2\2\2\u019e\u01a3\5\u0091H\2\u019f\u01a2\5\u0097K\2\u01a0\u01a2"+
		"\13\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2"+
		"\u01a3\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01ab\3\2\2\2\u01a5\u01a3"+
		"\3\2\2\2\u01a6\u01a7\5\u0093I\2\u01a7\u01a8\bK\3\2\u01a8\u01ac\3\2\2\2"+
		"\u01a9\u01aa\7\2\2\3\u01aa\u01ac\bK\4\2\u01ab\u01a6\3\2\2\2\u01ab\u01a9"+
		"\3\2\2\2\u01ac\u0098\3\2\2\2\u01ad\u01ae\7,\2\2\u01ae\u01af\7+\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01b1\bL\5\2\u01b1\u009a\3\2\2\2\u01b2\u01b3\7*\2"+
		"\2\u01b3\u01b4\7,\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\bM\6\2\u01b6\u009c"+
		"\3\2\2\2\u01b7\u01b8\7\2\2\3\u01b8\u01b9\bN\7\2\u01b9\u009e\3\2\2\2\u01ba"+
		"\u01bb\7,\2\2\u01bb\u01bc\7+\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\bO\b"+
		"\2\u01be\u00a0\3\2\2\2\u01bf\u01c0\7,\2\2\u01c0\u01c1\7+\2\2\u01c1\u01c2"+
		"\3\2\2\2\u01c2\u01c3\bP\t\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\bP\n\2\u01c5"+
		"\u00a2\3\2\2\2\u01c6\u01c7\7/\2\2\u01c7\u01c8\7/\2\2\u01c8\u01c9\3\2\2"+
		"\2\u01c9\u01ca\bQ\13\2\u01ca\u00a4\3\2\2\2\u01cb\u01cc\7\f\2\2\u01cc\u01cd"+
		"\3\2\2\2\u01cd\u01ce\bR\2\2\u01ce\u01cf\bR\b\2\u01cf\u00a6\3\2\2\2\u01d0"+
		"\u01d1\7*\2\2\u01d1\u01d2\7,\2\2\u01d2\u01d7\3\2\2\2\u01d3\u01d6\5\u00a7"+
		"S\2\u01d4\u01d6\13\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6"+
		"\u01d9\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01de\3\2"+
		"\2\2\u01d9\u01d7\3\2\2\2\u01da\u01db\7,\2\2\u01db\u01df\7+\2\2\u01dc\u01dd"+
		"\7\2\2\3\u01dd\u01df\bS\f\2\u01de\u01da\3\2\2\2\u01de\u01dc\3\2\2\2\u01df"+
		"\u01e0\3\2\2\2\u01e0\u01e1\bS\2\2\u01e1\u00a8\3\2\2\2\u01e2\u01e4\t\31"+
		"\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\bT\2\2\u01e8\u00aa\3\2"+
		"\2\2\u01e9\u01ea\n\32\2\2\u01ea\u00ac\3\2\2\2\u01eb\u01ec\7^\2\2\u01ec"+
		"\u01ed\13\2\2\2\u01ed\u00ae\3\2\2\2\u01ee\u01f3\7$\2\2\u01ef\u01f2\5\u00ad"+
		"V\2\u01f0\u01f2\5\u00abU\2\u01f1\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"\u01f5\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01fe\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f7\7\f\2\2\u01f7\u01ff\bW\r\2\u01f8"+
		"\u01f9\t\33\2\2\u01f9\u01ff\bW\16\2\u01fa\u01fb\7$\2\2\u01fb\u01ff\bW"+
		"\17\2\u01fc\u01fd\7\2\2\3\u01fd\u01ff\bW\20\2\u01fe\u01f6\3\2\2\2\u01fe"+
		"\u01f8\3\2\2\2\u01fe\u01fa\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u00b0\3\2"+
		"\2\2\u0200\u0201\13\2\2\2\u0201\u0202\bX\21\2\u0202\u00b2\3\2\2\2\23\2"+
		"\3\4\u013c\u0142\u0149\u0199\u01a1\u01a3\u01ab\u01d5\u01d7\u01de\u01e5"+
		"\u01f1\u01f3\u01fe\22\b\2\2\3K\2\3K\3\3L\4\7\3\2\3N\5\6\2\2\3P\6\t\3\2"+
		"\7\4\2\3S\7\3W\b\3W\t\3W\n\3W\13\3X\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}