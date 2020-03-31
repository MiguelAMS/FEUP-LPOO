package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        this.discount = new NullDiscount();
    }

    public double getTotal() {
        return this.getDiscount().applyDiscount(this.getPrice());
    }

    public Discount getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}