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

public class ElectricSaw extends Saw {
    public static final String HEADERS = "batteryCharge, ";
    private int batteryCharge;
    public double charge(final int charge) {
        this.batteryCharge = batteryCharge + charge;
        return this.batteryCharge;
    }
    public boolean start() {
        setWorking(true);
        return getWorking();
    }
    public boolean stop() {
        setWorking(false);
        return getWorking();
    }
    public String convertToString() {
        ElectricSaw electricSaw = new ElectricSaw();
        return electricSaw + "";
    }
    @Override
    public double getRemainingWorkTime() {
        double dischargeBatteryPerMinute = 1.5;
        int minutesInHour = 60;
        return batteryCharge * dischargeBatteryPerMinute / minutesInHour;
    }
    public ElectricSaw(final String brand, final int power,
                       final boolean isWorking, final double workingTimeInHours,
                       final int batteryCharge) {
        super(brand, power, isWorking, workingTimeInHours);
        this.batteryCharge = batteryCharge;
    }
   @Override
    public void writeToFile(List<Saw> saws) {
        try {
            File file = new File("result.csv");
            FileWriter writer = new FileWriter(file);
            writer.write(ElectricSaw.getHeaders());
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
        return String.format("%s, %s, %s, %s, %s\n", getBatteryCharge(), getBrand(),
                getPower(), getWorking(), getWorkTimeInHours());
    }
}
