package com.capstone.retailStore.Customer.Inheritance;

public class MainClass {
    public static void main(String[] args) {
        Child c = new Child();
        c.setA(1);
        c.setX(1);
        c.setY(1);
        c.direction();
        System.out.println(c.getX() + "-"+c.getY() + " -"+c.getA());
    }
}
