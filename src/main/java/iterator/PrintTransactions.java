package iterator;

import java.util.ArrayList;

import mt.edu.um.AtomicTransaction;

public class PrintTransactions {
			
	boolean printTransactions(ArrayList<AtomicTransaction> array){
		
		if (array == null)  return false;
		
		for(AtomicTransaction atomicTrans : array){
			System.out.print("Source: " + atomicTrans.getSourceAccountNumber());
			System.out.print("   Destination: "+ atomicTrans.getDestinationAccountNumber());
			System.out.print("   Amount: " + atomicTrans.getAmount() + "\n");
		}
		return true;
	}

}
