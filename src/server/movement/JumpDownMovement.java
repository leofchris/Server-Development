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

public class JumpDownMovement implements LifeMovementFragment {
    private Point velocity;
    private byte moveAction, type;
    private short elapse, fhFallStart;

    public JumpDownMovement(byte type, Point velocity, short fhFallStart, byte moveAction, short elapse) {
     this.type = type;
      
       this.velocity = velocity;
       this.fhFallStart = fhFallStart;
       this.moveAction = moveAction;
       this.elapse = elapse;
    }

 @Override
    public void serialize(LittleEndianWriter lew) {
       lew.write(getType());
       lew.writeShort(getVelocity().x);
       lew.writeShort(getVelocity().y);
       lew.writeShort(getFhFallStart());
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

    public short getFhFallStart() {
        return fhFallStart;
    }

    public short getElapse() {
        return elapse;
    }
}
