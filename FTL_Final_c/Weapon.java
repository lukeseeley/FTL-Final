import java.util.*;

public class Weapon {
   private String name;
   private String rank;
   private int attacks;
   private int damage;
   private int accuracy;
   private String damageType;
   private int speed;
   private int value;
   private int power;
   private String desc;
   
   private int[][] weaponStatsList = {
      //[attacks, damage, accuracy, speed, value, power usage]
      {3,5,45,0,150,1},
      {2,9,55,0,225,2},
      {1,16,65,0,285,3},
      {4,3,69,0,235,1},
      {1,7,74,0,300,2},
      {1,13,70,1,345,3},
      {3,8,59,1,275,1},
      {2,14,57,2,335,2},
      {1,18,55,3,380,3},

      {3,7,53,0,650,2},
      {2,12,63,0,840,3},
      {1,19,73,0,1000,4},
      {4,6,77,0,825,2},
      {1,11,82,0,1000,3},
      {1,16,78,1,1060,4},
      {3,13,65,1,850,2},
      {2,18,63,2,1035,3},
      {1,24,61,3,1200,4},

      {3,12,58,0,1460,3},
      {2,17,68,0,1650,4},
      {1,24,78,0,1800,5},
      {4,8,82,0,1655,3},
      {1,16,87,0,1815,4},
      {1,20,83,1,1885,5},
      {3,17,69,1,1680,3},
      {2,22,67,2,1860,4},
      {1,29,65,3,2040,5}
      
   };
   
   private String[][] weaponNamesList = {
      //[name, rank, damageType, desc]
      {"Machine Gun", "MK1", "Ki", "Fires burst of metal slugs."},
      {"Rail Gun", "MK1", "Ki", "Fires metal slugs accelrated with magnetic fields."},
      {"Mass Driver", "MK1", "Ki", "Uses extreamly powerful magnetic fields to propell metal slugs at incredible velocities."},
      {"Pulse Laser", "MK1", "En", "Fires a continous energy stream."},
      {"Phaser", "MK1", "En", "Fires a charged energy burst."},
      {"Plasma Cannon", "MK1", "En", "Fires superheated gas projectiles."},
      {"Rocket Launcher", "MK1", "Ex", "Launches a barrage of light warheads"},
      {"Missile Launcher", "MK1", "Ex", "Launches medium warheads"},
      {"Torpedo Launcher", "MK1", "Ex", "Launches a heavy warhead"},
      
      {"Machine Gun", "MK2", "Ki", "Fires burst of metal slugs."},
      {"Rail Gun", "MK2", "Ki", "Fires metal slugs accelrated with magnetic fields."},
      {"Mass Driver", "MK2", "Ki", "Uses more powerful magnetic fields to propell metal slugs at incredible velocities."},
      {"Pulse Laser", "MK2", "En", "Fires a continous energy stream."},
      {"Phaser", "MK2", "En", "Fires a charged energy burst."},
      {"Plasma Cannon", "MK2", "En", "Fires superheated gas projectiles."},
      {"Rocket Launcher", "MK2", "Ex", "Launches a barrage of light warheads"},
      {"Missile Launcher", "MK2", "Ex", "Launches medium warheads"},
      {"Torpedo Launcher", "MK2", "Ex", "Launches a heavy warhead"},

      {"Machine Gun", "MK3", "Ki", "Fires burst of metal slugs."},
      {"Rail Gun", "MK3", "Ki", "Fires metal slugs accelrated with magnetic fields."},
      {"Mass Driver", "MK3", "Ki", "Uses more powerful magnetic fields to propell metal slugs at incredible velocities."},
      {"Pulse Laser", "MK3", "En", "Fires a continous energy stream."},
      {"Phaser", "MK3", "En", "Fires a charged energy burst."},
      {"Plasma Cannon", "MK3", "En", "Fires superheated gas projectiles."},
      {"Rocket Launcher", "MK3", "Ex", "Launches a barrage of light warheads"},
      {"Missile Launcher", "MK3", "Ex", "Launches medium warheads"},
      {"Torpedo Launcher", "MK3", "Ex", "Launches a heavy warhead"}
   
   };

   
   private static Random generator = new Random();
   
   //Default Weapon
   public Weapon() {
      selectWeapon(0,0);
   }
   
   //Overloaded Weapon
   public Weapon(int index, int rank) {
      selectWeapon(index,rank);
   }

   public void selectWeapon (int index, int rank) {
      //Calculates index, offsets for rank
      int i = index + 9*rank;
      
      name = weaponNamesList[i][0];
      this.rank = weaponNamesList[i][1];
      damageType = weaponNamesList[i][2];
      desc = weaponNamesList[i][3];
      
      attacks = weaponStatsList[i][0];
      damage = weaponStatsList[i][1];
      accuracy = weaponStatsList[i][2];
      speed = weaponStatsList[i][3];
      value = weaponStatsList[i][4];
      power = weaponStatsList[i][5];
   }
   
   //No modifiers to attack
   public String makeAttack() {
      int attack = generator.nextInt(100);
      
      //A crit hit
      if(attack <= (int)((double)accuracy * 0.2)) {
         return "C";
      }
      //A weak hit
      else if(attack <= (int)((double)accuracy * 0.9)) {
         return "W";
      }
      //A normal hit
      else if(attack <= accuracy) {
         return "H";
      }
      //A miss
      else {
         return "M";
      }
   }
   
   //Modified Attack
   public String makeAttack(int attMod) {
      int attack = generator.nextInt(100) - attMod;
      
      //A crit hit
      if(attack <= accuracy * 0.1) {
         return "C";
      }
      //A weak hit
      else if(attack <= accuracy * 0.9) {
         return "P";
      }
      //A normal hit
      else if(attack <= accuracy) {
         return "H";
      }
      //A miss
      else {
         return "M";
      }
   }
   
   
   public int getDamage () {
      return damage;
   }
   
   public int getAttacks() {
      return attacks;
   }
   
   public int getAccuracy () {
      return accuracy;
   }
   
   public String getName() {
      return name;
   }
   
   public String getRank() {
      return rank;
   }

   public String getDamageType() {
      return damageType;
   }

   public int getSpeed(){
      return speed;
   }
   
   public int getValue() {
      return value;
   }

   public String getDesc() {
      return desc;
   }

   public void subSpeed() {
      speed--;
   }
   
   public int getPower() {
      return power;
   }

   public String toString() {
      return "<HTML>" + name + " " + rank + "</HTML>";
   }

   public String fullToString() {
      String output = "<HTML>";
      output += "<H2>" + name + " " + rank + "</H2><br>";
      output += "<TABLE width='200px'>";
      output += "<TR><TD>Damage:</TD><TD>" + damage + "</TD><TD>Attacks:</TD><TD>" + attacks + "</TD></TR>";
      output += "<TR><TD>Accuracy:</TD><TD>" + accuracy + "</TD><TD>Damage Type:</TD><TD>" + damageType + "</TD></TR>";
      output += "<TR><TD>Speed:</TD><TD>" + speed + "</TD><TD>Value:</TD><TD>" + value + "</TD></TR>"; 
      output += "<TR><TD>Power:</TD<TD>" + power +"</TD></TR>";
      output += "</TABLE>";
      output += "<P>" + desc + "</P>";

      output += "</HTML>";
      return output;
   }
   
   
}