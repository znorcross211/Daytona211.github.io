public class Visitor{

	//DEBUG RECURSING DOWN MULTIPLE TIMES

	public static void Visit(Node member){ 

		/*Handles general flow  */
		int instructCount = 0;
		StatementsNode sNode = (StatementsNode)member;

		stateNode(sNode, instructCount);
	}

	private static int stateNode(StatementsNode sNode, int instructCount){
		
		if(sNode.children.peek() == null){
			//System.out.println("Empty Queue");
			return instructCount;
		}

		if(sNode.children.peek() != null){
			Node nodeToPass = (Node) sNode.children.remove(); // convert Statement Node's child to a general Node so it can be safely passed
			//System.out.println("nonempty Queue");
			instructCount = allNode(nodeToPass, instructCount); // pass for allNode to handle the determining of the type and handling accordingly
			instructCount = stateNode(sNode, instructCount);
		}
			return instructCount;	
	}

	private static int allNode(Node curNode, int instructCount){

		if(curNode.GetType() == 'w'){
			WhileNode wNode = (WhileNode)curNode;

			int saveInstructCount = instructCount;

			instructCount = stateNode(wNode.conditions, instructCount);
			System.out.println(instructCount + ": bne $00000000");
			instructCount++;
			instructCount = stateNode(wNode.statements, instructCount);
			System.out.println(instructCount + ": jmp $" + saveInstructCount);
		}

		else if(curNode.GetType() != 'w' || curNode.GetType() != 's'){

			System.out.print(instructCount + ": "); // Printing the instruction counter

			if (curNode.GetType() == '+')
				System.out.print("add ");
			else if (curNode.GetType() == '-')
				System.out.print("sub ");
			else if (curNode.GetType() == '*')
				System.out.print("mul ");
			else if (curNode.GetType() == '/')
				System.out.print("div ");

			if(curNode instanceof TwoOperandNode ){
				TwoOperandNode twoOpNode = (TwoOperandNode) curNode;

				if(twoOpNode.operand1.GetType() == 'R'){
					RegisterOperand reg = (RegisterOperand) twoOpNode.operand1;	
					System.out.print("R" + reg.GetRegister() + ",");
				}

				else if(twoOpNode.operand1.GetType() == 'A'){
					AddressOperand reg = (AddressOperand) twoOpNode.operand1;
					System.out.print("$" + reg.GetAddress() + ",");	
				}

				if(twoOpNode.operand2.GetType() == 'R'){
					RegisterOperand reg = (RegisterOperand) twoOpNode.operand2;
					System.out.print("R" + reg.GetRegister() + "\n");
				}

				else if( twoOpNode.operand2.GetType() == 'A' ){
					AddressOperand reg = (AddressOperand) twoOpNode.operand2;
					System.out.print("$" + reg.GetAddress() + " \n");
				}

				instructCount++;
				return instructCount;
			}

			else if(curNode instanceof WhileNode){
				System.out.println("While Node found");
			}
					
		}


		/* Handle all other types of nodes if there is another statements node call visit */
			return instructCount;
	}

	private static void printAddress(AddressOperand add){

			String addressOne = ("$" + Long.toString(add.GetAddress()) + "," );
			System.out.print(addressOne);

	}
}