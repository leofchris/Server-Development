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
public enum Shadowers {
    taunt(4221003),
    shadowShifter(4220002),
    ninjaAmbush(4221004),
    boomerangStep(4221007),
    smokeScreen(4221006),
    venomousStab(4220005),
    assassinate(4221001);
    
    final int skillID;
    
    private Shadowers(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
