package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius;

    Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() throws Exception {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    public double getPerimeter() throws Exception {
        return 2 * this.getRadius() * Math.PI;
    }

    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(x, y, radius);
    }

    public double getRadius() {
        return radius;
    }
}
