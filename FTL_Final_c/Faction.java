import java.util.*;

public class Faction {
   private String name;
   private int stance;
   private String stanceName;
   
   //Default Civillian Factions
   public Faction() {
      name = "Trade Alliance";
      //50 or greater means they will never attack, -50 or lower means they always attack
      stance = 50;
      calculateStance(); 
   }
   
   //Custom
   public Faction(String name, int stance) {
      this.name = name;
      this.stance = stance;
      calculateStance();
   }
   
   public void changeStance(int s) {
      stance += s;
      calculateStance();
   }
   
   private void calculateStance() {
      if(stance <= -50) {
         stanceName = "hate";
      }
      else if(stance < -20) {
         stanceName = "dislike";
      }
      else if(stance < 20) {
         stanceName = "feel neutral towards";
      }
      else if(stance < 50) {
         stanceName = "like";
      } 
      else {
         stanceName = "love";
      }
   }
   
   public String getName() {
      return name;
   }
   
   public int getStance() {
      return stance;
   }
   
   public String getStanceName() {
      return stanceName;
   }
}