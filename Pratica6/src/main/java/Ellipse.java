public class Ellipse implements Shape {
    private double xRadius;
    private double yRadius;

    Ellipse(double xRadius, double yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public double getxRadius() { return xRadius; }
    public double getyRadius() { return yRadius; }

    @Override
    public double getArea() {
        return Math.PI * xRadius * yRadius;
    }

    @Override
    public String draw() {
        return "Ellipse";
    }
}
