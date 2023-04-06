package main.java.ua.lviv.iot.algo.part1.lab1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Chainsaw extends Saw {
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
    public Chainsaw(final String brand, final int power,
                    final boolean isWorking, final double workingTimeInHours,
                    final double fuelTankCapacity, final double fuelLevel) {
        super(brand, power, isWorking, workingTimeInHours);
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelLevel = fuelLevel;
    }
}

