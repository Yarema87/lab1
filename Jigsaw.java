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

public class Jigsaw extends Saw {
    public static final String HEADERS = "widthOfCanvas, lengthOfCanvas, ";
    private double widthOfCanvas;
    private double lengthOfCanvas;
    public boolean start() {
        setWorking(true);
        return getWorking();
    }
    public boolean stop() {
        setWorking(false);
        return getWorking();
    }
    public String convertToString() {
        Jigsaw jigsaw = new Jigsaw();
        return jigsaw + "";
    }
    @Override
    public double getRemainingWorkTime() {
        int timeWithElectricityOn = 8;
        return timeWithElectricityOn;
    }
    public Jigsaw(final String brand, final int power, final boolean isWorking,
                  final double workingTimeInHours, final double widthOfCanvas,
                  final double lengthOfCanvas) {
        super(brand, power, isWorking, workingTimeInHours);
        this.widthOfCanvas = widthOfCanvas;
        this.lengthOfCanvas = lengthOfCanvas;
    }
    @Override
    public void writeToFile(List<Saw> saws) {
        try {
            File file = new File("result.csv");
            FileWriter writer = new FileWriter(file);
            writer.write(Jigsaw.getHeaders());
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
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %s, %s\n", getLengthOfCanvas(),
                getWidthOfCanvas(), getBrand(),
                getPower(), getWorking(), getWorkTimeInHours());
    }
}
