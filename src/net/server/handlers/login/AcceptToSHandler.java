package net.server.handlers.login;

import client.MapleClient;
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
       
        byte loginok = 0;
        boolean loggedIn = true;
        
        if (!c.acceptToS()){
        
           loggedIn = false;
           loginok = 0x02;
         
        }
            
        
        c.setLoggedIn(loggedIn);
    
        
    }
}
