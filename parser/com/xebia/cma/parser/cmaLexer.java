// $ANTLR 3.4 /Users/wilco/Documents/workspace/dependencies/parser/cma.g 2012-02-27 11:00:33
package com.xebia.cma.parser;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class cmaLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int ID=4;
    public static final int INT=5;
    public static final int NEWLINE=6;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public cmaLexer() {} 
    public cmaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public cmaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/wilco/Documents/workspace/dependencies/parser/cma.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:7:6: ( '(' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:7:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:8:6: ( ')' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:8:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:9:6: ( '*' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:9:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:10:7: ( '+' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:10:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:11:7: ( '-' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:11:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:12:7: ( '=' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:12:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:62:5: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:62:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:62:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:63:5: ( ( '0' .. '9' )+ )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:63:9: ( '0' .. '9' )+
            {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:63:9: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
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
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:64:8: ( ( '\\r' )? '\\n' )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:64:9: ( '\\r' )? '\\n'
            {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:64:9: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:64:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    public void mTokens() throws RecognitionException {
        // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | ID | INT | NEWLINE )
        int alt4=9;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt4=1;
            }
            break;
        case ')':
            {
            alt4=2;
            }
            break;
        case '*':
            {
            alt4=3;
            }
            break;
        case '+':
            {
            alt4=4;
            }
            break;
        case '-':
            {
            alt4=5;
            }
            break;
        case '=':
            {
            alt4=6;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=7;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt4=8;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=9;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:37: T__12
                {
                mT__12(); 


                }
                break;
            case 7 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:43: ID
                {
                mID(); 


                }
                break;
            case 8 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:46: INT
                {
                mINT(); 


                }
                break;
            case 9 :
                // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:1:50: NEWLINE
                {
                mNEWLINE(); 


                }
                break;

        }

    }


 

}