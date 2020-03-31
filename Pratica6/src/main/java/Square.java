public class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    public double getSide() { return side; }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public String draw() {
        return "Square";
    }
}
