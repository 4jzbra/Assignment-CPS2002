package mt.edu.um;

import java.util.Date;

public class Transaction {

	protected int sourceAccountNumber; // source of transaction
	protected int destinationAccountNumber; // destination of transaction
	protected long amount;
	private Date startTime;

	public Transaction() { // default constructor

	}

	public Transaction(int src, int dst, long amt) {
		setSourceAccountNumber(src);
		setDestinationAccountNumber(dst);
		setAmount(amt);
	}

	public boolean process() {
		Account source = AccountDatabase.getAccount(sourceAccountNumber);
		Account destination = AccountDatabase.getAccount(destinationAccountNumber);
		
		// source account not found or transaction in less than 15 seconds
		if ((source == null) || ((new Date().getTime() - source.getEolt()) < 15000)) { 
			System.out.println("Error: Source account does not exist!");
			return false;
		}
		
		// destination account not found or transaction in less than 15 seconds
		if ((destination == null) || ((new Date().getTime() - destination.getEolt()) < 15000)) {
			System.out.println("Error: Destination account does not exist!");
			return false;
		}
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - amount) > 0) {
			System.out.println("here");
			source.setEolt(new Date().getTime());
			destination.setEolt(new Date().getTime());
			return true;
		} else {
			System.out.println("Error: Source account balance is not sufficient");
			return false;
		}
	}

	public void setSourceAccountNumber(int accNo) {
		sourceAccountNumber = accNo;
	}

	public void setDestinationAccountNumber(int accNo) {
		destinationAccountNumber = accNo;
	}

	public void setAmount(long amt) {
		amount = amt;
	}

	public void setStartOfTransaction(Date time) {
		startTime = time;
	}

	public Date getStartOfTransaction() {
		return startTime;
	}

	public int getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public int getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public long getAmount() {
		return amount;
	}

}
