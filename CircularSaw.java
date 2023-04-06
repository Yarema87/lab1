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

public class CircularSaw extends Saw {
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
}
