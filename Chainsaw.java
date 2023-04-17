package main.java.ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Chainsaw extends Saw {
    public static final String HEADERS = "fuelTankCapacity, fuelLevel, ";
    private double fuelTankCapacity;
    private double fuelLevel;
    public boolean start() {
        setWorking(true);
        return getWorking();
    }
    public boolean stop() {
        setWorking(false);
        return getWorking();
    }
    public double charge(final double fuel) {
        this.fuelLevel = fuelLevel + fuel;
        return this.fuelLevel;
    }
    public String convertToString() {
        Chainsaw chainsaw = new Chainsaw();
        return chainsaw + "";
    }
    @Override
    public double getRemainingWorkTime() {
        double consumptionFuelPerHour = 0.6;
        return fuelLevel / consumptionFuelPerHour;
    }
    public static String getHeaders() {
        return HEADERS;
    }
    @Override
    public void writeToFile(List<Saw> saws) {
        try {
            File file = new File("result.csv");
            FileWriter writer = new FileWriter(file);
            writer.write(Chainsaw.getHeaders());
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
    //maybe I should make toCSV abstract and override it
    //it works
    //now I should combine all class writers into one
    @Override
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %s, %s\n", getFuelTankCapacity(),
                getFuelLevel(), getBrand(),
                getPower(), getWorking(), getWorkTimeInHours());
    }
    public Chainsaw(final String brand, final int power,
                    final boolean isWorking, final double workingTimeInHours,
                    final double fuelTankCapacity, final double fuelLevel) {
        super(brand, power, isWorking, workingTimeInHours);
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelLevel = fuelLevel;
    }
}
