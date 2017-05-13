package ca.wolfram.beta.symath.parser;

import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
    static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
    LETTER=1, DIGIT=2, GT=3, LT=4, EQ=5, LPAREN=6, RPAREN=7, PLUS=8, MINUS=9,
    TIMES=10, DIV=11, POINT=12, E=13, POW=14, NEWLINE=15, WS=16;
    public static final int
    RULE_prog = 0, RULE_equation = 1, RULE_expression = 2, RULE_term = 3,
    RULE_factor = 4, RULE_atom = 5, RULE_scientific = 6, RULE_decimal = 7,
    RULE_wholenumber = 8, RULE_digits = 9, RULE_variable = 10, RULE_relop = 11;
    public static final String[] ruleNames = {
            "prog", "equation", "expression", "term", "factor", "atom", "scientific",
            "decimal", "wholenumber", "digits", "variable", "relop"
    };

    private static final String[] _LITERAL_NAMES = {
            null, null, null, "'>'", "'<'", "'='", "'('", "')'", "'+'", "'-'", "'*'",
            "'/'", "'.'", "'E'", "'^'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "LETTER", "DIGIT", "GT", "LT", "EQ", "LPAREN", "RPAREN", "PLUS",
            "MINUS", "TIMES", "DIV", "POINT", "E", "POW", "NEWLINE", "WS"
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

    @Override
    public String getGrammarFileName() { return "Expression.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String getSerializedATN() { return _serializedATN; }

    @Override
    public ATN getATN() { return _ATN; }

    public ExpressionParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }
    public static class ProgContext extends ParserRuleContext {
        public List<EquationContext> equation() {
            return getRuleContexts(EquationContext.class);
        }
        public EquationContext equation(int i) {
            return getRuleContext(EquationContext.class,i);
        }
        public List<TerminalNode> NEWLINE() { return getTokens(ExpressionParser.NEWLINE); }
        public TerminalNode NEWLINE(int i) {
            return getToken(ExpressionParser.NEWLINE, i);
        }
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_prog; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProg(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProg(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(24);
                equation();
                setState(29);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==NEWLINE) {
                    {
                        {
                            setState(25);
                            match(NEWLINE);
                            setState(26);
                            equation();
                        }
                    }
                    setState(31);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EquationContext extends ParserRuleContext {
        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }
        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class,i);
        }
        public List<RelopContext> relop() {
            return getRuleContexts(RelopContext.class);
        }
        public RelopContext relop(int i) {
            return getRuleContext(RelopContext.class,i);
        }
        public EquationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_equation; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEquation(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEquation(this);
        }
    }

    public final EquationContext equation() throws RecognitionException {
        EquationContext _localctx = new EquationContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_equation);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(32);
                expression();
                setState(38);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
                while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
                    if ( _alt==1 ) {
                        {
                            {
                                setState(33);
                                relop();
                                setState(34);
                                expression();
                            }
                        }
                    }
                    setState(40);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }
        public TermContext term(int i) {
            return getRuleContext(TermContext.class,i);
        }
        public List<TerminalNode> PLUS() { return getTokens(ExpressionParser.PLUS); }
        public TerminalNode PLUS(int i) {
            return getToken(ExpressionParser.PLUS, i);
        }
        public List<TerminalNode> MINUS() { return getTokens(ExpressionParser.MINUS); }
        public TerminalNode MINUS(int i) {
            return getToken(ExpressionParser.MINUS, i);
        }
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_expression; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_expression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(41);
                term();
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==PLUS || _la==MINUS) {
                    {
                        {
                            setState(42);
                            _la = _input.LA(1);
                            if ( !(_la==PLUS || _la==MINUS) ) {
                                _errHandler.recoverInline(this);
                            } else {
                                consume();
                            }
                            setState(43);
                            term();
                        }
                    }
                    setState(48);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermContext extends ParserRuleContext {
        public List<FactorContext> factor() {
            return getRuleContexts(FactorContext.class);
        }
        public FactorContext factor(int i) {
            return getRuleContext(FactorContext.class,i);
        }
        public List<TerminalNode> TIMES() { return getTokens(ExpressionParser.TIMES); }
        public TerminalNode TIMES(int i) {
            return getToken(ExpressionParser.TIMES, i);
        }
        public List<TerminalNode> DIV() { return getTokens(ExpressionParser.DIV); }
        public TerminalNode DIV(int i) {
            return getToken(ExpressionParser.DIV, i);
        }
        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_term; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTerm(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTerm(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_term);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                factor();
                setState(54);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==TIMES || _la==DIV) {
                    {
                        {
                            setState(50);
                            _la = _input.LA(1);
                            if ( !(_la==TIMES || _la==DIV) ) {
                                _errHandler.recoverInline(this);
                            } else {
                                consume();
                            }
                            setState(51);
                            factor();
                        }
                    }
                    setState(56);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FactorContext extends ParserRuleContext {
        public List<AtomContext> atom() {
            return getRuleContexts(AtomContext.class);
        }
        public AtomContext atom(int i) {
            return getRuleContext(AtomContext.class,i);
        }
        public TerminalNode POW() { return getToken(ExpressionParser.POW, 0); }
        public FactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_factor; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFactor(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFactor(this);
        }
    }

    public final FactorContext factor() throws RecognitionException {
        FactorContext _localctx = new FactorContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_factor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(57);
                atom();
                setState(60);
                _la = _input.LA(1);
                if (_la==POW) {
                    {
                        setState(58);
                        match(POW);
                        setState(59);
                        atom();
                    }
                }

            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AtomContext extends ParserRuleContext {
        public ScientificContext scientific() {
            return getRuleContext(ScientificContext.class,0);
        }
        public VariableContext variable() {
            return getRuleContext(VariableContext.class,0);
        }
        public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class,0);
        }
        public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
        public AtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_atom; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAtom(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAtom(this);
        }
    }

    public final AtomContext atom() throws RecognitionException {
        AtomContext _localctx = new AtomContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_atom);
        try {
            setState(68);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
            case 1:
                enterOuterAlt(_localctx, 1);
                {
                    setState(62);
                    scientific();
                }
                break;
            case 2:
                enterOuterAlt(_localctx, 2);
                {
                    setState(63);
                    variable();
                }
                break;
            case 3:
                enterOuterAlt(_localctx, 3);
                {
                    setState(64);
                    match(LPAREN);
                    setState(65);
                    expression();
                    setState(66);
                    match(RPAREN);
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ScientificContext extends ParserRuleContext {
        public DecimalContext decimal() {
            return getRuleContext(DecimalContext.class,0);
        }
        public TerminalNode E() { return getToken(ExpressionParser.E, 0); }
        public WholenumberContext wholenumber() {
            return getRuleContext(WholenumberContext.class,0);
        }
        public ScientificContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_scientific; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterScientific(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitScientific(this);
        }
    }

    public final ScientificContext scientific() throws RecognitionException {
        ScientificContext _localctx = new ScientificContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_scientific);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
                decimal();
                setState(73);
                _la = _input.LA(1);
                if (_la==E) {
                    {
                        setState(71);
                        match(E);
                        setState(72);
                        wholenumber();
                    }
                }

            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DecimalContext extends ParserRuleContext {
        public WholenumberContext wholenumber() {
            return getRuleContext(WholenumberContext.class,0);
        }
        public TerminalNode POINT() { return getToken(ExpressionParser.POINT, 0); }
        public List<DigitsContext> digits() {
            return getRuleContexts(DigitsContext.class);
        }
        public DigitsContext digits(int i) {
            return getRuleContext(DigitsContext.class,i);
        }
        public DecimalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_decimal; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterDecimal(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitDecimal(this);
        }
    }

    public final DecimalContext decimal() throws RecognitionException {
        DecimalContext _localctx = new DecimalContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_decimal);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(75);
                wholenumber();
                setState(77);
                _la = _input.LA(1);
                if (_la==POINT) {
                    {
                        setState(76);
                        match(POINT);
                    }
                }

                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==DIGIT) {
                    {
                        {
                            setState(79);
                            digits();
                        }
                    }
                    setState(84);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WholenumberContext extends ParserRuleContext {
        public DigitsContext digits() {
            return getRuleContext(DigitsContext.class,0);
        }
        public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
        public WholenumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_wholenumber; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterWholenumber(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitWholenumber(this);
        }
    }

    public final WholenumberContext wholenumber() throws RecognitionException {
        WholenumberContext _localctx = new WholenumberContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_wholenumber);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                _la = _input.LA(1);
                if (_la==MINUS) {
                    {
                        setState(85);
                        match(MINUS);
                    }
                }

                setState(88);
                digits();
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DigitsContext extends ParserRuleContext {
        public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
        public TerminalNode DIGIT(int i) {
            return getToken(ExpressionParser.DIGIT, i);
        }
        public DigitsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_digits; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterDigits(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitDigits(this);
        }
    }

    public final DigitsContext digits() throws RecognitionException {
        DigitsContext _localctx = new DigitsContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_digits);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(91);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                    case 1:
                    {
                        {
                            setState(90);
                            match(DIGIT);
                        }
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                    }
                    setState(93);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input,10,_ctx);
                } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableContext extends ParserRuleContext {
        public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
        public List<TerminalNode> LETTER() { return getTokens(ExpressionParser.LETTER); }
        public TerminalNode LETTER(int i) {
            return getToken(ExpressionParser.LETTER, i);
        }
        public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
        public TerminalNode DIGIT(int i) {
            return getToken(ExpressionParser.DIGIT, i);
        }
        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_variable; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterVariable(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitVariable(this);
        }
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_variable);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(96);
                _la = _input.LA(1);
                if (_la==MINUS) {
                    {
                        setState(95);
                        match(MINUS);
                    }
                }

                setState(99);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                    case 1:
                    {
                        {
                            setState(98);
                            match(LETTER);
                        }
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                    }
                    setState(101);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input,12,_ctx);
                } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
                setState(106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==LETTER || _la==DIGIT) {
                    {
                        {
                            setState(103);
                            _la = _input.LA(1);
                            if ( !(_la==LETTER || _la==DIGIT) ) {
                                _errHandler.recoverInline(this);
                            } else {
                                consume();
                            }
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RelopContext extends ParserRuleContext {
        public TerminalNode EQ() { return getToken(ExpressionParser.EQ, 0); }
        public TerminalNode GT() { return getToken(ExpressionParser.GT, 0); }
        public TerminalNode LT() { return getToken(ExpressionParser.LT, 0); }
        public TerminalNode NEWLINE() { return getToken(ExpressionParser.NEWLINE, 0); }
        public RelopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_relop; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRelop(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRelop(this);
        }
    }

    public final RelopContext relop() throws RecognitionException {
        RelopContext _localctx = new RelopContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_relop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(109);
                _la = _input.LA(1);
                if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQ) | (1L << NEWLINE))) != 0)) ) {
                    _errHandler.recoverInline(this);
                } else {
                    consume();
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22r\4\2\t\2\4\3\t"+
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
                    "\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3\3\3\7"+
                    "\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\5\3\5"+
                    "\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\3"+
                    "\7\3\7\5\7G\n\7\3\b\3\b\3\b\5\bL\n\b\3\t\3\t\5\tP\n\t\3\t\7\tS\n\t\f\t"+
                    "\16\tV\13\t\3\n\5\nY\n\n\3\n\3\n\3\13\6\13^\n\13\r\13\16\13_\3\f\5\fc"+
                    "\n\f\3\f\6\ff\n\f\r\f\16\fg\3\f\7\fk\n\f\f\f\16\fn\13\f\3\r\3\r\3\r\2"+
                    "\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6\3\2\n\13\3\2\f\r\3\2\3\4\4\2\5"+
                    "\7\21\21t\2\32\3\2\2\2\4\"\3\2\2\2\6+\3\2\2\2\b\63\3\2\2\2\n;\3\2\2\2"+
                    "\fF\3\2\2\2\16H\3\2\2\2\20M\3\2\2\2\22X\3\2\2\2\24]\3\2\2\2\26b\3\2\2"+
                    "\2\30o\3\2\2\2\32\37\5\4\3\2\33\34\7\21\2\2\34\36\5\4\3\2\35\33\3\2\2"+
                    "\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"(\5\6"+
                    "\4\2#$\5\30\r\2$%\5\6\4\2%\'\3\2\2\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()"+
                    "\3\2\2\2)\5\3\2\2\2*(\3\2\2\2+\60\5\b\5\2,-\t\2\2\2-/\5\b\5\2.,\3\2\2"+
                    "\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\7\3\2\2\2\62\60\3\2\2\2\63"+
                    "8\5\n\6\2\64\65\t\3\2\2\65\67\5\n\6\2\66\64\3\2\2\2\67:\3\2\2\28\66\3"+
                    "\2\2\289\3\2\2\29\t\3\2\2\2:8\3\2\2\2;>\5\f\7\2<=\7\20\2\2=?\5\f\7\2>"+
                    "<\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@G\5\16\b\2AG\5\26\f\2BC\7\b\2\2CD\5\6"+
                    "\4\2DE\7\t\2\2EG\3\2\2\2F@\3\2\2\2FA\3\2\2\2FB\3\2\2\2G\r\3\2\2\2HK\5"+
                    "\20\t\2IJ\7\17\2\2JL\5\22\n\2KI\3\2\2\2KL\3\2\2\2L\17\3\2\2\2MO\5\22\n"+
                    "\2NP\7\16\2\2ON\3\2\2\2OP\3\2\2\2PT\3\2\2\2QS\5\24\13\2RQ\3\2\2\2SV\3"+
                    "\2\2\2TR\3\2\2\2TU\3\2\2\2U\21\3\2\2\2VT\3\2\2\2WY\7\13\2\2XW\3\2\2\2"+
                    "XY\3\2\2\2YZ\3\2\2\2Z[\5\24\13\2[\23\3\2\2\2\\^\7\4\2\2]\\\3\2\2\2^_\3"+
                    "\2\2\2_]\3\2\2\2_`\3\2\2\2`\25\3\2\2\2ac\7\13\2\2ba\3\2\2\2bc\3\2\2\2"+
                    "ce\3\2\2\2df\7\3\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hl\3\2\2\2"+
                    "ik\t\4\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\27\3\2\2\2nl\3\2\2"+
                    "\2op\t\5\2\2p\31\3\2\2\2\20\37(\608>FKOTX_bgl";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}