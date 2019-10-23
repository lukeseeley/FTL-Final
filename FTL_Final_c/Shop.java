import java.util.*;

public class Shop {
    private ArrayList<Weapon> weaponInventory = new ArrayList<Weapon>();
    private int hullRepairCost;
    private int armorRepairCost;
    private static Random generator = new Random();

    public Shop (int risk) {
        for(int i = 0; i < 3; i++) {
            Weapon w = new Weapon(generator.nextInt(9),generator.nextInt(risk));
            weaponInventory.add(w);
        }
        calculateHull(risk);
        calculateArmor(risk);
    }

    private void calculateHull (int risk){
        hullRepairCost = (int)(10 * Math.pow(risk, 2));
    }

    private void calculateArmor (int risk){
        armorRepairCost = (int)(20 * Math.pow(risk, 2));
    }

    public int getHullCost() {
        return hullRepairCost;
    }

    public int getArmorCost() {
        return armorRepairCost;
    }

    public Weapon getWeapon(int index) {
        return weaponInventory.get(index);
    }
}