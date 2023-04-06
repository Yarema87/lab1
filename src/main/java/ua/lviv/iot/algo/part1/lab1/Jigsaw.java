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

public class Jigsaw extends Saw {
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
}
