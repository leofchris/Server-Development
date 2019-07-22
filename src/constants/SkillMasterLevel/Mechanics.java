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
public enum Mechanics {
    
    amplifierRobot(35121010),
    botsTots(35121009),
    extremeMech(35120000),
    giantRobot(35121003),
    laserBlast(35121012),
    missileTank(35121005),
    robotMastery(35120001),
    satelliteSafety(35121006);
    
    final int skillID;
    
    private Mechanics(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
