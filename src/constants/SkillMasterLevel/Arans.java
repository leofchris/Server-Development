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
public enum Arans {
   overSwing(21120002),
   highMastery(21120001),
   freezeStanding(21121003);
   
   final int skillID;
   
   
   private Arans(int skillID){
       this.skillID = skillID;
       
   }
   
   public int getSkillID(){
        return skillID;
    }
    
   
}
