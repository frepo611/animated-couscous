package efiovo1;

import java.util.ArrayList;

public class BankLogic {

    private ArrayList<Customer> customerList;

    public BankLogic() {
        this.customerList = new ArrayList<>();
    }

    public ArrayList<String> getAllCustomers() {
        // return variable for customers as String objects
        ArrayList<String> customers = new ArrayList<>();
        // add every customer as a String object
        for (Customer customer : customerList) {
            customers.add(customer.toString());
        }
        return customers;
    }

    public ArrayList<String> getCustomer(String pNo) {
        ArrayList<String> customerAccountList = new ArrayList<>();

        return null;
    }

    public boolean createCustomer(String name, String surname, String pNo) {

        return true;
    }

    public ArrayList<String> deleteCustomer(String pNo) {
        ArrayList<String> closedAccounts = null;

        return closedAccounts;
    }

    public String closeAccount(String pNo, int accountNumber) {

        return null;
    }

    private boolean customerExists(String pNo) {

        return false;
    }

    private Customer findCustomer(String pNo) {

        return null;
    }

	public String getAccount(String pNo, int accountId) {
		return null;
	}

    public boolean changeCustomerName(String name, String surname, String pNo) {
        return false;
    }

    public int createSavingsAccount(String pNo) {
        return 0;
    }

    public boolean deposit(String pNo, int accountId, int amount) {
        return false;
    }

    public boolean withdraw(String pNo, int accountId, int amount) {
        return false;
    }

}
