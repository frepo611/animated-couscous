import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {
    // all objects get this rate
    static String rate = "0";
    // a BigDecimal object representing the number 12
    final static BigDecimal TWELVE = BigDecimal.valueOf(12);
    private BigDecimal balance;
    private String name;

public SavingsAccount(String balance, String name) {
    this.balance = new BigDecimal(balance);
    this.name = name;
}
public SavingsAccount() {
    this.balance = BigDecimal.ZERO;
}
public SavingsAccount(String balance) {
    this.balance = new BigDecimal(balance);
}

    public void calculateMonthlyInterest() {
        // a BigDecimal object representing the interest rate

        BigDecimal rate = new BigDecimal(SavingsAccount.rate);
        
        // the divide method can be tricky, we need a rounding behavior and a scale
        
        // "In the case of divide, the exact quotient
        // could have an infinitely long decimal expansion; for example, 1 divided by 3.
        // If the quotient has a nonterminating decimal expansion and the operation is
        // specified to return an exact result, an ArithmeticException is thrown.
        // Otherwise, the exact result of the division is returned, as done for other
        // operations."
        //
        
        BigDecimal monthlyInterest = balance.multiply(rate).divide(TWELVE, 2, RoundingMode.UP);
        balance = balance.add(monthlyInterest);
    }
    
    public static void changeRate(String rate) {
        SavingsAccount.rate = rate; 
    }
    
    public String getRate() {
        return SavingsAccount.rate;
    }
    
    @Override
    public String toString() {
        return String.format("%s ränta:%s saldo:%s", this.name, this.getRate(), this.getBalance());
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance.toString();
    }

    
}
