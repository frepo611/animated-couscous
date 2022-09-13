package efiovo1;

import java.util.ArrayList;

public class BankLogic {

    private CustomerRegister customerList;

    public BankLogic() {
        this.customerList = new H<>();
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

        if (customerExists(pNo)) {
            // find customer using pNo, write customer data
            customerAccountList.add(findCustomer(pNo).toString());
            // write customer account data, copy account info from AccountList
            for (Account account : findCustomer(pNo).getAccountList()) {
                customerAccountList.add(account.toString());
            }
            return customerAccountList;
        } else {
            return null;
        }
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

    private boolean customerExists(String pNo) {
        for (Customer customer : customerList) {
            // return if pNo is found
            if (customer.getpNo().equals(pNo)) {
                return true;
            }
        }
        return false;
    }

    private Customer findCustomer(String pNo) {
        for (Customer customer : customerList) {
            // return if pNo is found
            if (customer.getpNo().equals(pNo)) {
                return customer;
            }
        }
        return null;
    }

}
