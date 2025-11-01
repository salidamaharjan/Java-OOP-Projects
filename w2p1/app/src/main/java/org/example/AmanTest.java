package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AmanTest {
    public static void main(String[] args) {
        final AmanShape circle = new AmanCircle(0D).read();
        System.out.println(circle.draw());
    }
}

interface AmanShape {
    // area & perimeter
    void save();
    AmanShape read();
}

class AmanCircle  implements  AmanShape {
    private Double radius;

    public AmanCircle(Double radius) {
        this.radius = radius;
    }

    @Override
    public AmanShape read() {

        try {
            final List<String> lines = Files.readAllLines(Path.of("circle.csv"));
            for (int i = 0; i < lines.size(); i++) {
               final String line = lines.get(i) ;
               String[] values = line.split(",");
               String radius = values[1];
               Double radiusDouble = Double.valueOf(radius);
               return new AmanCircle(radiusDouble);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void save() {
        try ( final FileWriter writer = new FileWriter("circle.csv")){
            writer.write("%s,%f".formatted("CIRCLE", this.radius));
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
