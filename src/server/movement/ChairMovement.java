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

public class ChairMovement implements LifeMovementFragment {
   
    private Point position, velocity;
    private byte moveAction, type;
    private short elapse;
    
    public ChairMovement(byte type, Point position, Point velocity, byte moveAction, short elapse) {
       this.type = type;
       this.position = position;
       this.velocity = velocity;
       this.moveAction = moveAction;
       this.elapse = elapse;
    }

    @Override
    public void serialize(LittleEndianWriter lew) {
       lew.write(getType());
       lew.writeShort(getPosition().x);
       lew.writeShort(getPosition().y);
       lew.writeShort(getVelocity().x);
       lew.writeShort(getVelocity().y);
       lew.write(getMoveAction());
       lew.writeShort(getElapse());
    }
    @Override
    public byte getType() {
        return type;
    }

    public Point getVelocity() {
        return velocity;
    }

    public byte getMoveAction() {
        return moveAction;
    }

    public Point getPosition() {
        return position;
    }

    

    public short getElapse() {
        return elapse;
    }
    
    
}

