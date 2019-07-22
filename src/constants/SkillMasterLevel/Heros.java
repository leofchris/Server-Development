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
public enum Heros {
   achilles(1120004),
   monsterMagnet(1121001),
   powerStance(1121002),
   intrepidSlash(1121008),
   enrage(1121010),
   rush(1121006);
   
   final int skillID;
   
   
   private Heros(int skillID){
       this.skillID = skillID;
    
   }
   
   public int getSkillID(){
        return skillID;
    }
    
  
}
