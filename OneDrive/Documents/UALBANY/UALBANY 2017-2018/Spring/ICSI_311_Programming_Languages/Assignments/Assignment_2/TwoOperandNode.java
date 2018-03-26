public class TwoOperandNode extends Node
{
  private char type;
  public TwoOperandNode (char t, Operand o1, Operand o2) { type = t; operand1=o1;operand2=o2;}
  public Operand operand1;
  public Operand operand2;
  public char GetType() { return type;}
}