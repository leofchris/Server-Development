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

import client.MapleCharacter;
import client.MapleClient;
import client.MapleStat;
import client.Skill;
import client.SkillFactory;
import constants.skills.Aran;
import net.AbstractMaplePacketHandler;
import tools.data.input.SeekableLittleEndianAccessor;

public final class DistributeSPHandler extends AbstractMaplePacketHandler {
    @Override
    public final void handlePacket(SeekableLittleEndianAccessor slea, MapleClient c) {
        slea.readInt();
        int skillid = slea.readInt();
        MapleCharacter player = c.getPlayer();
        int remainingSp = player.getRemainingSp();
        int[] extendedSP = player.getExtendedSp();
        boolean isBeginnerSkill = false;
        if (skillid % 10000000 > 999 && skillid % 10000000 < 1003) {
            int total = 0;
            for (int i = 0; i < 3; i++) {
                total += player.getSkillLevel(SkillFactory.getSkill(player.getJobType() * 10000000 + 1000 + i));
            }
            remainingSp = Math.min((player.getLevel() - 1), 6) - total;
            isBeginnerSkill = true;
        }
        Skill skill = SkillFactory.getSkill(skillid);
        int curLevel = player.getSkillLevel(skill);
        
            if (!isBeginnerSkill) {
                if(player.getJob().getId()/1000 == 3 || player.getJob().getId()/100 == 22 || player.getJob().getId() == 2001){
                    
                  if (player.getJob().getId()/1000 == 3){
                        if (player.getJob().getId() == 3500 || player.getJob().getId() == 3300 || player.getJob().getId() == 3200 || ((skillid % 100000000 >= 35001001) && (skillid % 100000000 <= 35001004)) || ((skillid % 100000000 >= 32001000) && (skillid % 100000000 <= 32001003)) || ((skillid % 100000000 >= 33001000) && (skillid % 100000000 <= 33001003))){
                            extendedSP[1]--;
                        } else if (player.getJob().getId() == 3510 || player.getJob().getId() == 3310|| player.getJob().getId() == 3210 || ((skillid % 100000000 >= 35100000) && (skillid % 100000000 <= 35101010)) || ((skillid % 100000000 >= 32100006) && (skillid % 100000000 <= 32101005)) || ((skillid % 100000000 >= 33100000) && (skillid % 100000000 <= 33101008))){
                            extendedSP[2]--;
                        } else if (player.getJob().getId() == 3511 || player.getJob().getId() == 3311 || player.getJob().getId() == 3211 || ((skillid % 100000000 >= 35111001) && (skillid % 100000000 <= 35111015)) || ((skillid % 100000000 >= 32110000) && (skillid % 100000000 <= 32111011)) || ((skillid % 100000000 >= 33110000) && (skillid % 100000000 <= 33111006))){
                            extendedSP[3]--;
                        } else if (player.getJob().getId() == 3512 || player.getJob().getId() == 3312 || player.getJob().getId() == 3212){
                           extendedSP[4]--;
                        }
                    }
                   else if (player.getJob().getId()/100 == 22 || player.getJob().getId() == 2001){
                         if ((player.getJob().getId() == 2200) || ((skillid % 100000000 >= 22000000) && (skillid % 100000000 <= 22001001))){
                            extendedSP[1]--;
                        } else if ((player.getJob().getId() == 2210) || ((skillid % 100000000 >= 22101000) && (skillid % 100000000 <= 22101001))){
                           extendedSP[2]--; 
                        } else if (player.getJob().getId() == 2211 || ((skillid % 100000000 >= 22111000) && (skillid % 100000000 <= 22111001))){
                            extendedSP[3]--;
                        }  else if (player.getJob().getId() == 2212 || ((skillid % 100000000 >= 22120002) && (skillid % 100000000 <= 22121001))){
                            extendedSP[4]--;
                        }  else if (player.getJob().getId() == 2213 || ((skillid % 100000000 >= 22131000) && (skillid % 100000000 <= 22131001))){
                            extendedSP[5]--;
                        }   else if (player.getJob().getId() == 2214 || ((skillid % 100000000 >= 22141001) && (skillid % 100000000 <= 22141003))){
                           extendedSP[6]--;
                        }   else if (player.getJob().getId() == 2215 || ((skillid % 100000000 >= 22150000) && (skillid % 100000000 <= 22151003))){
                            extendedSP[7]--;
                        }  else if (player.getJob().getId() == 2216 || ((skillid % 100000000 >= 22160000) && (skillid % 100000000 <= 22161003))){
                           extendedSP[8]--;
                        }  else if (player.getJob().getId() == 2217 || ((skillid % 100000000 >= 22171000) && (skillid % 100000000 <= 22171004))){
                           extendedSP[9]--;
                        }  else if (player.getJob().getId() == 2218 || ((skillid % 100000000 >= 22181000) && (skillid % 100000000 <= 22181003))){
                            extendedSP[10]--;
                        }
                    }
                    player.setRemainingSp(player.getRemainingSp() - 1);
                }
                    else{
                            player.setRemainingSp(player.getRemainingSp() - 1);
                        }
                }
            player.updateSingleStat(MapleStat.AVAILABLESP, player.getRemainingSp(), extendedSP);
            player.changeSkillLevel(skill, (byte) (curLevel + 1), player.getMasterLevel(skill), player.getSkillExpiration(skill));
        
    }
}
