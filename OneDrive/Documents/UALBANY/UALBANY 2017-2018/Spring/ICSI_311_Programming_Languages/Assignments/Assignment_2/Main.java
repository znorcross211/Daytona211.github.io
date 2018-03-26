import java.util.*;

public class Main {

  public static void main(String[] args) {
    Queue<Node> adds = new LinkedList<Node>();
    adds.add(new TwoOperandNode('+',new RegisterOperand(0),new RegisterOperand(1)));
    adds.add(new TwoOperandNode('+',new RegisterOperand(1),new RegisterOperand(2)));
    adds.add(new TwoOperandNode('+',new RegisterOperand(2),new RegisterOperand(3)));
    adds.add(new TwoOperandNode('+',new RegisterOperand(3),new RegisterOperand(4)));
    adds.add(new TwoOperandNode('+',new RegisterOperand(4),new RegisterOperand(5)));

    Queue<Node> subs = new LinkedList<Node>();
    subs.add(new TwoOperandNode('-',new RegisterOperand(0),new RegisterOperand(1)));
    subs.add(new TwoOperandNode('-',new RegisterOperand(1),new RegisterOperand(2)));
    subs.add(new TwoOperandNode('-',new RegisterOperand(2),new RegisterOperand(3)));
    subs.add(new TwoOperandNode('-',new RegisterOperand(3),new RegisterOperand(4)));
    subs.add(new TwoOperandNode('-',new RegisterOperand(4),new RegisterOperand(5)));
    subs.add(new TwoOperandNode('-',new AddressOperand(1000),new AddressOperand(2000)));

    Queue<Node> baseNodes = new LinkedList<Node>();
    baseNodes.add(new TwoOperandNode('-',new AddressOperand(3333),new AddressOperand(4444)));
    baseNodes.add(new WhileNode(new StatementsNode(adds),new StatementsNode(subs)));
    Node base = new StatementsNode(baseNodes);
    Visitor.Visit(base);
  }
}
