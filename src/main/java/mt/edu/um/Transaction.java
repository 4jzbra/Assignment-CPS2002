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
		
		if ((source == null)) {
			System.out.println("Error: Source account does not exist!");
			return false;
		}
		if ((destination == null)) {
			System.out.println("Error: Destination account does not exist!");
			return false;
		}
		if ((source.getAccountBalance() >= 0) && (source.getAccountBalance() - amount) > 0) {
			System.out.println("here");
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
