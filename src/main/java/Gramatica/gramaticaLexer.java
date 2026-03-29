// $ANTLR 3.5.2 gramatica.g 2026-03-28 17:21:14
package Gramatica;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class gramaticaLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int ALFABETICO=4;
    public static final int CERRARTABLA=5;
    public static final int CREAR=6;
    public static final int FECHA=7;
    public static final int FIN=8;
    public static final int ID=9;
    public static final int INICIOATRIBUTOS=10;
    public static final int NUMERICO=11;
    public static final int RELACION=12;
    public static final int TABLA=13;
    public static final int TERMINAR=14;
    public static final int USAR=15;
    public static final int WS=16;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public gramaticaLexer() {}
    public gramaticaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public gramaticaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    @Override public String getGrammarFileName() { return "gramatica.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:2:7: ( 'que es' )
            // gramatica.g:2:9: 'que es'
            {
                match("que es");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "CERRARTABLA"
    public final void mCERRARTABLA() throws RecognitionException {
        try {
            int _type = CERRARTABLA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:88:12: ( 'terminamos esta tabla' )
            // gramatica.g:88:14: 'terminamos esta tabla'
            {
                match("terminamos esta tabla");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CERRARTABLA"

    // $ANTLR start "TERMINAR"
    public final void mTERMINAR() throws RecognitionException {
        try {
            int _type = TERMINAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:89:9: ( 'mostrar lo aprendido' )
            // gramatica.g:89:11: 'mostrar lo aprendido'
            {
                match("mostrar lo aprendido");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TERMINAR"

    // $ANTLR start "NUMERICO"
    public final void mNUMERICO() throws RecognitionException {
        try {
            int _type = NUMERICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:90:9: ( 'número' )
            // gramatica.g:90:11: 'número'
            {
                match("número");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "NUMERICO"

    // $ANTLR start "ALFABETICO"
    public final void mALFABETICO() throws RecognitionException {
        try {
            int _type = ALFABETICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:91:11: ( 'texto' )
            // gramatica.g:91:13: 'texto'
            {
                match("texto");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ALFABETICO"

    // $ANTLR start "FECHA"
    public final void mFECHA() throws RecognitionException {
        try {
            int _type = FECHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:92:6: ( 'fecha' )
            // gramatica.g:92:8: 'fecha'
            {
                match("fecha");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FECHA"

    // $ANTLR start "TABLA"
    public final void mTABLA() throws RecognitionException {
        try {
            int _type = TABLA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:93:6: ( 'vamos a guardar información sobre' )
            // gramatica.g:93:8: 'vamos a guardar información sobre'
            {
                match("vamos a guardar información sobre");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "TABLA"

    // $ANTLR start "FIN"
    public final void mFIN() throws RecognitionException {
        try {
            int _type = FIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:94:4: ( 'fin' )
            // gramatica.g:94:6: 'fin'
            {
                match("fin");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "FIN"

    // $ANTLR start "USAR"
    public final void mUSAR() throws RecognitionException {
        try {
            int _type = USAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:95:5: ( 'comenzar a usar' )
            // gramatica.g:95:7: 'comenzar a usar'
            {
                match("comenzar a usar");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "USAR"

    // $ANTLR start "CREAR"
    public final void mCREAR() throws RecognitionException {
        try {
            int _type = CREAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:96:6: ( 'vamos a crear' )
            // gramatica.g:96:8: 'vamos a crear'
            {
                match("vamos a crear");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CREAR"

    // $ANTLR start "RELACION"
    public final void mRELACION() throws RecognitionException {
        try {
            int _type = RELACION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:97:9: ( 'es amiga de' )
            // gramatica.g:97:11: 'es amiga de'
            {
                match("es amiga de");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "RELACION"

    // $ANTLR start "INICIOATRIBUTOS"
    public final void mINICIOATRIBUTOS() throws RecognitionException {
        try {
            int _type = INICIOATRIBUTOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:98:16: ( 'vamos a recordar' )
            // gramatica.g:98:18: 'vamos a recordar'
            {
                match("vamos a recordar");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INICIOATRIBUTOS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:99:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // gramatica.g:99:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
                if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    input.consume();
                }
                else {
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    recover(mse);
                    throw mse;
                }
                // gramatica.g:99:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                loop1:
                while (true) {
                    int alt1=2;
                    int LA1_0 = input.LA(1);
                    if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                        alt1=1;
                    }

                    switch (alt1) {
                        case 1 :
                            // gramatica.g:
                        {
                            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default :
                            break loop1;
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gramatica.g:105:3: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // gramatica.g:105:5: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
                // gramatica.g:105:5: ( ' ' | '\\n' | '\\t' | '\\r' )+
                int cnt2=0;
                loop2:
                while (true) {
                    int alt2=2;
                    int LA2_0 = input.LA(1);
                    if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
                        alt2=1;
                    }

                    switch (alt2) {
                        case 1 :
                            // gramatica.g:
                        {
                            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default :
                            if ( cnt2 >= 1 ) break loop2;
                            EarlyExitException eee = new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                }

                _channel=HIDDEN;
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    @Override
    public void mTokens() throws RecognitionException {
        // gramatica.g:1:8: ( T__17 | CERRARTABLA | TERMINAR | NUMERICO | ALFABETICO | FECHA | TABLA | FIN | USAR | CREAR | RELACION | INICIOATRIBUTOS | ID | WS )
        int alt3=14;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // gramatica.g:1:10: T__17
            {
                mT__17();

            }
            break;
            case 2 :
                // gramatica.g:1:16: CERRARTABLA
            {
                mCERRARTABLA();

            }
            break;
            case 3 :
                // gramatica.g:1:28: TERMINAR
            {
                mTERMINAR();

            }
            break;
            case 4 :
                // gramatica.g:1:37: NUMERICO
            {
                mNUMERICO();

            }
            break;
            case 5 :
                // gramatica.g:1:46: ALFABETICO
            {
                mALFABETICO();

            }
            break;
            case 6 :
                // gramatica.g:1:57: FECHA
            {
                mFECHA();

            }
            break;
            case 7 :
                // gramatica.g:1:63: TABLA
            {
                mTABLA();

            }
            break;
            case 8 :
                // gramatica.g:1:69: FIN
            {
                mFIN();

            }
            break;
            case 9 :
                // gramatica.g:1:73: USAR
            {
                mUSAR();

            }
            break;
            case 10 :
                // gramatica.g:1:78: CREAR
            {
                mCREAR();

            }
            break;
            case 11 :
                // gramatica.g:1:84: RELACION
            {
                mRELACION();

            }
            break;
            case 12 :
                // gramatica.g:1:93: INICIOATRIBUTOS
            {
                mINICIOATRIBUTOS();

            }
            break;
            case 13 :
                // gramatica.g:1:109: ID
            {
                mID();

            }
            break;
            case 14 :
                // gramatica.g:1:112: WS
            {
                mWS();

            }
            break;

        }
    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
            "\1\uffff\10\11\2\uffff\3\11\1\uffff\12\11\1\42\2\11\2\uffff\4\11\1\uffff"+
                    "\3\11\1\54\1\11\1\56\3\11\1\uffff\1\11\2\uffff\3\11\1\uffff\2\11\2\uffff"+
                    "\2\11\4\uffff\1\11\1\uffff";
    static final String DFA3_eofS =
            "\100\uffff";
    static final String DFA3_minS =
            "\1\11\1\165\1\145\1\157\1\u00fa\1\145\1\141\1\157\1\163\2\uffff\1\145"+
                    "\1\162\1\163\1\uffff\1\143\1\156\2\155\2\40\1\155\2\164\1\150\1\60\1\157"+
                    "\1\145\2\uffff\1\151\1\157\1\162\1\141\1\uffff\1\163\2\156\1\60\1\141"+
                    "\1\60\1\40\1\172\1\141\1\uffff\1\162\1\uffff\2\141\1\155\2\40\1\162\1"+
                    "\157\1\uffff\1\143\1\40\1\163\4\uffff\1\40\1\uffff";
    static final String DFA3_maxS =
            "\1\172\1\165\1\145\1\157\1\u00fa\1\151\1\141\1\157\1\163\2\uffff\1\145"+
                    "\1\170\1\163\1\uffff\1\143\1\156\2\155\2\40\1\155\2\164\1\150\1\172\1"+
                    "\157\1\145\2\uffff\1\151\1\157\1\162\1\141\1\uffff\1\163\2\156\1\172\1"+
                    "\141\1\172\1\40\1\172\1\141\1\uffff\1\162\1\uffff\2\141\1\155\2\40\1\162"+
                    "\1\157\1\uffff\1\162\1\40\1\163\4\uffff\1\40\1\uffff";
    static final String DFA3_acceptS =
            "\11\uffff\1\15\1\16\3\uffff\1\4\15\uffff\1\13\1\1\4\uffff\1\10\11\uffff"+
                    "\1\5\1\uffff\1\6\7\uffff\1\3\3\uffff\1\7\1\12\1\14\1\11\1\uffff\1\2";
    static final String DFA3_specialS =
            "\100\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\12\2\uffff\1\12\22\uffff\1\12\40\uffff\32\11\4\uffff\1\11\1\uffff"+
                    "\2\11\1\7\1\11\1\10\1\5\6\11\1\3\1\4\2\11\1\1\2\11\1\2\1\11\1\6\4\11",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17\3\uffff\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "",
            "",
            "\1\24",
            "\1\25\5\uffff\1\26",
            "\1\27",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\43",
            "\1\44",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "",
            "\1\51",
            "\1\52",
            "\1\53",
            "\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\55",
            "\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "\1\62",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\1\73\3\uffff\1\72\12\uffff\1\74",
            "\1\75",
            "\1\76",
            "",
            "",
            "",
            "",
            "\1\77",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    protected class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        @Override
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | CERRARTABLA | TERMINAR | NUMERICO | ALFABETICO | FECHA | TABLA | FIN | USAR | CREAR | RELACION | INICIOATRIBUTOS | ID | WS );";
        }
    }

}
