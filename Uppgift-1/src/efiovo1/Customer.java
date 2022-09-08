package efiovo1;

import java.util.ArrayList;

public class Customer {

    private String name;
    private String surname;
    private String pNo;
    private ArrayList<Account> accountList;

    public Customer(String name, String surname, String pNo) {
        this.name = name;
        this.surname = surname;
        this.pNo = pNo;
        this.accountList = new ArrayList<Account>();
    }

    private boolean deleteAccount(int accountNumber) {
      
        return false;
    }

    public Account getAccount(int accountNumber) {
     
        return null;
    }

    public boolean accountExists(int accountNumber) {
       
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s", getName(), getSurname(), getpNo());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

}
