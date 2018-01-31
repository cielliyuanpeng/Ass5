
public class BankAccountParser {
  public static BankAccount parseStringToBankAccount(String lineToParse) {
    String[] dataArray = lineToParse.split("/");
    switch (dataArray[0]) {
      case "SA": return new SavingsAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3]);
      case "CH": return new CheckingAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3],
        Integer.parseInt(dataArray[4]));
      case "CR": return new CreditcardAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3],
        Integer.parseInt(dataArray[4]));
    }
	return null;
  }
}
