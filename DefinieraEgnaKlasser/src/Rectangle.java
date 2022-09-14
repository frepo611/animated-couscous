public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        if (0 < length && length < 20) {
            this.length = length;
        } else {this.length = 1;}
        if (0 < width && width < 20) {
            this.width = width;
        } else {this.width = 1;}
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (0 < length && length < 20) {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (0 < width && width < 20) {
            this.width = width;
        }
    }

    public double circumference() {
        return 2 * length + 2 * width;
    }

    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return String.format("Area: %.2f, Circumference: %.2f", circumference(), area());
    }

}
