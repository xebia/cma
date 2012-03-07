// $ANTLR 3.4 /Users/wilco/Documents/workspace/dependencies/parser/xal.g 2012-03-06 10:55:56
package com.xebia.xal.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class xalLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int COMMENT=4;
    public static final int ID=5;
    public static final int STRING=6;
    public static final int WHITESPACE=7;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public xalLexer() {} 
    public xalLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public xalLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/wilco/Documents/workspace/dependencies/parser/xal.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:9:6: ( ':' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:9:8: ':'
            {
            match(':'); 

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
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:10:6: ( 'depends on' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:10:8: 'depends on'
            {
            match("depends on"); 



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
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:11:7: ( 'is a' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:11:9: 'is a'
            {
            match("is a"); 



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
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:12:7: ( 'is an' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:12:9: 'is an'
            {
            match("is an"); 



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
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:13:7: ( 'is deployed on' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:13:9: 'is deployed on'
            {
            match("is deployed on"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:14:7: ( 'is implemented by' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:14:9: 'is implemented by'
            {
            match("is implemented by"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:15:7: ( 'is' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:15:9: 'is'
            {
            match("is"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:55:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )* )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:55:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:55:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='.'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:56:8: ( '\"' (~ '\"' )* '\"' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:56:10: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 

            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:56:14: (~ '\"' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop2;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:58:8: ( '#' (~ '\\n' )* '\\n' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:58:10: '#' (~ '\\n' )* '\\n'
            {
            match('#'); 

            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:58:14: (~ '\\n' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop3;
                }
            } while (true);


            match('\n'); 

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:59:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:59:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:59:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||(LA4_0 >= '\f' && LA4_0 <= '\r')||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | ID | STRING | COMMENT | WHITESPACE )
        int alt5=11;
        switch ( input.LA(1) ) {
        case ':':
            {
            alt5=1;
            }
            break;
        case 'd':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='e') ) {
                int LA5_8 = input.LA(3);

                if ( (LA5_8=='p') ) {
                    int LA5_10 = input.LA(4);

                    if ( (LA5_10=='e') ) {
                        int LA5_13 = input.LA(5);

                        if ( (LA5_13=='n') ) {
                            int LA5_17 = input.LA(6);

                            if ( (LA5_17=='d') ) {
                                int LA5_20 = input.LA(7);

                                if ( (LA5_20=='s') ) {
                                    int LA5_21 = input.LA(8);

                                    if ( (LA5_21==' ') ) {
                                        alt5=2;
                                    }
                                    else {
                                        alt5=8;
                                    }
                                }
                                else {
                                    alt5=8;
                                }
                            }
                            else {
                                alt5=8;
                            }
                        }
                        else {
                            alt5=8;
                        }
                    }
                    else {
                        alt5=8;
                    }
                }
                else {
                    alt5=8;
                }
            }
            else {
                alt5=8;
            }
            }
            break;
        case 'i':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='s') ) {
                switch ( input.LA(3) ) {
                case ' ':
                    {
                    switch ( input.LA(4) ) {
                    case 'a':
                        {
                        int LA5_14 = input.LA(5);

                        if ( (LA5_14=='n') ) {
                            alt5=4;
                        }
                        else {
                            alt5=3;
                        }
                        }
                        break;
                    case 'd':
                        {
                        alt5=5;
                        }
                        break;
                    case 'i':
                        {
                        alt5=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 11, input);

                        throw nvae;

                    }

                    }
                    break;
                case '.':
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
                    alt5=8;
                    }
                    break;
                default:
                    alt5=7;
                }

            }
            else {
                alt5=8;
            }
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
        case 'e':
        case 'f':
        case 'g':
        case 'h':
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
            alt5=8;
            }
            break;
        case '\"':
            {
            alt5=9;
            }
            break;
        case '#':
            {
            alt5=10;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt5=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:38: T__13
                {
                mT__13(); 


                }
                break;
            case 7 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:44: T__14
                {
                mT__14(); 


                }
                break;
            case 8 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:50: ID
                {
                mID(); 


                }
                break;
            case 9 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:53: STRING
                {
                mSTRING(); 


                }
                break;
            case 10 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:60: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 11 :
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:1:68: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


 

}