import java.util.*;

public class StarShip {
   private int hull;
   private int armor;
   private int shields;
   private int power;
   private int maxHull;
   private int maxArmor;
   private int maxShields;
   private int maxPower;
   
   private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
   //private ArrayList<String> subSystemList = new ArrayList<String>();
   private static Random generator = new Random();
   
   //Default Starshp
   public StarShip () {
      //Easy ship
      addWeapon();
      
      hull = 50;
      armor = 25;
      shields = 25;
      power = 5;
      maxHull = hull;
      maxArmor = armor;
      maxShields = shields;
      maxPower = power;
   }
   
   //NPC
   public StarShip (int rank) {
      generate(rank);
   }
   
   public void generate(int rank) {
      hull = (generator.nextInt(21) + 20) * rank;
      armor = (generator.nextInt(10) + 10) * rank;
      shields = (generator.nextInt(10) + 10) * rank;
      power = 5;
      
      maxHull = hull;
      maxArmor = armor;
      maxShields = shields;
      maxPower = power;
   }
   
   //Adds default weapon
   public void addWeapon() {
      Weapon w = new Weapon();
      weaponsList.add(w);
   }
   
   //Overloaded add weapon
   public void addWeapon(int index, int rank) {
      Weapon w = new Weapon(index,rank);
      weaponsList.add(w);
   }
    
   //Adds Random Weapon
   public void addRandomWeapon(int rank) {
      Weapon w = new Weapon(generator.nextInt(9), rank);
      weaponsList.add(w);
   }

   public void removeWeapon(int index) {
      weaponsList.remove(index);
   }
   
   public void addShopWeapon(Weapon w) {
      weaponsList.add(w);
   }
   
   //Damage does tunnel
   public void takeDamage(int damage, String damageType) {
      int temp = 0;
      while(damage > 0 && hull > 0) {
         if(shields > 0){
            if(damageType.equals("En")) {
               temp = damage * 2;
               if(shields > temp){
                  shields -= temp;
                  damage = 0;
               }
               else {
                  temp -= shields;
                  damage -= shields/2;
                  shields = 0;
               }
            }
            else {
               if(shields > damage){
                  shields -= damage;
                  damage = 0;
               }
               else {
                  damage -= shields;
                  shields = 0;
               }
            }
         }
         else if (armor > 0){
            if(damageType.equals("Ki")) {
               temp = damage * 2;
               if(armor > temp){
                  armor -= temp;
                  damage = 0;
               }
               else {
                  temp -= armor;
                  damage -= armor/2;
                  armor = 0;
               }
            }
            else {
               if(armor > damage){
                  armor -= damage;
                  damage = 0;
               }
               else {
                  damage -= armor;
                  armor = 0;
               }
            }
         }
         else {
            if(damageType.equals("Ex")) {
               temp = damage * 2;
               if(hull > temp){
                  hull -= temp;
                  damage = 0;
               }
               else {
                  temp -= hull;
                  damage -= hull/2;
                  hull = 0;
               }
            }
            else {
               if(hull > damage){
                  hull -= damage;
                  damage = 0;
               }
               else {
                  damage -= hull;
                  hull = 0;
               }
            }
         }
      }
   }
   
   public boolean isAlive() {
      if(hull > 0) {
         return true;
      }
      else{
         return false;
      }
   }
   
   public void repairHull (int a) {
      if(hull + a < maxHull) {
         hull += a;
      }
      else {
         hull = maxHull;
      }
   }
   
   public void repairArmor (int a) {
      if(armor + a < maxArmor) {
         armor += a;
      }
      else {
         armor = maxArmor;
      }
   }
   
   public void regenShields () {
      if(shields + (int)((double)maxShields * 0.2) < maxShields) {
         shields += (int)((double)maxShields * 0.2);
      }
      else {
         resetShields();
      }
   }
   
   public void resetShields () {
      shields = maxShields;
   }

   public void changePower(int a){
      if(power + a < maxPower){
         power += a;
      }
      else {
         resetPower();
      }
   }

   public void resetPower(){
      power = maxPower;
   }
   
   public Weapon getWeapon(int index) {
      return weaponsList.get(index);
   }
   
   public int getNumWeapons () {
      return weaponsList.size();
   }

   public double getHullPercent () {
      return (double)hull/maxHull;
   }

   public double getArmorPercent () {
      return (double)armor/maxArmor;
   }
   
   public double getShieldsPercent() {
      return (double)shields/maxShields;
   }
   
   public int getHull() {
      return hull;
   }
   
   public int getArmor() {
      return armor;
   }
   
   public int getShields() {
      return shields;
   }
   
   public int getMaxHull() {
      return maxHull;
   }
   
   public int getMaxArmor() {
      return maxArmor;
   }
   
   public int getMaxShields() {
      return maxShields;
   }

   public int getPower() {
      return power;
   }

   public int getMaxPower(){
      return maxPower;
   }
   
   //Player ship methods
   public void improveHull(int a){
      hull += a;
      maxHull += a;
   }
   
   public void improveArmor(int a){
      armor += a;
      maxArmor += a;
   }
   
   public void improveShields(int a){
      shields += a;
      maxShields += a;
   }

   public void improvePower(int a){
      power += a;
      maxPower += a;
   }
}