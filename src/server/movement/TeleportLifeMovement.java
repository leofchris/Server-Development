/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.movement;

import java.awt.Point;
import tools.data.output.LittleEndianWriter;

/**
 *
 * @author Chris
 */
public class TeleportLifeMovement implements LifeMovementFragment{
    
    private Point position;
    private byte moveAction, type;
    private short elapse, fh;
    
    public TeleportLifeMovement(byte type, Point position, short fh, byte moveAction, short elapse) {
        this.position = position;
        this.type = type;
        this.moveAction = moveAction;
        this.elapse = elapse;
        this.fh = fh;
    }
    
    @Override
    public void serialize(LittleEndianWriter lew) {
        lew.write(getType());
        lew.writeShort(getPosition().x);
        lew.writeShort(getPosition().y);
        lew.writeShort(getFh());
        lew.write(getMoveAction());
        lew.writeShort(getElapse());
     }

    public Point getPosition() {
        return position;
    }

    public byte getMoveAction() {
        return moveAction;
    }

    @Override
    public byte getType() {
        return type;
    }

    public short getElapse() {
        return elapse;
    }

    public short getFh() {
        return fh;
    }
}
