
public class AddressOperand extends Operand
{
  public AddressOperand(long address) { this.address = address;} 
  private long address;
  public long GetAddress() { return address;}
  public char GetType() { return 'A';}
}