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
   
    PAD(0, false),
    PDD(1,false),
    MAD(2,false),
    EMHP(93,false),
    EMMP(94,false),
    EPAD(95,false),
    EPDD(96,false),
    EMDD(97,false),
    Morph(33,false),
    MDD(3,false),
    ACC(4,false),
    EVA(5,false),
    Craft(6,false),
    Speed(7,false),
    Jump(8,false),
    MagicGuard(9,false),
    DarkSight(10,false),
    Booster(11, true),
    PowerGuard(12,false),
    MaxHP(13,false),
    MaxMP(14,false),
    Invincible(15,false),
    SoulArrow(16,false),
    Stun(17,false),
    Poison(18,false),
    Seal(19,false),
    Darkness(20,false),
    ComboCounter(21,false),
    WeaponCharge(22,false),
    DragonBlood(23,false),
    HolySymbol(24,false),
    MesoUp(25,false),
    ShadowPartner(26,false),
    PickPocket(27,false),
    MesoGuard(28,false),
    Thaw(29,false),
    Weakness(30,false),
    Curse(31,false),
    Slow(32,false),
    Regen(34,false),
    BasicStatUp(35,false),
    Stance(36,false),
    SharpEyes(37,false),
    ManaReflection(38,false),
    Attract(39,false),
    SpiritJavelin(40,false),
    Infinity(41,false),
    HolyShield(42,false),
    HamString(43,false),
    Blind(44,false),
    Concentration(45,false),
    BanMap(46,false),
    MaxLevelBuff(47,false),
    MesoUpByItem(48,false),
    Ghost(49,false),
    Barrier(50,false),
    ItemUpByItem(52,false),
    RespectPImmune(53,false),
    RespectMImmune(54,false),
    DefenseAtt(55,false),
    DefenseState(56,false),
    IncEffectHPPotion(57,false),
    IncEffectMPPotion(58,false),
    DojangBerserk(59,false),
    DojangInvincible(60,false),
    Spark(61,false),
    DojangShield(62,false),
    SoulMasterFinal(63,false),
    WindBreakerFinal(64,false),
    ElementalReset(65,false),
    WindWalk(66,false),
    EventRate(67,false),
    ComboAbilityBuff(68,false),
    ComboDrain(69,false),
    ComboBarrier(70,false),
    BodyPressure(71,false),
    SmarkKnockBack(72,false),
    RepeatEffect(73,false),
    ExpBuffRate(74,false),
    StopPortion(75,false),
    StopMotion(76,false),
    Fear(77,false),
    EvanSlow(78,false),
    MagicShield(79,false),
    MagicResistance(80,false),
    SoulStone(81,false),
    Flying(82,false),
    Frozen(83,false),
    AssistCharge(84,false),
    Enrage(85,false),
    SuddenDeath(86,false),
    NotDamaged(87,false),
    FinalCut(88,false),
    Thornseffect(89,false),
    SwallowAttackDamage(90,false),
    MorewildDamageUp(91,false),
    Mine(92,false),
    Guard(98,false),
    SafetyDamage(99,false),
    SafetyAbsorb(100,false),
    Cyclone(101,false),
    SwallowCritical(102,false),
    SwallowMaxMP(103,false),
    SwallowDefence(104,false),
    SwallowEvasion(105,false),
    Conversion(106,false),
    Revive(107,false),
    Sneak(108,false),
    Mechanic(109,false),
    Aura(110,false),
    DarkAura(111,false),
    BlueAura(112,false),
    YellowAura(113,false),
    SuperBody(114,false),
    MorewildMaxHP(115,false),
    Dice(116,false),
    BlessingArmor(117,false),
    DamR(118,false),
    TeleportMasteryOn(119,false),
    CombatOrders(120,false),
    Beholder(121,false),
    RideVehicle(125, true),
    GuidedBullet(127, true),
    SummonBomb(129,false),
    SPEED_INFUSION(0x100000000000000L,false),
    HOMING_BEACON(0x80000000000000L,false),
    ENERGY_CHARGE(0x4000000000000L,false),
    PUPPET(0x800000000000000L,false),
    SUMMON(0x20000000000000L,false),
    SHADOW_CLAW(0x100,false),
    CONFUSE(0x80000,false),
    FINALATTACK(0x80000000L,false),
    DASH2(0x8000000000000L, true), // correct (speed)
    DASH(0x10000000000000L, true), // correct (jump)
    
    PYRAMID_PQ(0x20000000000L, true),
    ECHO_OF_HERO(0x8000,false),
    BERSERK_FURY(0x8000000,false),
    DIVINE_BODY(0x10000000,false),
    MAPLE_WARRIOR(0x8,false);
    
    private final long i;
    private final boolean twoState;

    private MapleBuffStat(long i, boolean twoState) {
        this.i = i;
        this.twoState = twoState;
    }
    public long getValue() {
        return i;
    }

    public boolean isTwoState(){
        return twoState;
    }
   
}
