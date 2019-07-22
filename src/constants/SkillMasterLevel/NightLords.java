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
public enum NightLords {
    shadowShifter(4120002),
    taunt(4121003),
    ninjaAmbush(4121004),
    venomousStar(4120005),
    shadowStars(4121006),
    ninjaStorm(4121008);
    
    final int skillID;
    
    private NightLords(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
