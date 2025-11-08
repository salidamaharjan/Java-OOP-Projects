package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Rectangle implements Shape {
    private final double length;
    private final double width;
    private double area;
    private double perimeter;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        this.area = length * width;
        System.out.printf("Area of Rectangle: %.2f%n", this.area);
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * (length + width);
        System.out.printf("Perimeter of Rectangle: %.2f%n", this.perimeter);
    }

    @Override
    public Shape read() {
        try {
            final List<String> lines = Files.readAllLines(Path.of("rectangle.csv"));
            for(int i = 0; i < lines.size(); i++){
                final String line  = lines.get(i);
                String[] values = line.split(",");
                String length = values[1];
                String width = values[2];
                double lengthDouble = Double.valueOf(length);
                double widthDouble = Double.valueOf(width);
                return new Rectangle(lengthDouble, widthDouble);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void save() {
        try(final FileWriter writer = new FileWriter("rectangle.csv")){
            writer.write("Shape: %s, Length: %.3f, Width: %.3f, Area: %.3f, Perimeter: %.3f".formatted("RECTANGLE", this.length, this.width, this.area, this.perimeter));
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
