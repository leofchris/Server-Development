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
public enum WildHunters {
    
    crossbowExpert(33120000),
    explodingArrows(33121001),
    felineBerserk(33121006),
    sharpEyes(33121004),
    sonicRoar(33121002),
    stinkBombShot(33121005),
    wildArrowBlast(33121009);
    
    final int skillID;
    
    private WildHunters(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
