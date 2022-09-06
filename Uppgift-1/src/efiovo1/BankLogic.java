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

        if (PersonNumbers.contains(pNo)) {
            // find customer using pNo
            for (Customer customer : customerList) {
                if (customer.getpNo().equals(pNo)) {
                    // write customer data
                    customerAccountList.add(customer.toString());
                    // write customer account data, copy account info from AccountList
                    for (Account account : customer.getAccountList()) {
                        customerAccountList.add(account.toString());
                    }
                    return customerAccountList;
                }
            }
        } else {
            return null;
        }
    }

    public boolean createCustomer(String name, String surname, String pNo) {

        if (pNoIsNew(pNo)) {
            Customer customer = new Customer(name, surname, pNo);
            customerList.add(customer);
            return true;
        } else {
            return false;
        }
    }

    private boolean pNoIsNew(String pNo) {
        for (Customer customer : customerList) {
            // return if pNo is found
            if (customer.getpNo().equals(pNo)) {
                return false;
            }
        }
        return true;
    }

}
