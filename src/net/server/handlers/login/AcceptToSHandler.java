package net.server.handlers.login;

import client.MapleClient;
import client.MapleLogin;
import net.AbstractMaplePacketHandler;
import tools.MaplePacketCreator;
import tools.data.input.SeekableLittleEndianAccessor;

/**
 *
 * @author kevintjuh93
 */
public final class AcceptToSHandler extends AbstractMaplePacketHandler {

    @Override
    public boolean validateState(MapleClient c) {
     
        return !c.isLoggedIn();
    }

    @Override
    public final void handlePacket(SeekableLittleEndianAccessor slea, MapleClient c) {

      MapleLogin loginok = new MapleLogin();
      c.acceptToS();
        
      c.setLoggedIn(true);
      c.announce(MaplePacketCreator.getAuthSuccess(c, loginok));
    }
}
