import java.util.Scanner;


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
            System.out.println("3. Square roots");
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
                System.out.print("Enter quadratic coefficient: ");
                double a = Double.valueOf(scanner.nextLine());
                System.out.print("Enter linear coefficient: ");
                double b = Double.valueOf(scanner.nextLine());
                System.out.print("Enter constant: ");
                double c = Double.valueOf(scanner.nextLine());
                QuadraticEquation qEquation = new QuadraticEquation(a, b, c);
                System.out.println(qEquation.solver());
                    

                    
                    break;
                case "q":
                    
                    break uiLoop;
            
                default:
                    break;
            }
        }
    }
}
    
