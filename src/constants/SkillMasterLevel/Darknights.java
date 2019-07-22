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
public enum Darknights {
   achilles(1320005),
   monsterMagnet(1321001),
   auraOfBeholder(1320008),
   hexOfBeholder(1320009),
   beholder(1321007),
   berserk(1320006),
   powerStance(1321002),
   rush(1321003);
   
   final int skillID;
   
   
   private Darknights(int skillID){
       this.skillID = skillID;
    
   }
   
   public int getSkillID(){
        return skillID;
    }
    
   
}
