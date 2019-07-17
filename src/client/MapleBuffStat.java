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
    
     
    RECOVERY(0x4),
    MAPLE_WARRIOR(0x8),
    STANCE(0x10),
    SHARP_EYES(0x20),
    SHOWDASH(0x4000000000L),
    MANA_REFLECTION(0x40),
    SHADOW_CLAW(0x100),
    INFINITY(0x200),
    HOLY_SHIELD(0x400),
    HAMSTRING(0x800),
    BLIND(0x1000),
    CONCENTRATE(0x2000),
    ECHO_OF_HERO(0x8000),
    GHOST_MORPH(0x20000),
    AURA(0x40000),
    CONFUSE(0x80000),
    BERSERK_FURY(0x8000000),
    DIVINE_BODY(0x10000000),
   // PAD(0x100000000L),
    //PDD(0x200000000L),
    //MAD(0x400000000L),
    //MDD(0x800000000L),
    ACC(0x1000000000L),
    EVA(0x2000000000L),
    HANDS(0x4000000000L),
    SPEED(0x8000000000L),
    JUMP(0x10000000000L),
    MAGIC_GUARD(0x20000000000L),
    DARKSIGHT(0x40000000000L),
    BOOSTER(0x80000000000L),
    POWERGUARD(0x100000000000L),
    HYPERBODYHP(0x200000000000L),
    HYPERBODYMP(0x400000000000L),
    INVINCIBLE(0x800000000000L),
    SOULARROW(0x1000000000000L),
    STUN(0x2000000000000L),
    POISON(0x4000000000000L),
    SEAL(0x8000000000000L),
    DARKNESS(0x10000000000000L),
    COMBO(0x20000000000000L),
    SUMMON(0x20000000000000L),
    WK_CHARGE(0x40000000000000L),
    DRAGONBLOOD(0x80000000000000L),
    HOLY_SYMBOL(0x100000000000000L),
    MESOUP(0x200000000000000L),
    SHADOWPARTNER(0x400000000000000L),
    PICKPOCKET(0x800000000000000L),
    PUPPET(0x800000000000000L),
    MESOGUARD(0x1000000000000000L),
    WEAKEN(0x4000000000000000L),
    FINALATTACK(0x80000000L),
    SPARK(0x20000000L),
    BATTLESHIP(0xA00000040L),
    DASH2(0x8000000000000L, true), // correct (speed)
    DASH(0x10000000000000L, true), // correct (jump)
    ELEMENTAL_RESET(0x200000000L, true), 
    ARAN_COMBO(0x1000000000L, true),
    COMBO_DRAIN(0x2000000000L, true),
    COMBO_BARRIER(0x4000000000L, true),
    BODY_PRESSURE(0x8000000000L, true),
    SMART_KNOCKBACK(0x10000000000L, true),
    PYRAMID_PQ(0x20000000000L, true),
    ENERGY_CHARGE(0x4000000000000L, true),
    MONSTER_RIDING(0x20000000000000L, true),
    HOMING_BEACON(0x80000000000000L, true),
    SPEED_INFUSION(0x100000000000000L, true),
    
    PAD(0),
    PDD(1),
    MAD(2),
    EMHP(93),
    EMMP(94),
    EPAD(95),
    EPDD(96),
    EMDD(97),
    Morph(0x0000000200000000L),
    MDD(3);
   
    /*ACC(4),
    EVA(5),
    Craft(6),
    Speed(7),
    Jump(8),
    MagicGuard(9),
    DarkSight(10),
    Booster(11),
    PowerGuard(12),
    MaxHP(13),
    MaxMP(14),
    Invincible(15),
    SoulArrow(16),
    Stun(17),
    Poison(18),
    Seal(19),
    Darkness(20),
    ComboCounter(21),
    WeaponCharge(22),
    DragonBlood(23),
    HolySymbol(24),
    MesoUp(25),
    ShadowPartner(26),
    PickPocket(27),
    MesoGuard(28),
    Thaw(29),
    Weakness(30),
    Curse(31),
    Slow(32),
    
    Regen(34),
    BasicStatUp(35),
    Stance(36),
    SharpEyes(37),
    ManaReflection(38),
    Attract(39),
    SpiritJavelin(40),
    Infinity(41),
    HolyShield(42),
    HamString(43),
    Blind(44),
    Concentration(45),
    BanMap(46),
    MaxLevelBuff(47),
    MesoUpByItem(48),
    Ghost(49),
    Barrier(50),
    ItemUpByItem(52),
    RespectPImmune(53),
    RespectMImmune(54),
    DefenseAtt(55),
    DefenseState(56),
    IncEffectHPPotion(57),
    IncEffectMPPotion(58),
    DojangBerserk(59),
    DojangInvincible(60),
    Spark(61),
    DojangShield(62),
    SoulMasterFinal(63),
    WindBreakerFinal(64),
    ElementalReset(65),
    WindWalk(66),
    EventRate(67),
    ComboAbilityBuff(68),
    ComboDrain(69),
    ComboBarrier(70),
    BodyPressure(71),
    SmarkKnockBack(72),
    RepeatEffect(73),
    ExpBuffRate(74),
    StopPortion(75),
    StopMotion(76),
    Fear(77),
    EvanSlow(78),
    MagicShield(79),
    MagicResistance(80),
    SoulStone(81),
    Flying(82),
    Frozen(83),
    AssistCharge(84),
    Enrage(85),
    SuddenDeath(86),
    NotDamaged(87),
    FinalCut(88),
    Thornseffect(89),
    SwallowAttackDamage(90),
    MorewildDamageUp(91),
    Mine(92),
   
    Guard(98),
    SafetyDamage(99),
    SafetyAbsorb(100),
    Cyclone(101),
    SwallowCritical(102),
    SwallowMaxMP(103),
    SwallowDefence(104),
    SwallowEvasion(105),
    Conversion(106),
    Revive(107),
    Sneak(108),
    Mechanic(109),
    Aura(110),
    DarkAura(111),
    BlueAura(112),
    YellowAura(113),
    SuperBody(114),
    MorewildMaxHP(115),
    Dice(116),
    BlessingArmor(117),
    DamR(118),
    TeleportMasteryOn(119),
    CombatOrders(120),
    Beholder(121),
    RideVehicle(125),
    GuidedBullet(127),
    SummonBomb(129);*/
    
    
    
    private final long i;
    private final boolean isFirst;
    private byte[] twoState = new byte[128];

    private MapleBuffStat(long i, boolean isFirst) {
        this.i = i;
        this.isFirst = isFirst;
    }

    private MapleBuffStat(long i) {
        this.i = i;
        this.isFirst = false;
    }

    public long getValue() {
        return i;
    }

    public boolean isFirst() {
        return isFirst;
    }
}
