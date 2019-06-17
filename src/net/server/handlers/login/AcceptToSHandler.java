package net.server.handlers.login;

import client.MapleClient;
import net.AbstractMaplePacketHandler;
import tools.MaplePacketCreator;
import net.server.supports.login.LoginPasswordSupport;
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
    
      //--------------------Initate and Load-----------------//  
      LoginPasswordSupport login = new LoginPasswordSupport(c);
      
      //-----------------Send Pack to client-------------//
      c.announce(MaplePacketCreator.getAuthSuccess(login));
    }
}
