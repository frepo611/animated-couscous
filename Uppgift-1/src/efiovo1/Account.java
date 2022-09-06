package efiovo1;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private int balance;
    private double interestRate;
    private int accountNumber;
    private String accountType;

    public Account(int balance, double interestRate, int accountNumber, String accountType) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.accountType = accountType;

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        
        String balanceStr = NumberFormat.getCurrencyInstance().format(balance);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
        percentFormat.setMaximumFractionDigits(1); // Anger att vi vill ha max 1 decimal
        String percentStr = percentFormat.format(interestRate / 100);
        
        return String.format("%d %s %s %s", accountNumber, balanceStr, accountType, percentStr);
    }

}
