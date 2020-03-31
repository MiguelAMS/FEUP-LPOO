public class Triangle implements Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() { return base; }
    public double getHeight() { return height; }

    @Override
    public double getArea() {
        return height * (base/2);
    }

    @Override
    public String draw() {
        return "Triangle";
    }
}
