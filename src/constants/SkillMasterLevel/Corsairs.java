/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants.SkillMasterLevel;
   
/**
 *
 * @author Chris
 */
public enum Corsairs {
   elementalBoost(5220001),
   wrathOfTheOctopi(5220002),
   airStrike(5221003),
   rapidFire(5221004),
   battleShip(5221006),
   battleShipCannon(5221007),
   battleShipTorpedo(5221008),
   bullseye(5220011),
   hypnotize(5221009);
   
   final int skillID;
   
   
   private Corsairs(int skillID){
       this.skillID = skillID;
      
   }
   
   public int getSkillID(){
        return skillID;
    }
    
    
}
