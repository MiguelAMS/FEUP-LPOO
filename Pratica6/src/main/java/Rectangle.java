public class Rectangle implements Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() { return height; }
    public double getWidth() { return width; }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String draw() {
        return "Rectangle";
    }
}
