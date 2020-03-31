public class Line implements BasicShape {
    private double length;

    Line(double length) {
        this.length = length;
    }

    @Override
    public String draw() {
        return "Line";
    }
}
