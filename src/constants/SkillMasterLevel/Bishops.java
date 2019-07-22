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
public enum Bishops {
    bigBang(2321001),
    manaReflection(2321002),
    infinity(2321004),
    bahamut(2321003),
    resurrection(2321006),
    genesis(2321008),
    holyShield(2321005);
    final int skillID;
    private Bishops(int skillID){
        this.skillID = skillID;
       
    }
   
    public int getSkillID(){
        return skillID;
    }
}
