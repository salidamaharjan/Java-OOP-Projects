package org.example;

public class Triangle implements Shape{
    double base;
    double height;
    double a;
    double c;

    public Triangle(double base, double height, double a, double c) {
        this.base = base;
        this.height = height;
        this.a = a;
        this.c = c;
    }

    @Override
    public void calculateArea() {
        double area = (base * height) / 2;
        System.out.printf("Area of Triangle: %.2f%n", area);
    }
    @Override
    public void calculatePerimeter() {
    double perimeter = a + base + c;
        System.out.printf("Perimeter of Triangle: %.2f%n", perimeter);
    }
}
