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
package client;

public enum MapleBuffStat {
   
    PAD(0, 1),
    PDD(1,1),
    MAD(2,1),
    EMHP(93,1),
    EMMP(94,1),
    EPAD(95,1),
    EPDD(96,1),
    EMDD(97,1),
    Morph(33,1),
    MDD(3,1),
    ACC(4,1),
    EVA(5,1),
    Craft(6,1),
    Speed(7,1),
    Jump(8,1),
    MagicGuard(9,1),
    DarkSight(10,1),
    Booster(11, 3),
    PowerGuard(12,1),
    MaxHP(13,1),
    MaxMP(14,1),
    Invincible(15,1),
    SoulArrow(16,1),
    Stun(17,1),
    Poison(18,1),
    Seal(19,1),
    Darkness(20,1),
    ComboCounter(21,1),
    WeaponCharge(22,1),
    DragonBlood(23,1),
    HolySymbol(24,1),
    MesoUp(25,1),
    ShadowPartner(26,1),
    PickPocket(27,1),
    MesoGuard(28,1),
    Thaw(29,1),
    Weakness(30,1),
    Curse(31,1),
    Slow(32,1),
    Regen(34,1),
    BasicStatUp(35,1),
    Stance(36,1),
    SharpEyes(37,1),
    ManaReflection(38,1),
    Attract(39,1),
    SpiritJavelin(40,1),
    Infinity(41,1),
    HolyShield(42,1),
    HamString(43,1),
    Blind(44,1),
    Concentration(451,1),
    BanMap(46,1),
    MaxLevelBuff(47,1),
    MesoUpByItem(48,1),
    Ghost(49,3),
    Barrier(50,1),
    ItemUpByItem(52,1),
    RespectPImmune(53,1),
    RespectMImmune(54,1),
    DefenseAtt(55,1),
    DefenseState(56,1),
    IncEffectHPPotion(57,1),
    IncEffectMPPotion(58,1),
    DojangBerserk(59,1),
    DojangInvincible(60,1),
    Spark(61,1),
    DojangShield(62,1),
    SoulMasterFinal(63,1),
    WindBreakerFinal(64,1),
    ElementalReset(65,1),
    WindWalk(66,1),
    EventRate(67,1),
    ComboAbilityBuff(68,1),
    ComboDrain(69,1),
    ComboBarrier(70,1),
    BodyPressure(71,1),
    SmarkKnockBack(72,1),
    RepeatEffect(73,1),
    ExpBuffRate(74,1),
    StopPortion(75,1),
    StopMotion(76,1),
    Fear(77,1),
    EvanSlow(78,1),
    MagicShield(79,1),
    MagicResistance(80,1),
    SoulStone(81,1),
    Flying(82,1),
    Frozen(83,1),
    AssistCharge(84,1),
    Enrage(85,1),
    SuddenDeath(86,1),
    NotDamaged(87,1),
    FinalCut(88,1),
    Thornseffect(89,1),
    SwallowAttackDamage(90,2),
    MorewildDamageUp(91,1),
    Mine(92,1),
    Guard(98,1),
    SafetyDamage(99,1),
    SafetyAbsorb(100,1),
    Cyclone(101,1),
    SwallowCritical(102,2),
    SwallowMaxMP(103,2),
    SwallowDefence(104,2),
    SwallowEvasion(105,2),
    Conversion(106,1),
    Revive(107,1),
    Sneak(108,1),
    Mechanic(109,1),
    Aura(110,1),
    DarkAura(111,1),
    BlueAura(112,1),
    YellowAura(113,1),
    SuperBody(114,1),
    MorewildMaxHP(115,1),
    Dice(116,2),
    BlessingArmor(117,2),
    DamR(118,1),
    TeleportMasteryOn(119,1),
    CombatOrders(120,1),
    Beholder(121,1),
    EnergyCharged(122, 3),
    RideVehicle(125, 3),
    GuidedBullet(127, 3),
    SummonBomb(129,1),
    SPEED_INFUSION(0x100000000000000L,1),
    HOMING_BEACON(0x80000000000000L,1),
    ENERGY_CHARGE(0x4000000000000L,1),
    PUPPET(0x800000000000000L,1),
    SUMMON(0x20000000000000L,1),
    SHADOW_CLAW(0x100,1),
    CONFUSE(0x80000,1),
    FINALATTACK(0x80000000L,1),
    Dash_Speed(123, 3), // correct (speed)
    Dash_Jump(124, 3), // correct (jump)
    
    PYRAMID_PQ(0x20000000000L, 1),
    ECHO_OF_HERO(0x8000,1),
    BERSERK_FURY(0x8000000,1),
    DIVINE_BODY(0x10000000,1),
    MAPLE_WARRIOR(0x8,1);
    
    private final long i;
    private final int state;

    private MapleBuffStat(long i,int state) {
        this.i = i;
        this.state  = state;
    }
    public long getValue() {
        return i;
    }

    public int getState(){
        return state;
    }
   
}
