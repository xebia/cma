// $ANTLR 3.4 /Users/wilco/Documents/workspace/dependencies/parser/cma.g 2012-02-27 11:00:32

package com.xebia.cma.parser;
//Target language syntax highlighter
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class cmaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "'('", "')'", "'*'", "'+'", "'-'", "'='"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class StackScope_scope {
        int operation;
    }
    protected Stack StackScope_stack = new Stack();



    public cmaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public cmaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return cmaParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/wilco/Documents/workspace/dependencies/parser/cma.g"; }


    //Target language syntax highlighter
    /** Map variable name to Integer object holding value */
      HashMap memory = new HashMap();
      
      public void someTargetMethod() {
      }


    public static class prog_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:32:1: prog : ( stat )+ ;
    public final cmaParser.prog_return prog() throws RecognitionException {
        cmaParser.prog_return retval = new cmaParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        cmaParser.stat_return stat1 =null;



        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:32:5: ( ( stat )+ )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:32:9: ( stat )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:32:9: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= 7)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:32:9: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog66);
            	    stat1=stat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stat1.getTree());

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

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class stat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stat"
    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:34:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
    public final cmaParser.stat_return stat() throws RecognitionException {
        cmaParser.stat_return retval = new cmaParser.stat_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NEWLINE3=null;
        Token ID4=null;
        Token char_literal5=null;
        Token NEWLINE7=null;
        Token NEWLINE8=null;
        cmaParser.expr_return expr2 =null;

        cmaParser.expr_return expr6 =null;


        Object NEWLINE3_tree=null;
        Object ID4_tree=null;
        Object char_literal5_tree=null;
        Object NEWLINE7_tree=null;
        Object NEWLINE8_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:34:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
            int alt2=3;
            switch ( input.LA(1) ) {
            case INT:
            case 7:
                {
                alt2=1;
                }
                break;
            case ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==12) ) {
                    alt2=2;
                }
                else if ( (LA2_2==NEWLINE||(LA2_2 >= 9 && LA2_2 <= 11)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
                }
                break;
            case NEWLINE:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:34:9: expr NEWLINE
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expr_in_stat77);
                    expr2=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr2.getTree());

                    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat79); 
                    NEWLINE3_tree = 
                    (Object)adaptor.create(NEWLINE3)
                    ;
                    adaptor.addChild(root_0, NEWLINE3_tree);


                    System.out.println((expr2!=null?expr2.value:0));

                    }
                    break;
                case 2 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:35:9: ID '=' expr NEWLINE
                    {
                    root_0 = (Object)adaptor.nil();


                    ID4=(Token)match(input,ID,FOLLOW_ID_in_stat91); 
                    ID4_tree = 
                    (Object)adaptor.create(ID4)
                    ;
                    adaptor.addChild(root_0, ID4_tree);


                    char_literal5=(Token)match(input,12,FOLLOW_12_in_stat93); 
                    char_literal5_tree = 
                    (Object)adaptor.create(char_literal5)
                    ;
                    adaptor.addChild(root_0, char_literal5_tree);


                    pushFollow(FOLLOW_expr_in_stat95);
                    expr6=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr6.getTree());

                    NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat97); 
                    NEWLINE7_tree = 
                    (Object)adaptor.create(NEWLINE7)
                    ;
                    adaptor.addChild(root_0, NEWLINE7_tree);


                    memory.put((ID4!=null?ID4.getText():null), new Integer((expr6!=null?expr6.value:0)));

                    }
                    break;
                case 3 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:37:9: NEWLINE
                    {
                    root_0 = (Object)adaptor.nil();


                    NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat117); 
                    NEWLINE8_tree = 
                    (Object)adaptor.create(NEWLINE8)
                    ;
                    adaptor.addChild(root_0, NEWLINE8_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stat"


    public static class expr_return extends ParserRuleReturnScope {
        public int value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:40:1: expr returns [int value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
    public final cmaParser.expr_return expr() throws RecognitionException {
        cmaParser.expr_return retval = new cmaParser.expr_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal10=null;
        cmaParser.multExpr_return e =null;


        Object char_literal9_tree=null;
        Object char_literal10_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:41:5: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:41:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_multExpr_in_expr142);
            e=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());

            retval.value = (e!=null?e.value:0);

            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:42:9: ( '+' e= multExpr | '-' e= multExpr )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }
                else if ( (LA3_0==11) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:42:13: '+' e= multExpr
            	    {
            	    char_literal9=(Token)match(input,10,FOLLOW_10_in_expr158); 
            	    char_literal9_tree = 
            	    (Object)adaptor.create(char_literal9)
            	    ;
            	    adaptor.addChild(root_0, char_literal9_tree);


            	    pushFollow(FOLLOW_multExpr_in_expr162);
            	    e=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    retval.value += (e!=null?e.value:0);

            	    }
            	    break;
            	case 2 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:43:13: '-' e= multExpr
            	    {
            	    char_literal10=(Token)match(input,11,FOLLOW_11_in_expr178); 
            	    char_literal10_tree = 
            	    (Object)adaptor.create(char_literal10)
            	    ;
            	    adaptor.addChild(root_0, char_literal10_tree);


            	    pushFollow(FOLLOW_multExpr_in_expr182);
            	    e=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    retval.value -= (e!=null?e.value:0);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class multExpr_return extends ParserRuleReturnScope {
        public int value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multExpr"
    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:47:1: multExpr returns [int value] : e= atom ( '*' e= atom )* ;
    public final cmaParser.multExpr_return multExpr() throws RecognitionException {
        cmaParser.multExpr_return retval = new cmaParser.multExpr_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal11=null;
        cmaParser.atom_return e =null;


        Object char_literal11_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:48:5: (e= atom ( '*' e= atom )* )
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:48:9: e= atom ( '*' e= atom )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_atom_in_multExpr224);
            e=atom();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());

            retval.value = (e!=null?e.value:0);

            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:48:37: ( '*' e= atom )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==9) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:48:38: '*' e= atom
            	    {
            	    char_literal11=(Token)match(input,9,FOLLOW_9_in_multExpr229); 
            	    char_literal11_tree = 
            	    (Object)adaptor.create(char_literal11)
            	    ;
            	    adaptor.addChild(root_0, char_literal11_tree);


            	    pushFollow(FOLLOW_atom_in_multExpr233);
            	    e=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    retval.value *= (e!=null?e.value:0);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multExpr"


    public static class atom_return extends ParserRuleReturnScope {
        public int value;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:51:1: atom returns [int value] : ( INT | ID | '(' expr ')' );
    public final cmaParser.atom_return atom() throws RecognitionException {
        cmaParser.atom_return retval = new cmaParser.atom_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INT12=null;
        Token ID13=null;
        Token char_literal14=null;
        Token char_literal16=null;
        cmaParser.expr_return expr15 =null;


        Object INT12_tree=null;
        Object ID13_tree=null;
        Object char_literal14_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:52:5: ( INT | ID | '(' expr ')' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case 7:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:52:9: INT
                    {
                    root_0 = (Object)adaptor.nil();


                    INT12=(Token)match(input,INT,FOLLOW_INT_in_atom265); 
                    INT12_tree = 
                    (Object)adaptor.create(INT12)
                    ;
                    adaptor.addChild(root_0, INT12_tree);


                    retval.value = Integer.parseInt((INT12!=null?INT12.getText():null));

                    }
                    break;
                case 2 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:53:9: ID
                    {
                    root_0 = (Object)adaptor.nil();


                    ID13=(Token)match(input,ID,FOLLOW_ID_in_atom277); 
                    ID13_tree = 
                    (Object)adaptor.create(ID13)
                    ;
                    adaptor.addChild(root_0, ID13_tree);



                            Integer v = (Integer)memory.get((ID13!=null?ID13.getText():null));
                            if ( v!=null ) retval.value = v.intValue();
                            else System.err.println("undefined variable "+(ID13!=null?ID13.getText():null));
                            

                    }
                    break;
                case 3 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/cma.g:59:9: '(' expr ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal14=(Token)match(input,7,FOLLOW_7_in_atom297); 
                    char_literal14_tree = 
                    (Object)adaptor.create(char_literal14)
                    ;
                    adaptor.addChild(root_0, char_literal14_tree);


                    pushFollow(FOLLOW_expr_in_atom299);
                    expr15=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr15.getTree());

                    char_literal16=(Token)match(input,8,FOLLOW_8_in_atom301); 
                    char_literal16_tree = 
                    (Object)adaptor.create(char_literal16)
                    ;
                    adaptor.addChild(root_0, char_literal16_tree);


                    retval.value = (expr15!=null?expr15.value:0);

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog66 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_expr_in_stat77 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat91 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_stat93 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_stat95 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr142 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_10_in_expr158 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_multExpr_in_expr162 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_11_in_expr178 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_multExpr_in_expr182 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_atom_in_multExpr224 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_multExpr229 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_atom_in_multExpr233 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_INT_in_atom265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_atom297 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_atom299 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_atom301 = new BitSet(new long[]{0x0000000000000002L});

}