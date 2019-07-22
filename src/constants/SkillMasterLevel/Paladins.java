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
public enum Paladins {
   achilles(1220005),
   powerStance(1221002),
   divineCharge(122100),
   guardian(122006),
   rush(1221007),
   blast(1221009),
   heavensHammer(1221001);

   final int skillID;
   
   
   private Paladins(int skillID){
       this.skillID = skillID;
       
   }
   
   public int getSkillID(){
        return skillID;
    }
    
    
}
