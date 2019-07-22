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
public enum Buccaneers {
    dragonStrike(5121001),
    EnergyOrb(5121002),
    SuperTransformation(5121003),
    Demolition(5121004),
    snatch(5121005),
    barrage(5121007),
    speedInfusion(5121009),
    timeLeap(5121010);
    
    final int skillID;
    private Buccaneers(int skillID){
        this.skillID = skillID;
       
    }
    
    public int getSkillID(){
        return skillID;
    }
    
    
}