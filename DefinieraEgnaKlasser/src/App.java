public class App {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(20,20);
        Rectangle rectangle3 = new Rectangle(3.3, 4.5);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);
    }
}
