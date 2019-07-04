/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package server.movement;

import java.awt.Point;
import tools.data.output.LittleEndianWriter;

public class AbsoluteLifeMovement implements LifeMovementFragment{
    int lock;
    private Point position, velocity;
    private byte moveAction, type;
    private short fh, fhFallStart, xOffset, yOffset, elapse,currentVX, currentVY, currentX, currentY;
    
    public AbsoluteLifeMovement(byte type, Point position, Point velocity, short fh, short fhFallStart, short xOffset, short yOffset, byte moveAction, short elapse, short currentVX, short currentVY, short currentX, short currentY, int lock) {
        this.type = type;
        this.position = position;
        this.velocity = velocity;
        this.fh = fh;
        this.fhFallStart = fhFallStart;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.moveAction = moveAction;
        this.elapse = elapse;
        this.currentVX = currentVX;
        this.currentVY = currentVY;
        this.currentX = currentX;
        this.currentY = currentY;
        this.lock = lock;
    }
    @Override
    public void serialize(LittleEndianWriter lew) {
     lew.write(getType());
     lew.writeShort(getPosition().x);
     lew.writeShort(getPosition().y);
     lew.writeShort(getVelocity().x);
     lew.writeShort(getVelocity().y);
     lew.writeShort(getFh());
     if(lock == 1){
         lew.writeShort(getFhFallStart());
     }
     lew.writeShort(getxOffset());
     lew.writeShort(getyOffset()) ;
     lew.write(getMoveAction());
     lew.writeShort(getElapse());
     }

    
    public Point getPosition() {
        return position;
    }

   
    public Point getVelocity() {
        return velocity;
    }

   
    public byte getMoveAction() {
        return moveAction;
    }

    @Override
    public byte getType() {
        return type;
    }

  
    public short getFh() {
        return fh;
    }

  
    public short getFhFallStart() {
        return fhFallStart;
    }

  
    public short getxOffset() {
        return xOffset;
    }

   
    public short getyOffset() {
        return yOffset;
    }

    
    public short getElapse() {
        return elapse;
    }

    
    public short getCurrentVX() {
        return currentVX;
    }

    
    public short getCurrentVY() {
        return currentVY;
    }

   
    public short getCurrentX() {
        return currentX;
    }

    
    public short getCurrentY() {
        return currentY;
    }
    
}
