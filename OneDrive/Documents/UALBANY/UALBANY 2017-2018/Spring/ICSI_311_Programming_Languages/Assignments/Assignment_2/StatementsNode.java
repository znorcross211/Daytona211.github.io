import java.util.*;


public class StatementsNode extends Node
{
  public Queue<Node> children;
  public StatementsNode ( Queue<Node> statementNodes) { children = statementNodes; } 
  public char GetType() { return 's';}
}