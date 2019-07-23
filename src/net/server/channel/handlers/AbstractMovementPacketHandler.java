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
package net.server.channel.handlers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import net.AbstractMaplePacketHandler;
import server.maps.AnimatedMapleMapObject;
import server.movement.AbsoluteLifeMovement;
import server.movement.ChairMovement;
import server.movement.ChangeEquip;
import server.movement.JumpDownMovement;
import server.movement.LifeMovementFragment;
import server.movement.RandomMovement;

import server.movement.RelativeLifeMovement;
import server.movement.TeleportLifeMovement;
import tools.data.input.LittleEndianAccessor;

public abstract class AbstractMovementPacketHandler extends AbstractMaplePacketHandler {

    protected List<LifeMovementFragment> parseMovement(LittleEndianAccessor lea) {
       List<LifeMovementFragment> res = new ArrayList<>();
        
        int lock = 0;
        short fhFallStart = 0;
        short currentX = lea.readShort();
        short currentY = lea.readShort();
        short currentVX = lea.readShort();
        short currentVY = lea.readShort();
        byte numCommands = lea.readByte();

        for (byte i = 0; i < numCommands; i++) {
            byte command = lea.readByte();
            switch (command) {
                case 0: // normal move
                case 5:
                case 12:
                case 14:
                case 35:
                case 36:
                    short x = lea.readShort();
                    short y = lea.readShort();
                    short vx = lea.readShort();
                    short vy = lea.readShort();
                    short fh = lea.readShort();
                    if (command == 12){
                       lock = 1;
                       fhFallStart = lea.readShort();
                    }
                    short xOffset = lea.readShort();
                    short yOffset = lea.readShort();
                    
                    byte moveAction = lea.readByte();
                    short elapse = lea.readShort();
                         AbsoluteLifeMovement alm = new AbsoluteLifeMovement(command, new Point(x, y), new Point(vx, vy), fh, fhFallStart, xOffset, yOffset, moveAction, elapse, currentVX, currentVY, currentX, currentY, lock);
                         res.add(alm);
                         lock = 0;
                    break;
                case 1:
                case 2:
                case 13: // Shot-jump-back thing
                case 16: 
                case 18:
                case 31:
                case 32:
                case 33:
                case 34:
                     vx = lea.readShort();
                     vy = lea.readShort();
                     moveAction = lea.readByte();
                     elapse = lea.readShort();
                     RelativeLifeMovement rlm = new RelativeLifeMovement(command, new Point(vx, vy), moveAction, elapse);
                     res.add(rlm);
                    break;
                case 3:
                case 4: // tele... -.-
                case 6: // assaulter
                case 7: // assassinate
                case 8: // rush
                case 10:
                    x = lea.readShort();
                    y = lea.readShort();
                    fh = lea.readShort();   
                    moveAction = lea.readByte();
                    elapse = lea.readShort();
                    TeleportLifeMovement tlm = new TeleportLifeMovement(command, new Point(x,y), fh, moveAction, elapse);
                    res.add(tlm);
                    break;    
                case 9:
                     byte stat = lea.readByte();
                     ChangeEquip ce = new ChangeEquip(command, stat);
                     res.add(ce);
                    break;
                case 11: 
                    vx = lea.readShort();
                    vy = lea.readShort();
                    fhFallStart = lea.readShort();
                    moveAction = lea.readByte();
                    elapse = lea.readShort();
                    JumpDownMovement jdm = new JumpDownMovement(command, new Point(vx, vy), fhFallStart, moveAction, elapse);
                    res.add(jdm);
                    break;
                case 17: 
                   x = lea.readShort();
                   y = lea.readShort();
                   vx = lea.readShort();
                   vy = lea.readShort();
                   moveAction = lea.readByte();
                   elapse = lea.readShort();
                   ChairMovement cm = new ChairMovement(command, new Point(x,y), new Point(vx, vy), moveAction, elapse);
                   res.add(cm);
                   break;
                case 20: 
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30: 
                    moveAction = lea.readByte();
                    elapse = lea.readShort();
                    RandomMovement rm = new RandomMovement(command, moveAction, elapse);
                    res.add(rm);
                    break;

                default:
                    return null;
            }
        }
        return res;
    }

    protected void updatePosition(List<LifeMovementFragment> movement, AnimatedMapleMapObject target, int yoffset) {
        for (LifeMovementFragment move : movement) {
 
                   Point position = ((AbsoluteLifeMovement) move).getPosition();    
                    
                    target.setPosition(position);
            }
        }
}
