// Generated from /home/raj/cool/distro/src/CoolLexer.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PERIOD=1, COMMA=2, AT=3, SEMICOLON=4, COLON=5, CURLY_OPEN=6, CURLY_CLOSE=7, 
		PARENT_OPEN=8, PARENT_CLOSE=9, PLUS_OPERATOR=10, MINUS_OPERATOR=11, MULT_OPERATOR=12, 
		DIV_OPERATOR=13, INT_COMPLEMENT_OPERATOR=14, LESS_OPERATOR=15, LESS_EQ_OPERATOR=16, 
		EQ_OPERATOR=17, ASSIGN_OPERATOR=18, RIGHTARROW=19, CLASS=20, ELSE=21, 
		FALSE=22, FI=23, IF=24, IN=25, INHERITS=26, ISVOID=27, LET=28, LOOP=29, 
		POOL=30, THEN=31, WHILE=32, CASE=33, ESAC=34, NEW=35, OF=36, NOT=37, TRUE=38, 
		STRING=39, INT=40, TYPEID=41, OBJECTID=42, ASSIGNMENT=43, CASE_ARROW=44, 
		ADD=45, MINUS=46, MULTIPLY=47, DIVISION=48, LESS_THAN=49, LESS_EQUAL=50, 
		EQUAL=51, INTEGER_NEGATIVE=52, OPEN_COMMENT=53, CLOSE_COMMENT=54, COMMENT=55, 
		ONE_LINE_COMMENT=56, WHITESPACE=57, ERROR=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PERIOD", "COMMA", "AT", "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", 
		"PARENT_OPEN", "PARENT_CLOSE", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", 
		"DIV_OPERATOR", "INT_COMPLEMENT_OPERATOR", "LESS_OPERATOR", "LESS_EQ_OPERATOR", 
		"EQ_OPERATOR", "ASSIGN_OPERATOR", "RIGHTARROW", "CLASS", "ELSE", "FALSE", 
		"FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "POOL", "THEN", 
		"WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "STRING", "INT", 
		"TYPEID", "OBJECTID", "ASSIGNMENT", "CASE_ARROW", "ADD", "MINUS", "MULTIPLY", 
		"DIVISION", "LESS_THAN", "LESS_EQUAL", "EQUAL", "INTEGER_NEGATIVE", "A", 
		"C", "D", "E", "F", "H", "I", "L", "N", "O", "P", "R", "S", "T", "U", 
		"V", "W", "ESC", "UNICODE", "HEX", "OPEN_COMMENT", "CLOSE_COMMENT", "COMMENT", 
		"ONE_LINE_COMMENT", "WHITESPACE", "ERROR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "','", "'@'", "';'", "':'", "'{'", "'}'", "'('", "')'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PERIOD", "COMMA", "AT", "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", 
		"PARENT_OPEN", "PARENT_CLOSE", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", 
		"DIV_OPERATOR", "INT_COMPLEMENT_OPERATOR", "LESS_OPERATOR", "LESS_EQ_OPERATOR", 
		"EQ_OPERATOR", "ASSIGN_OPERATOR", "RIGHTARROW", "CLASS", "ELSE", "FALSE", 
		"FI", "IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "POOL", "THEN", 
		"WHILE", "CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "STRING", "INT", 
		"TYPEID", "OBJECTID", "ASSIGNMENT", "CASE_ARROW", "ADD", "MINUS", "MULTIPLY", 
		"DIVISION", "LESS_THAN", "LESS_EQUAL", "EQUAL", "INTEGER_NEGATIVE", "OPEN_COMMENT", 
		"CLOSE_COMMENT", "COMMENT", "ONE_LINE_COMMENT", "WHITESPACE", "ERROR"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u01b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\7(\u0129\n(\f(\16(\u012c\13(\3(\3(\3)\6)\u0131\n)\r)\16)\u0132\3"+
		"*\3*\7*\u0137\n*\f*\16*\u013a\13*\3+\3+\7+\u013e\n+\f+\16+\u0141\13+\3"+
		",\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3"+
		"<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3"+
		"G\3G\5G\u017f\nG\3H\3H\3H\3H\3H\3H\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L\7"+
		"L\u0192\nL\fL\16L\u0195\13L\3L\3L\3L\3L\3M\3M\3M\3M\7M\u019f\nM\fM\16"+
		"M\u01a2\13M\3M\5M\u01a5\nM\3M\3M\3N\6N\u01aa\nN\rN\16N\u01ab\3N\3N\3O"+
		"\3O\3\u0193\2P\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087"+
		"\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\67\u00958\u00979\u0099"+
		":\u009b;\u009d<\3\2\34\4\2$$^^\3\2\62;\3\2C\\\6\2\62;C\\aac|\3\2c|\4\2"+
		"CCcc\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2JJjj\4\2KKkk\4\2NNnn\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\n\2$$\61"+
		"\61^^ddhhppttvv\5\2\62;CHch\3\2\f\f\5\2\13\f\16\17\"\"\u01a7\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\3\u009f"+
		"\3\2\2\2\5\u00a1\3\2\2\2\7\u00a3\3\2\2\2\t\u00a5\3\2\2\2\13\u00a7\3\2"+
		"\2\2\r\u00a9\3\2\2\2\17\u00ab\3\2\2\2\21\u00ad\3\2\2\2\23\u00af\3\2\2"+
		"\2\25\u00b1\3\2\2\2\27\u00b3\3\2\2\2\31\u00b5\3\2\2\2\33\u00b7\3\2\2\2"+
		"\35\u00b9\3\2\2\2\37\u00bb\3\2\2\2!\u00bd\3\2\2\2#\u00c0\3\2\2\2%\u00c2"+
		"\3\2\2\2\'\u00c5\3\2\2\2)\u00c8\3\2\2\2+\u00ce\3\2\2\2-\u00d3\3\2\2\2"+
		"/\u00d9\3\2\2\2\61\u00dc\3\2\2\2\63\u00df\3\2\2\2\65\u00e2\3\2\2\2\67"+
		"\u00eb\3\2\2\29\u00f2\3\2\2\2;\u00f6\3\2\2\2=\u00fb\3\2\2\2?\u0100\3\2"+
		"\2\2A\u0105\3\2\2\2C\u010b\3\2\2\2E\u0110\3\2\2\2G\u0115\3\2\2\2I\u0119"+
		"\3\2\2\2K\u011c\3\2\2\2M\u0120\3\2\2\2O\u0125\3\2\2\2Q\u0130\3\2\2\2S"+
		"\u0134\3\2\2\2U\u013b\3\2\2\2W\u0142\3\2\2\2Y\u0145\3\2\2\2[\u0148\3\2"+
		"\2\2]\u014a\3\2\2\2_\u014c\3\2\2\2a\u014e\3\2\2\2c\u0150\3\2\2\2e\u0152"+
		"\3\2\2\2g\u0155\3\2\2\2i\u0157\3\2\2\2k\u0159\3\2\2\2m\u015b\3\2\2\2o"+
		"\u015d\3\2\2\2q\u015f\3\2\2\2s\u0161\3\2\2\2u\u0163\3\2\2\2w\u0165\3\2"+
		"\2\2y\u0167\3\2\2\2{\u0169\3\2\2\2}\u016b\3\2\2\2\177\u016d\3\2\2\2\u0081"+
		"\u016f\3\2\2\2\u0083\u0171\3\2\2\2\u0085\u0173\3\2\2\2\u0087\u0175\3\2"+
		"\2\2\u0089\u0177\3\2\2\2\u008b\u0179\3\2\2\2\u008d\u017b\3\2\2\2\u008f"+
		"\u0180\3\2\2\2\u0091\u0186\3\2\2\2\u0093\u0188\3\2\2\2\u0095\u018b\3\2"+
		"\2\2\u0097\u018e\3\2\2\2\u0099\u019a\3\2\2\2\u009b\u01a9\3\2\2\2\u009d"+
		"\u01af\3\2\2\2\u009f\u00a0\7\60\2\2\u00a0\4\3\2\2\2\u00a1\u00a2\7.\2\2"+
		"\u00a2\6\3\2\2\2\u00a3\u00a4\7B\2\2\u00a4\b\3\2\2\2\u00a5\u00a6\7=\2\2"+
		"\u00a6\n\3\2\2\2\u00a7\u00a8\7<\2\2\u00a8\f\3\2\2\2\u00a9\u00aa\7}\2\2"+
		"\u00aa\16\3\2\2\2\u00ab\u00ac\7\177\2\2\u00ac\20\3\2\2\2\u00ad\u00ae\7"+
		"*\2\2\u00ae\22\3\2\2\2\u00af\u00b0\7+\2\2\u00b0\24\3\2\2\2\u00b1\u00b2"+
		"\7-\2\2\u00b2\26\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4\30\3\2\2\2\u00b5\u00b6"+
		"\7,\2\2\u00b6\32\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\34\3\2\2\2\u00b9\u00ba"+
		"\7\u0080\2\2\u00ba\36\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc \3\2\2\2\u00bd"+
		"\u00be\7>\2\2\u00be\u00bf\7?\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1"+
		"$\3\2\2\2\u00c2\u00c3\7>\2\2\u00c3\u00c4\7/\2\2\u00c4&\3\2\2\2\u00c5\u00c6"+
		"\7?\2\2\u00c6\u00c7\7@\2\2\u00c7(\3\2\2\2\u00c8\u00c9\5m\67\2\u00c9\u00ca"+
		"\5y=\2\u00ca\u00cb\5k\66\2\u00cb\u00cc\5\u0083B\2\u00cc\u00cd\5\u0083"+
		"B\2\u00cd*\3\2\2\2\u00ce\u00cf\5q9\2\u00cf\u00d0\5y=\2\u00d0\u00d1\5\u0083"+
		"B\2\u00d1\u00d2\5q9\2\u00d2,\3\2\2\2\u00d3\u00d4\7h\2\2\u00d4\u00d5\5"+
		"k\66\2\u00d5\u00d6\5y=\2\u00d6\u00d7\5\u0083B\2\u00d7\u00d8\5q9\2\u00d8"+
		".\3\2\2\2\u00d9\u00da\5s:\2\u00da\u00db\5w<\2\u00db\60\3\2\2\2\u00dc\u00dd"+
		"\5w<\2\u00dd\u00de\5s:\2\u00de\62\3\2\2\2\u00df\u00e0\5w<\2\u00e0\u00e1"+
		"\5{>\2\u00e1\64\3\2\2\2\u00e2\u00e3\5w<\2\u00e3\u00e4\5{>\2\u00e4\u00e5"+
		"\5u;\2\u00e5\u00e6\5q9\2\u00e6\u00e7\5\u0081A\2\u00e7\u00e8\5w<\2\u00e8"+
		"\u00e9\5\u0085C\2\u00e9\u00ea\5\u0083B\2\u00ea\66\3\2\2\2\u00eb\u00ec"+
		"\5w<\2\u00ec\u00ed\5\u0083B\2\u00ed\u00ee\5\u0089E\2\u00ee\u00ef\5}?\2"+
		"\u00ef\u00f0\5w<\2\u00f0\u00f1\5o8\2\u00f18\3\2\2\2\u00f2\u00f3\5y=\2"+
		"\u00f3\u00f4\5q9\2\u00f4\u00f5\5\u0085C\2\u00f5:\3\2\2\2\u00f6\u00f7\5"+
		"y=\2\u00f7\u00f8\5}?\2\u00f8\u00f9\5}?\2\u00f9\u00fa\5\177@\2\u00fa<\3"+
		"\2\2\2\u00fb\u00fc\5\177@\2\u00fc\u00fd\5}?\2\u00fd\u00fe\5}?\2\u00fe"+
		"\u00ff\5y=\2\u00ff>\3\2\2\2\u0100\u0101\5\u0085C\2\u0101\u0102\5u;\2\u0102"+
		"\u0103\5q9\2\u0103\u0104\5{>\2\u0104@\3\2\2\2\u0105\u0106\5\u008bF\2\u0106"+
		"\u0107\5u;\2\u0107\u0108\5w<\2\u0108\u0109\5y=\2\u0109\u010a\5q9\2\u010a"+
		"B\3\2\2\2\u010b\u010c\5m\67\2\u010c\u010d\5k\66\2\u010d\u010e\5\u0083"+
		"B\2\u010e\u010f\5q9\2\u010fD\3\2\2\2\u0110\u0111\5q9\2\u0111\u0112\5\u0083"+
		"B\2\u0112\u0113\5k\66\2\u0113\u0114\5m\67\2\u0114F\3\2\2\2\u0115\u0116"+
		"\5{>\2\u0116\u0117\5q9\2\u0117\u0118\5\u008bF\2\u0118H\3\2\2\2\u0119\u011a"+
		"\5}?\2\u011a\u011b\5s:\2\u011bJ\3\2\2\2\u011c\u011d\5{>\2\u011d\u011e"+
		"\5}?\2\u011e\u011f\5\u0085C\2\u011fL\3\2\2\2\u0120\u0121\7v\2\2\u0121"+
		"\u0122\5\u0081A\2\u0122\u0123\5\u0087D\2\u0123\u0124\5q9\2\u0124N\3\2"+
		"\2\2\u0125\u012a\7$\2\2\u0126\u0129\5\u008dG\2\u0127\u0129\n\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u012e\7$\2\2\u012eP\3\2\2\2\u012f\u0131\t\3\2\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133R\3\2\2\2"+
		"\u0134\u0138\t\4\2\2\u0135\u0137\t\5\2\2\u0136\u0135\3\2\2\2\u0137\u013a"+
		"\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139T\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013b\u013f\t\6\2\2\u013c\u013e\t\5\2\2\u013d\u013c\3\2"+
		"\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"V\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7>\2\2\u0143\u0144\7/\2\2\u0144"+
		"X\3\2\2\2\u0145\u0146\7?\2\2\u0146\u0147\7@\2\2\u0147Z\3\2\2\2\u0148\u0149"+
		"\7-\2\2\u0149\\\3\2\2\2\u014a\u014b\7/\2\2\u014b^\3\2\2\2\u014c\u014d"+
		"\7,\2\2\u014d`\3\2\2\2\u014e\u014f\7\61\2\2\u014fb\3\2\2\2\u0150\u0151"+
		"\7>\2\2\u0151d\3\2\2\2\u0152\u0153\7>\2\2\u0153\u0154\7?\2\2\u0154f\3"+
		"\2\2\2\u0155\u0156\7?\2\2\u0156h\3\2\2\2\u0157\u0158\7\u0080\2\2\u0158"+
		"j\3\2\2\2\u0159\u015a\t\7\2\2\u015al\3\2\2\2\u015b\u015c\t\b\2\2\u015c"+
		"n\3\2\2\2\u015d\u015e\t\t\2\2\u015ep\3\2\2\2\u015f\u0160\t\n\2\2\u0160"+
		"r\3\2\2\2\u0161\u0162\t\13\2\2\u0162t\3\2\2\2\u0163\u0164\t\f\2\2\u0164"+
		"v\3\2\2\2\u0165\u0166\t\r\2\2\u0166x\3\2\2\2\u0167\u0168\t\16\2\2\u0168"+
		"z\3\2\2\2\u0169\u016a\t\17\2\2\u016a|\3\2\2\2\u016b\u016c\t\20\2\2\u016c"+
		"~\3\2\2\2\u016d\u016e\t\21\2\2\u016e\u0080\3\2\2\2\u016f\u0170\t\22\2"+
		"\2\u0170\u0082\3\2\2\2\u0171\u0172\t\23\2\2\u0172\u0084\3\2\2\2\u0173"+
		"\u0174\t\24\2\2\u0174\u0086\3\2\2\2\u0175\u0176\t\25\2\2\u0176\u0088\3"+
		"\2\2\2\u0177\u0178\t\26\2\2\u0178\u008a\3\2\2\2\u0179\u017a\t\27\2\2\u017a"+
		"\u008c\3\2\2\2\u017b\u017e\7^\2\2\u017c\u017f\t\30\2\2\u017d\u017f\5\u008f"+
		"H\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u008e\3\2\2\2\u0180"+
		"\u0181\7w\2\2\u0181\u0182\5\u0091I\2\u0182\u0183\5\u0091I\2\u0183\u0184"+
		"\5\u0091I\2\u0184\u0185\5\u0091I\2\u0185\u0090\3\2\2\2\u0186\u0187\t\31"+
		"\2\2\u0187\u0092\3\2\2\2\u0188\u0189\7*\2\2\u0189\u018a\7,\2\2\u018a\u0094"+
		"\3\2\2\2\u018b\u018c\7,\2\2\u018c\u018d\7+\2\2\u018d\u0096\3\2\2\2\u018e"+
		"\u0193\5\u0093J\2\u018f\u0192\5\u0097L\2\u0190\u0192\13\2\2\2\u0191\u018f"+
		"\3\2\2\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0194\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197\5\u0095"+
		"K\2\u0197\u0198\3\2\2\2\u0198\u0199\bL\2\2\u0199\u0098\3\2\2\2\u019a\u019b"+
		"\7/\2\2\u019b\u019c\7/\2\2\u019c\u01a0\3\2\2\2\u019d\u019f\n\32\2\2\u019e"+
		"\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\7\f\2\2\u01a4"+
		"\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\bM"+
		"\2\2\u01a7\u009a\3\2\2\2\u01a8\u01aa\t\33\2\2\u01a9\u01a8\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01ae\bN\2\2\u01ae\u009c\3\2\2\2\u01af\u01b0\13\2\2\2\u01b0"+
		"\u009e\3\2\2\2\16\2\u0128\u012a\u0132\u0138\u013f\u017e\u0191\u0193\u01a0"+
		"\u01a4\u01ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}