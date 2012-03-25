grammar xal;

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
package com.xebia.xal.parser;
//Target language syntax highlighter
import java.util.HashMap;
}

@lexer::header {package com.xebia.xal.parser;}

@invalidAction {
}

@members {
//Target language syntax highlighter
/** Map variable name to Integer object holding value */
  HashMap memory = new HashMap();
  
  public void someTargetMethod() {
  }
}

prog:   decl+ -> decl+
  ;

decl: component isa ID -> ^(component ID)
  | component ID 'is' STRING  -> ^(component ID STRING)
  | component relation component -> ^(component relation component)
  ;
  
component : ID -> ^(ID)
  ;

relation returns [String value]
  : 'depends' 'on' { $value = "depends on"; }
  | 'is' 'implemented' 'by' { $value = "is implemented by"; }
  | 'is' 'deployed' 'on' { $value = "is deployed on"; }
  ;
  
isa returns [String value]
  : 'is' 'a' { $value = "is a"; }
  | 'is' 'an'{ $value = "is a"; }
  ;
        
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'.')* ;
STRING : '"' (~'"')* '"' ;

COMMENT: '#' (~'\n')* '\n' { $channel = HIDDEN; } ;
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
