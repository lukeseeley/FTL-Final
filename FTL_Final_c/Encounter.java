import java.util.*;

public class Encounter {
   private static Random generator = new Random();
   private String[] stateList = {"Deralict", "Abandoned", "Bustling", "Damaged", "Inactive", "Shody", "Unstable", "Ancient"};
   private String[] typeList = {"Station", "Ship", "Astroid Belt", "Alien Ship", "Alien Station", "Mining Base", "Research Base", "Military Base"};
   private String name;
   private int endState; //violent explosion, minor explosion, minor cache, minor cache with weapon, major cache, major cache with weapon
   private int damage;
   private int rewardCredits;
   private int rewardXP;
   private int rewardScore;
   private boolean rewardWeaponSwitch;
   private Weapon rewardWeapon = new Weapon();
   
   public Encounter(int risk) {
      generate(risk);
   }   
   
   public void generate(int risk) {
      name = stateList[generator.nextInt(stateList.length)] + " " + typeList[generator.nextInt(typeList.length)];
      int roll = generator.nextInt(100);
      //Violent Explosion 5%
      if(roll < 5) {
         damage = (generator.nextInt(20) + 10) * risk;
         rewardCredits = 0;
         rewardXP = generator.nextInt(5) * risk;
         rewardScore = 10 * risk;
         rewardWeaponSwitch = false;
         endState = 0;
      }
      //Minor Explosion 30%
      else if(roll < 35) {
         damage = (generator.nextInt(10) + 5) * risk;
         rewardCredits = ((generator.nextInt(10)+1) * 20) * risk;
         rewardXP = (generator.nextInt(5)) * risk;
         rewardScore = 30 * risk;
         rewardWeaponSwitch = false;
         endState = 1;
      }
      //Minor Cache 35%
      else if(roll < 70) {
         damage = 0;
         rewardCredits = ((generator.nextInt(10)+1) * 30) * risk;
         rewardXP = (generator.nextInt(5) + 1) * risk;
         rewardScore = 50 * risk;
         rewardWeaponSwitch = false;
         endState = 2; 
      }
      //Minor Cache with weapon 15%
      else if(roll < 85) {
         damage = 0;
         rewardCredits = ((generator.nextInt(10)+1) * 30) * risk;
         rewardXP = (generator.nextInt(5) + 1) * risk;
         rewardScore = 70 * risk;
         rewardWeaponSwitch = true;
         rewardWeapon = new Weapon(generator.nextInt(9),generator.nextInt(risk)); 
         endState = 3;
      }
      //Major Cache 10%
      else if(roll < 95) {
         damage = 0;
         rewardCredits = ((generator.nextInt(10)+1) * 50) * risk;
         rewardXP = (generator.nextInt(5) + 5) * risk;
         rewardScore = 90 * risk;
         rewardWeaponSwitch = false;
         endState = 4; 
      }
      //Major Cache with weapon 5%
      else {
         damage = 0;
         rewardCredits = ((generator.nextInt(10)+1) * 50) * risk;
         rewardXP = (generator.nextInt(5) + 5) * risk;
         rewardScore = 120 * risk;
         rewardWeaponSwitch = true;
         rewardWeapon = new Weapon(generator.nextInt(9),generator.nextInt(risk)); 
         endState = 5;
      }
   }
   
   public String getName() {
      return name;
   }
   
   public String getEndResult() {
      if(endState == 0) {
         return "<HTML>As you explore, you cause a catastrophic explosion. The insuing blast heavily damages your ship, and there is nothing left to salvage.</HTML>";
      }
      else if(endState == 1) {
         return "<HTML>As you explore, you cause an explosion to insue. While the blast damages your ship, you are able to salvage what little remains of the wreck. "+ 
         "You will be able to sell what you recoverd for a small sum of credits.</HTML>";
      }
      else if(endState == 2) {
         return "<HTML>As you explore you uncover a small cache of goodies. You will be able to sell what you have found for a decent sum of credits.</HTML>";
      }
      else if(endState == 3) {
         return "<HTML>As you explore you uncover a small cache of goodies and a weapon. You will be able to sell what you have found for a decent sum of credits. " +
         "You may also choose to keep the weapon, if you do not already have 5.</HTML>";
      }
      else if(endState == 4) {
         return "<HTML>As you explore you uncover a large cache of valuble goods. You will be able to sell what you have found for a heafty sum of credits.</HTML>";
      }
      else {
         return "<HTML>As you explore you uncover a large cache of valuble goods and a weapon. You will be abel to sell what you have found for a heafty sum of credits. "+
         "You may also choose to keep the weapon, if you do not already have 5.</HTML>";
      }
   }
   public String getEndReward() {
      String output = "<HTML><H4>";
      if(damage > 0) {
         output += "Damge Taken: " + damage + "<br>";
      }
      if(rewardCredits > 0) {
         output += "Credits Found: " + rewardCredits + "<br>";
      }
      if(rewardXP > 0) {
         output += "XP earned: " + rewardXP + "<br>";
      }
      if(rewardWeaponSwitch == true) {
         output += "Weapon found:<br>" + rewardWeapon.toString();
      }
      output += "</H4></HTML>";
      return output;
   }
   
   public int getDamage() {
      return damage;
   }
   
   public int getRewardCredits() {
      return rewardCredits;
   } 
   
   public int getRewardXP() {
      return rewardXP;
   }
   
   public int getRewardScore() {
      return rewardScore;
   }
   
   public boolean haveWeapon() {
      return rewardWeaponSwitch;
   }
   
   public Weapon getRewardWeapon() {
      return rewardWeapon;
   }
}