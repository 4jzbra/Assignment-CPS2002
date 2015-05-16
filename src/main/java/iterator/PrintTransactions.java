package iterator;

import java.util.ArrayList;

import mt.edu.um.AtomicTransaction;
import mt.edu.um.CompoundTransaction;
import mt.edu.um.Transaction;

public class PrintTransactions {
			
	boolean printTransactions(ArrayList<AtomicTransaction> array){
		for(AtomicTransaction atomicTrans : array){
			System.out.print("Source: " + atomicTrans.getSourceAccountNumber());
			System.out.print("   Destination: "+ atomicTrans.getDestinationAccountNumber());
			System.out.print("   Amount: " + atomicTrans.getAmount() + "\n");
		}
		return true;
	}

}
