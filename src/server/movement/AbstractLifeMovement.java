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

public abstract class AbstractLifeMovement implements LifeMovement {

    private Point position, velocity;
    private byte moveAction, type;
    private short fh, fhFallStart, xOffset, yOffset, elapse,currentVX, currentVY, currentX, currentY;

    public AbstractLifeMovement(byte type, Point position, Point velocity, short fh,  short fhFallStart, short xOffset, short yOffset, byte moveAction, short elapse,short currentVX, short currentVY, short currentX, short currentY) {
       
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
    }
    
   
    
    @Override
    public short getElapse() {
        return elapse;
    }
    
    @Override
    public Point getPosition() {
   return position;
    }
   
    @Override
     public byte getMoveAction() {
        return moveAction;
    }

    @Override
    public short getFh() {
        return fh;
    }

    @Override
    public short getFhFallStart() {
        return fhFallStart;
    }

    @Override
    public short getxOffset() {
        return xOffset;
    }

    @Override
    public short getyOffset() {
        return yOffset;
    }

    @Override
    public Point getVelocity() {
        return velocity;
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
