package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class HandSaw extends Saws{
    private double lengthOfChain;
    private double sharpness;
    private int numberOfWorkers;
    private final boolean isAutomatic = false;
    private final int price = 800;
    public double sharp() {
        if (sharpness <= 0.85) {
            this.sharpness = sharpness + 0.15;
        }
        else{
            this.sharpness = 1;
        }
        return this.sharpness;
    }
    @Override
    public boolean cutWood(double length){
        return true;
    }
}
