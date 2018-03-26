public class WhileNode extends Node
{
  public StatementsNode statements;
  public StatementsNode conditions;
  public WhileNode (StatementsNode childNodes, StatementsNode  statementNodes) {
    conditions = childNodes; statements = statementNodes;  } 
  public char GetType() { return 'w';}
}