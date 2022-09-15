
public class App {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(20,20);
        Rectangle rectangle3 = new Rectangle(3.3, 4.5);

        System.out.println("Skapar ett object med default ränta (=0)");
        SavingsAccount saving1 = new SavingsAccount("2000", "konto1");
        System.out.println(saving1);
        System.out.println("Ändrar räntan till 1% och skapar ett nytt object");
        SavingsAccount.changeRate("0.01");
        SavingsAccount saving2 = new SavingsAccount("3000", "konto2");
        System.out.println(saving2);

        System.out.println("Räntan har gemensam för alla object");

        for (int i = 0; i < 12; i++) {
            System.out.printf("Månad %1$d %2$s:%3$s %4$s:%5$s%n", i, saving1.getName(), saving1, saving2.getName(), saving2);
            saving1.calculateMonthlyInterest();
            saving2.calculateMonthlyInterest();
                    }
        
        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);
    }
}
