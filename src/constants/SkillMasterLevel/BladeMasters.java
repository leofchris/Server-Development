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
public enum BladeMasters {
    
   venom(4340001),
   mirroredTarget(4341006),
   monsterBomb(4341003),
   suddenRaid(4341004),
   thorns(4341007);
    
    final int skillID;
    
    private BladeMasters(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
