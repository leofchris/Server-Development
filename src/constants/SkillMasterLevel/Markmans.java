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
public enum Markmans {
    sharpEyes(3221002),
    marksmanBoost(3220004),
    piercingArrow(3221001),
    blind(3221006),
    frostPrey(3221005),
    snipe(3221007),
    dragonBreath(3221003);
    final int skillID;
    private Markmans(int skillID){
        this.skillID = skillID;
      
    }
   
    public int getSkillID(){
        return skillID;
    }
}
