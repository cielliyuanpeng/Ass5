
public class BankAccountParser {
  public static BankAccount parseStringToBankAccount(String lineToParse) {
    String[] dataArray = lineToParse.split("/");
    switch (dataArray[0]) {
      case "SA": return SavingsAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3]);
      case "CH": return CheckingAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3],
        Integer.parseInt(dataArray[4]));
      case "CR": return CreditcardAccount(
        Integer.parseInt(dataArray[1]),
        Double.parseDouble(dataArray[2]),
        dataArray[3],
        Integer.parseInt(dataArray[4]));
    }
  }
}
