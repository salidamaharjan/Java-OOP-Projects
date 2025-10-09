package org.example;

public class Circle implements Shape{
    private double radius;
    public Circle(double radius){
       this.radius = radius;
    }
    @Override
    public double calculateArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
