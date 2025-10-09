package org.example;

public class Rectangle implements Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public void calculateArea() {
        double areaOfRectangle = length * width;
        System.out.printf("Area of Rectangle: %.2f%n", areaOfRectangle);
    }

    @Override
    public void calculatePerimeter() {
        double perimeterOfRectangle = 2 * (length + width);
        System.out.printf("Perimeter of Rectangle: %.2f%n", perimeterOfRectangle);
    }
}
