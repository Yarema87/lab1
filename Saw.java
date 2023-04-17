package main.java.ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class Saw {
    public static final String HEADERS = "brand, power, "
            + "isWorking, workTimeInHours\n";
    private String brand;
    private int power;
    private boolean isWorking = false;
    private double workTimeInHours;
    public abstract double getRemainingWorkTime();
    public boolean getWorking() {
        return isWorking;
    }
    public static String getHeaders() {
        return HEADERS;
    }
    public abstract void writeToFile(List<Saw> saws) throws IOException;
    public abstract String toCSV();
    /*{
        return String.format("%s, %s, %s, %s\n", getBrand(),
                getPower(), getWorking(), getWorkTimeInHours());
    }*/
}
