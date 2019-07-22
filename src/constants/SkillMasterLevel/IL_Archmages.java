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
public enum IL_Archmages {
    bigBang(2221001),
    manaReflection(2221002),
    infinity(2221004),
    elquines(2221005),
    iceDemon(2221003),
    chainLightning(2221006),
    blizzard(2221007);
    final int skillID;
    private IL_Archmages(int skillID){
        this.skillID = skillID;
        
    }
 
    public int getSkillID(){
        return skillID;
    }
}
