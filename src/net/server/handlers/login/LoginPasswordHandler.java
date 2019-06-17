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
package net.server.handlers.login;

import client.MapleClient;
import java.util.Calendar;
import net.MaplePacketHandler;
import server.TimerManager;
import net.server.supports.login.LoginPasswordSupport;
import tools.MaplePacketCreator;
import tools.data.input.SeekableLittleEndianAccessor;

public final class LoginPasswordHandler implements MaplePacketHandler {

    @Override
    public boolean validateState(MapleClient c) {
        return !c.isLoggedIn();
    }

    @Override
    public final void handlePacket(SeekableLittleEndianAccessor slea, MapleClient c) {
       
        //------------Read slea stream--------------//
        String password = slea.readMapleAsciiString();
        String userName = slea.readMapleAsciiString();
        
        //--------------------Initate and Load-------------------------------------//
        LoginPasswordSupport login = new LoginPasswordSupport(userName, password, c);
        //----------------Send Packet to Client------------//
        c.announce(MaplePacketCreator.getAuthSuccess(login));
    }
}
