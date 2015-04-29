package mt.edu.um;

import java.util.ArrayList;
import java.util.Date;

//handles the processTransaction of Compound transaction
public class CompoundTransactionManager extends TransactionManager {
	ArrayList<Transaction> elements;

	public CompoundTransactionManager() {

	}

	public boolean processTransaction(Transaction transaction) {
		elements = transaction.getElements();
		for (Transaction temp : elements) {
			Account source = AccountDatabase.getAccount(temp.getSourceAccountNumber());
			Account destination = AccountDatabase.getAccount(temp.getDestinationAccountNumber());
			
			if(!temp.process()){
				System.out.println("Failed at temp.process()");
				return false;
			}
			
			boolean boolSrc = true, boolDst = true;
			Date date = new Date();
			long now = date.getTime();     // storing current time

			if (map.containsKey(temp.getSourceAccountNumber())) {
				if (map.get(temp.getSourceAccountNumber()) > now){
					boolSrc = false;
				}
			}

			if (map.containsKey(temp.getDestinationAccountNumber())) {
				if (map.get(temp.getDestinationAccountNumber()) > now){
					boolDst = false;
				}
			}
			
			if (boolSrc && boolDst) {
				map.put(source.getAccountNumber(), now + 15000);    // keeping track of source account & time
				map.put(destination.getAccountNumber(), now + 15000);  // keeping track of destination account & time

				source.setAccountBalance(source.getAccountBalance() - temp.getAmount());  // transfer source
				destination.setAccountBalance(destination.getAccountBalance() + temp.getAmount()); // transfer destination
				
				++numTransactionsProcessed;
				return true;
			} 
			else
				return false;
		}
		return true;
	}
}
