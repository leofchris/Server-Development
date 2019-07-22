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
public enum BattleMages {
    
   advancedDarkAura(32120000),
   advancedYellowAura(32120001),
   darkGenesis(32121004),
   finishingBlow(32121002),
   partyShield(32121006),
   stance(32121005),
   twisterSpin(32121003);
    
    final int skillID;
    
    private BattleMages(int skillID){
        this.skillID = skillID;
    }
    
    public int getSkillID(){
        return skillID;
    }
}
