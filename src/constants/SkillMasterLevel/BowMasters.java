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
public enum BowMasters {
    sharpEyes(3121002),
    hurricane(3121004),
    hamString(3121007),
    phoenix(3121006),
    bowExpert(3120005),
    concentrate(3121008),
    dragonBreath(3121003);
    final int skillID;
    private BowMasters(int skillID){
        this.skillID = skillID;
       
    }
  
    public int getSkillID(){
        return skillID;
    }
}
