
public class SavingsAccount extends BankAccount {
  public SavingsAccount (int balance, double interestRate, String accountNum) {
    super(balance, interestRate, accountNum);
  }
  public boolean debit(int amountInPennies) {
    if (this.balanceInPennies + amountInPennies < 0) {
      return false;
    }
    this.balanceInPennies += amountInPennies;
    return true;
  }
  public void applyInterest() {
    if (this.balanceInPennies == 0) {
      return;
    }
    this.balanceInPennies *= this.interestRate + 1.0;
    this.toString();
  }
	@Override
	public String toString() {
		return "\nAccount type\t:\tSavings\nAccount ID:\t:\t" + accountNumber + "\n Balance\t\t:\t" + balanceInPennies + "\nInterest rate\t:\t" + interestRate + "\n";
	}
}
