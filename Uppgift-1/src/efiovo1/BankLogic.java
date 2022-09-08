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
        // return false if the customer already exists
        if (customerExists(pNo)) {
            return false;
        } else {
            // add customer
            Customer customer = new Customer(name, surname, pNo);
            customerList.add(customer);
            return true;
        }
    }

    public ArrayList<String> deleteCustomer(String pNo) {
        ArrayList<String> closedAccounts = null;
        if (customerExists(pNo)) {
            findCustomer(pNo).
            //remove customer
            customerList.remove(findCustomer(pNo));
        }
        return closedAccounts;
    }

    public String closeAccount(String pNo, int accountNumber) {
        if (customerExists(pNo)) {
            Customer customer = findCustomer(pNo);
            Account account = customer.getAccount(accountNumber);
            if (customer.accountExists(accountNumber)) {
                return account.closedAccountToString();
            } else {
                return null;
            }
        }
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
