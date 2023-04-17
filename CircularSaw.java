package main.java.ua.lviv.iot.algo.part1.lab1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class CircularSaw extends Saw {
    public static final String HEADERS = "radius, width, ";
    private double radius;
    private double width;
    public boolean start() {
        setWorking(true);
        return getWorking();
    }
    public boolean stop() {
        setWorking(false);
        return getWorking();
    }
    public String convertToString() {
        CircularSaw circularsaw = new CircularSaw();
        return circularsaw + "";
    }
    @Override
    public double getRemainingWorkTime() {
        int timeWithElectricityOn = 8;
        return timeWithElectricityOn;
    }
    public CircularSaw(final String brand, final int power,
                       final boolean isWorking, final double workingTimeInHours,
                       final double radius, final double width) {
        super(brand, power, isWorking, workingTimeInHours);
        this.radius = radius;
        this.width = width;
    }
    @Override
    public void writeToFile(List<Saw> saws) {
        try {
            File file = new File("result.csv");
            FileWriter writer = new FileWriter(file);
            writer.write(CircularSaw.getHeaders());
            writer.write(Saw.getHeaders());
            for (Saw saws2: saws) {
                writer.write(saws2.toCSV());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getHeaders() {
        return HEADERS;
    }
    @Override
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %s, %s\n", getRadius(),
                getWidth(), getBrand(),
                getPower(), getWorking(), getWorkTimeInHours());
    }
}
