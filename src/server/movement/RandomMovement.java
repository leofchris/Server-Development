/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.movement;

import tools.data.output.LittleEndianWriter;

/**
 *
 * @author Chris
 */
public class RandomMovement implements LifeMovementFragment{
    byte type, moveAction;
    short elapse;
    public RandomMovement(byte type, byte moveAction, short elapse){
        this.type = type;
        this.moveAction = moveAction;
        this.elapse = elapse;
    }
    
    @Override
    public void serialize(LittleEndianWriter lew) {
       lew.write(getType());
       lew.write(getMoveAction());
       lew.writeShort(getElapse());
    }
    @Override
    public byte getType() {
        return type;
    }

    public byte getMoveAction() {
        return moveAction;
    }

    public short getElapse() {
        return elapse;
    }
    
    
    
}
