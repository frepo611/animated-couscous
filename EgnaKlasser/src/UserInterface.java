import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void start() {
        
        uiLoop:
        while (true) {
            System.out.println("1. Hypothenuse");
            System.out.println("2. Volume of sphere");
            System.out.println("3. Real square roots");
            System.out.println("q. Quit");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                System.out.print("Enter first leg: ");
                double legA = Double.valueOf(scanner.nextLine());
                System.out.print("Enter second leg: ");
                double legB = Double.valueOf(scanner.nextLine());
                RightTriangle triangle = new RightTriangle(legA, legB);
                System.out.printf("First leg: %f, Second leg: %f, Hypothenuse: %f%n", legA, legB, triangle.hypothenuse());

                break;
                case "2":
                System.out.print("Enter radius: ");
                double radius = Double.valueOf(scanner.nextLine());
                Sphere sphere = new Sphere(radius);
                System.out.printf("Radius: %f, Volume: %f%n", radius, sphere.volume());
                    
                    break;
                case "3":
                System.out.print();
                    
                    break;
                case "q":
                    
                    break uiLoop;
            
                default:
                    break;
            }
        }
    }
}
    
