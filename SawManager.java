package ua.lviv.iot.algo.part1.lab1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SawManager {
    private static List<Saws> saws = new LinkedList<>();
    public List<Saws> findAllAutomatic(){
        return saws.stream().filter( saw -> saw.getAutomatic() == true).toList();
    }
    public List<Saws> findAllMoreExpensiveThan(int price){
        return saws.stream().
                filter( saw -> saw.getPrice() > price).
                toList();
    }
    private final List<Saws> sawList = new LinkedList<>();
    private void addSaw(Saws sawToAdd){
        this.sawList.add(sawToAdd);
    };
    public static void main(String ... strings){
        List<Saws> saws = new LinkedList<>();
        SawManager sawManager = new SawManager();
        sawManager.addSaw(new HandSaw());
        sawManager.addSaw(new HandSaw(1.05, 0.7, 1));
        sawManager.addSaw(new Chainsaw());
        sawManager.addSaw(new Chainsaw("Stihl", 750, 2.8, 2.65, false));
        sawManager.addSaw(new ElectricSaw());
        sawManager.addSaw(new ElectricSaw("R2D2", 1000, 87, false));
       for (Saws saw : sawManager.sawList){
           System.out.println(saw);
       }
       System.out.println("Saws more expencive than setted price:");
       var saws1 = sawManager.findAllMoreExpensiveThan(2000);
       for (Saws saw : saws1){
           System.out.println(saw);
       }
           System.out.println("Automatic saws:");
       for (Saws saws2 : sawManager.findAllAutomatic()){
           System.out.println(saws2);
       }
    }
}
