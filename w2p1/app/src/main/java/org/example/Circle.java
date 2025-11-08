package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Circle implements Shape {
    private double radius;
    private double perimeter;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
         this.area = Math.PI * radius * radius;
        System.out.printf("Area of circle: %.3f%n", this.area);
    }

    @Override
    public void calculatePerimeter() {
         this.perimeter = 2 * Math.PI * radius;
        System.out.printf("Perimeter of circle: %.3f%n", this.perimeter);
    }

    @Override
    public Shape read() {
        try {
            final List<String> lines = Files.readAllLines(Path.of("circle.csv"));
            for(int i = 0; i < lines.size(); i++) {
                final String line  = lines.get(i);
                String[] values = line.split(",");
                String radius = values[1];
                double radiusDouble = Double.valueOf(radius);
                return new Circle(radiusDouble);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void save() {
        try(final FileWriter writer = new FileWriter("circle.csv")){
            writer.write("Shape: %s, Radius: %.3f, Area: %.3f, Perimeter: %.3f".formatted("CIRCLE", this.radius, this.area, this.perimeter));
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
