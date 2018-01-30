public abstract class BankAccount {
	protected int balanceInPennies;
	protected double interestRate;
	protected String accountNumber;
	public BankAccount(int balance, double interest, String acctNum) {
		this.balanceInPennies = balance;
		this.interestRate = interest;
		this.accountNumber = acctNum;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNo) {
		this.accountNumber = accountNo;
	}
	public boolean credit(int amountPennies){
		return false;
	}
	public abstract boolean debit(int amountPennies);
	public int getBalanceInPennies() {
		return balanceInPennies;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double rate) {
		this.interestRate = rate;
	}
	public abstract void applyInterest();
	@Override
	public String toString() {
		return "\nAccount ID:\t:\t" + accountNumber + "\n Balance\t\t:\t" + balanceInPennies + "\nInterest rate\t:\t" + interestRate + "\n";
	}
	
}
