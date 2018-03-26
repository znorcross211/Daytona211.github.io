
public class RegisterOperand extends Operand
{
  public RegisterOperand(int register) {this.register = register;}
  private int register;
  public int GetRegister() { return register;}
  public char GetType() { return 'R';}
}
