import java.util.*;

public class Player {
   private int credits;
   private int totalCredits;
   private int xp;
   private int totalXP;
   private int hullLevel;
   private int armorLevel;
   private int shieldsLevel;
   private int driveLevel;
   private int powerLevel;
   private int score;
   private static Random generator = new Random();
   
   public Player() {
      credits = 200;
      totalCredits = 200;
      xp = 0;
      totalXP = 0;
      hullLevel = 0;
      armorLevel = 0;
      shieldsLevel = 0;
      driveLevel = 0;
      powerLevel = 0;
      score = 0;
   }

   //NPC
   public Player(int rank) {
      generate(rank);
      
      
   } 
   
   public void generate(int rank) {
      credits = (generator.nextInt(15)+1) * 20 * rank;
      xp = (generator.nextInt(10)+1) * rank;
      driveLevel = generator.nextInt(rank);
      if(driveLevel > 5){
         driveLevel = 5;
      }
      
      powerLevel = generator.nextInt(3) + rank;
      if(powerLevel > 10){
         powerLevel = 10;
      }
   }
   
   public int getHullCost() {
      return (hullLevel + 1) * 5;
   }
   
   public int getArmorCost() {
      return (int)((double)(armorLevel + 1) * 5.5);
   }
   
   public int getShieldsCost() {
      return (shieldsLevel + 1) * 6;
   }
   
   public int getDriveCost() {
      return (driveLevel + 1) * 10;
   }
   
   public int getPowerCost() {
      return (int)((double)(powerLevel + 1) * 6.5);
   }
   
   //Will upgrade and return that it upgraded if player has enough XP
   public void upgradeHull() {
      int cost = (hullLevel + 1) * 5;
      if(cost <= xp) {
         xp -= cost;
         hullLevel++;
         //return true;
      }
      else {
         //return false;
      }
   }
   
   //Will upgrade if player has enough XP
   public void upgradeArmor() {
      int cost = (int)((double)(armorLevel + 1) * 5.5);
      if(cost <= xp) {
         xp -= cost;
         armorLevel++;
         //return true;
      }
      else {
         //return false;
      }
   }
   
   //Will upgrade if player has enough XP
   public void upgradeShields() {
      int cost = (shieldsLevel + 1) * 6;
      if(cost <= xp) {
         xp -= cost;
         shieldsLevel++;
         //return true;
      }
      else {
         //return false;
      }
   }

   //Will upgrade if player has enough XP
   public void upgradeDrive() {
      int cost = (driveLevel + 1) * 10;
      if(cost <= xp) {
         xp -= cost;
         driveLevel++;
         //return true;
      }
      else {
         //return false;
      }
   }
   
   public void upgradePower() {
      int cost = (int)((double)(powerLevel + 1) * 6.5);
      if (cost <= xp) {
         xp -= cost;
         powerLevel++;
      }
   }
   
   public void increaseXP(int a) {
      xp += a;
      if(a > 0) {
         totalXP += a;
      }
   }
   
   public void changeCredits(int a) {
      credits += a;
      if(a > 0) {
         totalCredits += a;
      }
   }
   
   public void addScore(int a) {
      score += a;
   }

   public int getCredits() {
      return credits;
   }
   
   public int getTotalCredits() {
      return totalCredits;
   }

   public int getXP() {
      return xp;
   }
   
   public int getTotalXP() {
      return totalXP;
   }

   public int getScore() {
      return score;
   }

   public int getHullLevel() {
      return hullLevel;
   }

   public int getArmorLevel(){
      return armorLevel;
   }

   public int getShieldsLevel() {
      return shieldsLevel;
   }

   public int getDriveLevel() {
      return driveLevel;
   }
   
   public int getPowerLevel() {
      return powerLevel;
   }
   
}