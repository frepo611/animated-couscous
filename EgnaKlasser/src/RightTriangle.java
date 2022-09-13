public class RightTriangle {

    private double legA;
    private double legB;

    public RightTriangle(double legA, double legB) {
        this.legA = legA;
        this.legB = legB;
    }

    public double hypothenuse() {
        return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
    }

    @Override
    public String toString() {
        return String.valueOf(hypothenuse());
    }
}
