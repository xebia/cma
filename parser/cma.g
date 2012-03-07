grammar cma;

options {
  k = 5;
  language = Java;
  output=AST;
}

scope StackScope {
  //Target language syntax highlighter
  int operation;
}

@header {
package com.xebia.cma.parser;
//Target language syntax highlighter
import java.util.HashMap;
}

@invalidAction {
}

@members {
//Target language syntax highlighter
/** Map variable name to Integer object holding value */
  HashMap memory = new HashMap();
  
  public void someTargetMethod() {
  }
}

prog:   stat+ ;

stat:   expr NEWLINE {System.out.println($expr.value);}
    |   ID '=' expr NEWLINE
        {memory.put($ID.text, new Integer($expr.value));}
    |   NEWLINE
    ;

expr returns [int value]
    :   e=multExpr {$value = $e.value;}
        (   '+' e=multExpr {$value += $e.value;}
        |   '-' e=multExpr {$value -= $e.value;}
        )*
    ;
    
multExpr returns [int value]
    :   e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
    ; 
    
atom returns [int value]
    :   INT {$value = Integer.parseInt($INT.text);}
    |   ID
        {
        Integer v = (Integer)memory.get($ID.text);
        if ( v!=null ) $value = v.intValue();
        else System.err.println("undefined variable "+$ID.text);
        }
    |   '(' expr ')' {$value = $expr.value;}
    ;
        
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
