package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Triangle implements Shape {
    double base;
    double height;
    double a;
    double c;
    double area;
    double perimeter;

    public Triangle(double base, double height, double a, double c) {
        this.base = base;
        this.height = height;
        this.a = a;
        this.c = c;
    }

    @Override
    public void calculateArea() {
        this.area = (base * height) / 2;
        System.out.printf("Area of Triangle: %.2f%n", this.area);
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = a + base + c;
        System.out.printf("Perimeter of Triangle: %.2f%n", this.perimeter);
    }

    @Override
    public void save() {
        try (final FileWriter writer = new FileWriter("triangle.csv")) {
            writer.write("Shape: %s, Base: %.3f, Height: %.3f, a: %.3f, c: %.3f, Area: %.3f, Perimeter: %.3f".formatted("TRIANGLE", this.base, this.height, this.a, this.c, this.area, this.perimeter));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Shape read() {
        try {
            final List<String> lines = Files.readAllLines(Path.of("triangle.csv"));
            for(int i = 0; i < lines.size(); i++) {
                final String line  = lines.get(i);
                String[] values = line.split(",");
                String base = values[1];
                String height = values[2];
                String a  = values[3];
                String c = values[4];
                double baseDouble = Double.valueOf(base);
                double heightDouble = Double.valueOf(height);
                double aDouble = Double.valueOf(a);
                double cDouble = Double.valueOf(c);
                return new Triangle(baseDouble, heightDouble, aDouble, cDouble);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
