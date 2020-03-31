package com.aor.refactoring.example2;

public class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return this.getWidth() * getHeight();
    }

    public double getPerimeter() {
        return 2 * (this.getHeight() + getWidth());
    }

    public void draw(GraphicFramework graphics) {
        double height = this.getHeight();
        double width = this.getWidth();
        double x = this.getX();
        double y = this.getY();

        graphics.drawLine(x, y, x + width, y);
        graphics.drawLine(x + width, y, x + width, y + height);
        graphics.drawLine(x + width, y + height, x, y + height);
        graphics.drawLine(x, y + height, x, y);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
