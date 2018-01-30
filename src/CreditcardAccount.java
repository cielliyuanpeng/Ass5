
public class CreditcardAccount extends BankAccount {
  protected int creditLimitPennies;
  public CreditcardAccount (int balance, double interestRate, String accountNum, int creditcardLimit) {
    super(balance, interestRate, accountNum);
    this.creditLimitPennies = creditLimitPennies;
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
		return "\nAccount type\t:\tCreditcard\nAccount ID:\t:\t" + accountNumber + "\n Balance\t\t:\t" + balanceInPennies + "\nInterest rate\t:\t" + interestRate + "\n";
	}
}
