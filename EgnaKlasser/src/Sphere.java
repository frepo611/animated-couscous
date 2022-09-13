public class Sphere {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return (4 * Math.PI * Math.pow(radius, 3) / 3);
    }
    
}
