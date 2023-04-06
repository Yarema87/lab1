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

public class ElectricSaw extends Saw {
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
}
