package efiovo1;

public class App {
    public static void main(String[] args) throws Exception {

        BankLogic bank = new BankLogic();

        String customerName = "Olle";
		String customerSurname = "Ohlsson";
		String personalNumber = "0005221898";
        bank.createCustomer(customerName, customerSurname, personalNumber);
        System.out.println(bank.getAllCustomers()); 
    }
}
