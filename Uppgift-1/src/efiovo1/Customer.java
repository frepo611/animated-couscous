package efiovo1;

import java.util.ArrayList;

public class Customer {

    private String name;
    private String surname;
    private PersonalNumber pNo;
    private ArrayList<Account> accountList;

    public Customer(String name, String surname, PersonalNumber pNo) {
        this.name = name;
        this.surname = surname;
        this.pNo = pNo;
        this.accountList = new ArrayList<Account>();
    }

    private boolean deleteAccount(int accountNumber) {
        if (accountExists(accountNumber)) {
            for (Account account : accountList) {
                if (account.getAccountNumber() == accountNumber) {
                    accountList.remove(account);
                    return true;
                }
            }
        }
        return false;
    }

    public Account getAccount(int accountNumber) {
        if (accountExists(accountNumber)) {
            for (Account account : this.accountList) {
                if (account.getAccountNumber() == accountNumber) {
                    return account;
                }    
            }
        }
        return null;
    }

    public boolean accountExists(int accountNumber) {
        for (Account account : this.accountList) {
            // return if account is found
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
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

    public PersonalNumber getpNo() {
        return pNo;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

}
