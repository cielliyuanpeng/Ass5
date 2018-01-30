import java.lang.Math;
public class CheckingAccount extends BankAccount {
  private int overdraftFeePennies;
  public CheckingAccount (int balance, double interestRate, String accountNum, int overdraftFeeInPennies) {
    super(balance, interestRate, accountNum);
    this.overdraftFeePennies = overdraftFeePennies;
  }
  public boolean debit(int amountInPennies) {
    if (this.balanceInPennies + amountInPennies < 0) {
      this.overdraftFeePennies = Math.abs(this.balanceInPennies + amountInPennies);
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
		return "\nAccount type\t:\tChecking\nAccount ID:\t:\t" + accountNumber + "\n Balance\t\t:\t" + balanceInPennies + "\nInterest rate\t:\t" + interestRate + "\n";
	}
}
