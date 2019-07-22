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
public enum FP_Archmages {
    bigBang(2121001),
    manaReflection(2121002),
    infinity(2121004),
    ifrit(2121005),
    fireDemon(2121003),
    paralyze(2121006),
    meteorShower(2121007);
    final int skillID;
    private FP_Archmages(int skillID){
        this.skillID = skillID;
        
    }
  
    public int getSkillID(){
        return skillID;
    }
}
