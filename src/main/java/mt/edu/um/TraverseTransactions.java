package mt.edu.um;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TraverseTransactions {

	private CompoundTransaction compoundTransaction;
	private List<Transaction> sortedElements;
	private int index;

	public TraverseTransactions() {
	}

	public TraverseTransactions(CompoundTransaction compoundTransaction) {
		this.compoundTransaction = compoundTransaction;
		this.sortedElements = new ArrayList<Transaction>();
		
		index = 1;
	}

	/*
	 * public boolean traverse(){ Iterator<Transaction> AtomicT =
	 * transIter.createIterator();
	 * 
	 * if (printTransaction(AtomicT)) return true;
	 * 
	 * else return false; }
	 */

	public boolean printTransaction() { // STILL NEEDS SORTING

		for (Iterator<Transaction> iter = compoundTransaction.createIterator(); iter
				.hasNext();) {
			AtomicTransaction atomicTrans = (AtomicTransaction) iter.next();
			System.out.println("-----USING ITERATOR-----");
			System.out.println(this.index++ + ". Transaction ");
			System.out.println("Source: "
					+ atomicTrans.getSourceAccountNumber());
			System.out.println("Destination: "
					+ atomicTrans.getDestinationAccountNumber());
			System.out.println("Amount: " + atomicTrans.getAmount() + "\n");
		}

		return true;
	}

	public boolean printAscendingOder() {
		
		for (Iterator<Transaction> iter = compoundTransaction.createIterator(); iter.hasNext();) {
			AtomicTransaction atomicTrans = (AtomicTransaction) iter.next();
			sortedElements.add(atomicTrans);
		}

		Collections.sort(sortedElements, new AtomicTransaction());
		System.out.println("Lowest amount first\n");
		printElements(sortedElements);
		return true;

	}

	public boolean printDescendingOrder() {
		return false;

	}

	public void printElements(List<Transaction> list) {
		for (int i = 0; i < sortedElements.size(); i++) {
			AtomicTransaction atomicTrans = (AtomicTransaction) sortedElements.get(i);
			System.out.print("Transaction "+(i+1)+": ");
			System.out.print("Source: " + atomicTrans.getSourceAccountNumber());
			System.out.print("   Destination: "+ atomicTrans.getDestinationAccountNumber());
			System.out.print("   Amount: " + atomicTrans.getAmount() + "\n\n");

		}
	}

}
