// $ANTLR 3.4 /Users/wilco/Documents/workspace/dependencies/parser/xal.g 2012-03-06 10:55:57

package com.xebia.xal.parser;
//Target language syntax highlighter
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class xalParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "STRING", "WHITESPACE", "':'", "'depends on'", "'is a'", "'is an'", "'is deployed on'", "'is implemented by'", "'is'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class StackScope_scope {
        int operation;
    }
    protected Stack StackScope_stack = new Stack();



    public xalParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public xalParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return xalParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/wilco/Documents/workspace/dependencies/parser/xal.g"; }


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
    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:34:1: prog : ( decl )+ -> ( decl )+ ;
    public final xalParser.prog_return prog() throws RecognitionException {
        xalParser.prog_return retval = new xalParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        xalParser.decl_return decl1 =null;


        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:34:5: ( ( decl )+ -> ( decl )+ )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:34:9: ( decl )+
            {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:34:9: ( decl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:34:9: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_prog75);
            	    decl1=decl();

            	    state._fsp--;

            	    stream_decl.add(decl1.getTree());

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


            // AST REWRITE
            // elements: decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 34:15: -> ( decl )+
            {
                if ( !(stream_decl.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_decl.hasNext() ) {
                    adaptor.addChild(root_0, stream_decl.nextTree());

                }
                stream_decl.reset();

            }


            retval.tree = root_0;

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


    public static class decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decl"
    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:37:1: decl : ( component isa ID -> ^( component ID ) | component ID ':' STRING -> ^( component ID STRING ) | component relation component -> ^( component relation component ) );
    public final xalParser.decl_return decl() throws RecognitionException {
        xalParser.decl_return retval = new xalParser.decl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID4=null;
        Token ID6=null;
        Token char_literal7=null;
        Token STRING8=null;
        xalParser.component_return component2 =null;

        xalParser.isa_return isa3 =null;

        xalParser.component_return component5 =null;

        xalParser.component_return component9 =null;

        xalParser.relation_return relation10 =null;

        xalParser.component_return component11 =null;


        Object ID4_tree=null;
        Object ID6_tree=null;
        Object char_literal7_tree=null;
        Object STRING8_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_8=new RewriteRuleTokenStream(adaptor,"token 8");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_component=new RewriteRuleSubtreeStream(adaptor,"rule component");
        RewriteRuleSubtreeStream stream_relation=new RewriteRuleSubtreeStream(adaptor,"rule relation");
        RewriteRuleSubtreeStream stream_isa=new RewriteRuleSubtreeStream(adaptor,"rule isa");
        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:37:5: ( component isa ID -> ^( component ID ) | component ID ':' STRING -> ^( component ID STRING ) | component relation component -> ^( component relation component ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                switch ( input.LA(2) ) {
                case 10:
                case 11:
                case 14:
                    {
                    alt2=1;
                    }
                    break;
                case ID:
                    {
                    alt2=2;
                    }
                    break;
                case 9:
                case 12:
                case 13:
                    {
                    alt2=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:37:7: component isa ID
                    {
                    pushFollow(FOLLOW_component_in_decl91);
                    component2=component();

                    state._fsp--;

                    stream_component.add(component2.getTree());

                    pushFollow(FOLLOW_isa_in_decl93);
                    isa3=isa();

                    state._fsp--;

                    stream_isa.add(isa3.getTree());

                    ID4=(Token)match(input,ID,FOLLOW_ID_in_decl95);  
                    stream_ID.add(ID4);


                    // AST REWRITE
                    // elements: ID, component
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 37:24: -> ^( component ID )
                    {
                        // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:37:27: ^( component ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_component.nextNode(), root_1);

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:38:5: component ID ':' STRING
                    {
                    pushFollow(FOLLOW_component_in_decl109);
                    component5=component();

                    state._fsp--;

                    stream_component.add(component5.getTree());

                    ID6=(Token)match(input,ID,FOLLOW_ID_in_decl111);  
                    stream_ID.add(ID6);


                    char_literal7=(Token)match(input,8,FOLLOW_8_in_decl113);  
                    stream_8.add(char_literal7);


                    STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_decl115);  
                    stream_STRING.add(STRING8);


                    // AST REWRITE
                    // elements: ID, component, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 38:30: -> ^( component ID STRING )
                    {
                        // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:38:33: ^( component ID STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_component.nextNode(), root_1);

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_STRING.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:39:5: component relation component
                    {
                    pushFollow(FOLLOW_component_in_decl132);
                    component9=component();

                    state._fsp--;

                    stream_component.add(component9.getTree());

                    pushFollow(FOLLOW_relation_in_decl134);
                    relation10=relation();

                    state._fsp--;

                    stream_relation.add(relation10.getTree());

                    pushFollow(FOLLOW_component_in_decl136);
                    component11=component();

                    state._fsp--;

                    stream_component.add(component11.getTree());

                    // AST REWRITE
                    // elements: component, component, relation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 39:34: -> ^( component relation component )
                    {
                        // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:39:37: ^( component relation component )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_component.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_relation.nextTree());

                        adaptor.addChild(root_1, stream_component.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

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
    // $ANTLR end "decl"


    public static class component_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "component"
    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:42:1: component : ID -> ^( ID ) ;
    public final xalParser.component_return component() throws RecognitionException {
        xalParser.component_return retval = new xalParser.component_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID12=null;

        Object ID12_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:42:11: ( ID -> ^( ID ) )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:42:13: ID
            {
            ID12=(Token)match(input,ID,FOLLOW_ID_in_component159);  
            stream_ID.add(ID12);


            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 42:16: -> ^( ID )
            {
                // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:42:19: ^( ID )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_ID.nextNode()
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

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
    // $ANTLR end "component"


    public static class relation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relation"
    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:45:1: relation : ( 'depends on' | 'is implemented by' | 'is deployed on' );
    public final xalParser.relation_return relation() throws RecognitionException {
        xalParser.relation_return retval = new xalParser.relation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set13=null;

        Object set13_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:45:9: ( 'depends on' | 'is implemented by' | 'is deployed on' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            {
            root_0 = (Object)adaptor.nil();


            set13=(Token)input.LT(1);

            if ( input.LA(1)==9||(input.LA(1) >= 12 && input.LA(1) <= 13) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set13)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "relation"


    public static class isa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "isa"
    // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:50:1: isa : ( 'is' | 'is a' | 'is an' );
    public final xalParser.isa_return isa() throws RecognitionException {
        xalParser.isa_return retval = new xalParser.isa_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set14=null;

        Object set14_tree=null;

        try {
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:50:5: ( 'is' | 'is a' | 'is an' )
            // /Users/wilco/Documents/workspace/dependencies/parser/xal.g:
            {
            root_0 = (Object)adaptor.nil();


            set14=(Token)input.LT(1);

            if ( (input.LA(1) >= 10 && input.LA(1) <= 11)||input.LA(1)==14 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set14)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "isa"

    // Delegated rules


 

    public static final BitSet FOLLOW_decl_in_prog75 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_component_in_decl91 = new BitSet(new long[]{0x0000000000004C00L});
    public static final BitSet FOLLOW_isa_in_decl93 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_decl95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_component_in_decl109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_decl111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_decl113 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_decl115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_component_in_decl132 = new BitSet(new long[]{0x0000000000003200L});
    public static final BitSet FOLLOW_relation_in_decl134 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_component_in_decl136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_component159 = new BitSet(new long[]{0x0000000000000002L});

}