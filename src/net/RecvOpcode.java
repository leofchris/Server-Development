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
package net;

public enum RecvOpcode {
    
  
    CUSTOM_PACKET(0x3713),//13 37 lol
    
    CheckPassword(0x01),
    GUEST_LOGIN(0x02),
    SERVERLIST_REREQUEST(0x04),
    SelectWorld(0x05),
    CheckUserLimit(0x06),
    ACCEPT_TOS(0x07),
    SET_GENDER(0x08),
    CheckPinCode(0x09),
    UpdatePinCode(0x0A),
    WorldRequest(0x0B),
    PLAYER_DC(0x0C),
    ViewAllChar(0x0D),
    SelectCharacterByVAC(0x0E),
    CHAR_SELECT(0x13),
    PLAYER_LOGGEDIN(0x14),
    CheckDuplicatedID(0x15),
    CreateNewCharacter(0x16),
    DeleteCharacter(0x18), //(0x17) v83 +1
    AliveAck(0x19),// (0x18) v83 +1
    CLIENT_START_ERROR(0x19),
    CLIENT_ERROR(0x1A),
    STRANGE_DATA(0x1B),
    RELOG(0x1CCCC),
    EnableSPWRequest(0x1C), //(0x1D) v83 -1
    CheckSPWRequest(0x1D), // (0x1E) v83 -1
    EnableSPWRequestByACV(0x1E),// (0x1F) v83 -1 
    CheckSPWRequestByACV(0x1F), // (0x20) v83 -1
    CHANGE_MAP(0x26),
    CHANGE_CHANNEL(0x27),
    ENTER_CASHSHOP(0x28),
    MOVE_PLAYER(0x2C), //(0x29)
    CANCEL_CHAIR(0x2D),
    USE_CHAIR(0x2E),
    CLOSE_RANGE_ATTACK(0x2CC),//(0x2C)
    RANGED_ATTACK(0x2DD),//(0x2D) v83
    MAGIC_ATTACK(0x2EE),
    TOUCH_MONSTER_ATTACK(0x2F),
    TAKE_DAMAGE(0x30),
    GENERAL_CHAT(0x36), //(0x31) v83
    CLOSE_CHALKBOARD(0x32),
    FACE_EXPRESSION(0x33),
    UserActivateEffectItem(0x39), //(0x34) v83
    USE_DEATHITEM(0x35),
    MONSTER_BOOK_COVER(0x309),
    NPC_TALK(0x3A),
    REMOTE_STORE(0x3B),
    NPC_TALK_MORE(0x3C),
    NPC_SHOP(0x3D),
    STORAGE(0x3E),
    HIRED_MERCHANT_REQUEST(0x3F),
    FREDRICK_ACTION(0x40),
    DUEY_ACTION(0x41),
    ADMIN_SHOP(0x44),//oh lol
    ITEM_SORT(0x45),
    ITEM_SORT2(0x46),
    UserChangeSlotPositionRequest(0x4D), //(0x47) V83
    UserStatChangeItemUseRequest(0x4E), //(0x48) v83 
    CANCEL_ITEM_EFFECT(0x49),
    USE_SUMMON_BAG(0x4B),
    PET_FOOD(0x4C),
    USE_MOUNT_FOOD(0x4DD),
    SCRIPTED_ITEM(0x4EE),
    USE_CASH_ITEM(0x4F),

    USE_CATCH_ITEM(0x51),
    USE_SKILL_BOOK(0x52),
    USE_TELEPORT_ROCK(0x54),
    USE_RETURN_SCROLL(0x55),
    USE_UPGRADE_SCROLL(0x56),
    DISTRIBUTE_AP(0x62), //(0x57) v83
    AUTO_DISTRIBUTE_AP(0x63), //(0x58) v83
    UserChangeStatRequest(0x64), //(0x59) v83
    DISTRIBUTE_SP(0x66), //(0x5A) V83
    SPECIAL_MOVE(0x67), //(0x5B);
    CANCEL_BUFF(0x68), //(0x5C)
    SKILL_EFFECT(0x5D),
    MESO_DROP(0x5E),
    GIVE_FAME(0x5F),
    CHAR_INFO_REQUEST(0x61), //(0x61) V83
    SPAWN_PET(0x622), //(0x62) v83
    CANCEL_DEBUFF(0x633),
    CHANGE_MAP_SPECIAL(0x70), //(0x64) v83
    USE_INNER_PORTAL(0x65),
    TROCK_ADD_MAP(0x6667),
    REPORT(0x6A),
    QUEST_ACTION(0x6B),
    //lolno
    SKILL_MACRO(0x6E),
    SPOUSE_CHAT(0x6F),
    USE_ITEM_REWARD(0x700), //(0x70) v83
    MAKER_SKILL(0x71),
    USE_REMOTE(0x74),
    ADMIN_CHAT(0x76),
    PARTYCHAT(0x777), //(0x77);
    WHISPER(0x78),
    MESSENGER(0x7A),
    PLAYER_INTERACTION(0x7B),
    PARTY_OPERATION(0x7C),
    DENY_PARTY_REQUEST(0x7D),
    GUILD_OPERATION(0x7E),
    DENY_GUILD_REQUEST(0x7F),
    ADMIN_COMMAND(0x80),
    ADMIN_LOG(0x81),
    BUDDYLIST_MODIFY(0x82),
    NOTE_ACTION(0x83),
    USE_DOOR(0x85),
    CHANGE_KEYMAP(0x87),
    RPS_ACTION(0x88),
    RING_ACTION(0x89),
    WEDDING_ACTION(0x8A),
    OPEN_FAMILY(0x92),
    ADD_FAMILY(0x93),
    ACCEPT_FAMILY(0x96),
    USE_FAMILY(0x97),
    ALLIANCE_OPERATION(0x98),
    BBS_OPERATION(0x9B),
    ENTER_MTS(0x9C),
    USE_SOLOMON_ITEM(0x9D),
    USE_GACHA_EXP(0x9E),
    CLICK_GUIDE(0xA2),
    ARAN_COMBO_COUNTER(0xA3),
    MOVE_PET(0xA7),
    PET_CHAT(0xA8),
    PET_COMMAND(0xA9),
    PET_LOOT(0xAA),
    PET_AUTO_POT(0xAB),
    PET_EXCLUDE_ITEMS(0xAC),
    MOVE_SUMMON(0xAF),
    SUMMON_ATTACK(0xB0),
    DAMAGE_SUMMON(0xB1),
    BEHOLDER(0xB2),
    MOVE_LIFE(0xBC),
    AUTO_AGGRO(0xBD),
    MOB_DAMAGE_MOB_FRIENDLY(0xC0),
    MONSTER_BOMB(0xC1),
    MOB_DAMAGE_MOB(0xC2),
    NPC_ACTION(0xC5),
    ITEM_PICKUP(0xCA),
    DAMAGE_REACTOR(0xCD),
    TOUCHING_REACTOR(0xCE),
    TEMP_SKILL(0xCF),
    MAPLETV(0xFFFE),//Don't know
    SNOWBALL(0xD3),
    LEFT_KNOCKBACK(0xD4),
    COCONUT(0xD5),
    MATCH_TABLE(0xD6),//Would be cool if I ever get it to work :)
    MONSTER_CARNIVAL(0xDA),
    PARTY_SEARCH_REGISTER(0xDC),
    PARTY_SEARCH_START(0xDE),
    PLAYER_UPDATE(0xDF),
    CHECK_CASH(0xE4),
    CASHSHOP_OPERATION(0xE5),
    COUPON_CODE(0xE6),
    OPEN_ITEMUI(0xEB),
    CLOSE_ITEMUI(0xEC),
    USE_ITEMUI(0xED),
    MTS_OPERATION(0xFD),
    USE_MAPLELIFE(0xFE),
    USE_HAMMER(0x104);
    private int code = -2;

    private RecvOpcode(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}
