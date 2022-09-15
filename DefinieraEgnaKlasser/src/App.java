
public class App {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(20,20);
        Rectangle rectangle3 = new Rectangle(3.3, 4.5);

        SavingsAccount saving1 = new SavingsAccount("2000", "konto1");
        saving1.calculateMonthlyInterest();
        System.out.println(saving1);

        SavingsAccount saving2 = new SavingsAccount("2000", "konto2");
        saving2.calculateMonthlyInterest();
        System.out.println(saving2);

        saving1.changeRate("0.01");
        saving2.changeRate("0.02");

        for (int i = 0; i < 12; i++) {
            System.out.printf("Månad %1$d %s:%s%nMånad %1$d %s:%s", i, saving1.getName(), saving1, saving2.getName(), saving2 );
            saving1.calculateMonthlyInterest();
            saving2.calculateMonthlyInterest();
                    }
        
        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);
    }
}
