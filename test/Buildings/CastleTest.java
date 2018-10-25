package Buildings;

import Units.*;
import abstractClasses.Building;
import abstractClasses.Unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CastleTest {
    private Castle castletest;
    private Unit infantry;
    private Unit calvary;
    private Unit archer;
    private Unit monk;
    private Unit siege;
    private Unit villager;

    private Building barrack;
    private Building castle;

    @BeforeEach
    void setUp() {
        castletest = new Castle();
        infantry = new InfantryUnit();
        calvary = new CavalryUnit();
        archer = new ArcherUnit();
        monk = new Monk();
        siege = new SiegeUnit();
        villager = new Villager();

        castle = new Castle();
        barrack = new Barrack();
    }

    @Test
    void getHP() {
        assertEquals(4800,castletest.getHP());
    }


    @Test
    void setDead() {
        castletest.setDead();
        assertFalse(castletest.isAlive());
    }

    @Test
    void setHP() {
        castletest.setHP(45);
        assertEquals(45,castletest.getHP());
    }

    @Test
    void getFullhp() {

        castletest.setHP(45);
        assertEquals(4800,castletest.getFullhp());
    }

    @Test
    void getAP() {
        assertEquals(13,castletest.getAP());
    }


    @Test
    void isAlive() {
        assertTrue(castletest.isAlive());
    }

    @Test
    void getRepairedby() {
        castletest.getRepairedby(123);
        assertEquals(4800,castletest.getHP());
        
        castletest.setHP(100);
        castletest.getRepairedby(125);
        assertEquals(225,castletest.getHP());
        
        castletest.setDead();
        castletest.getRepairedby(25);
        assertEquals(0,castletest.getHP());
    }

    @Test
    void getDamagedBy() {
        castletest.getDamagedBy(100);
        assertEquals(4700,castletest.getHP());
        
        castletest.setHP(100);
        castletest.getDamagedBy(150);
        assertTrue((!castletest.isAlive())&&(castletest.getHP()==0));
    }
    @Test
    void attack() {
        castletest.attack(infantry);
        castletest.attack(archer);
        castletest.attack(calvary);
        castletest.attack(siege);
        castletest.attack(villager);
        castletest.attack(monk);

        castletest.attack(castle);
        castletest.attack(barrack);

        int expectedDmgToInfantry = (int) (1.2 * 13);
        int expectedDmgToArcher = (int) (1.2 * 13);
        int expectedDmgToCavalry = (int) (1.2 * 13);
        int expectedDmgToSiege = (int) (0.5 * 13);
        int expectedDmgToVillager = (int) (1.2 * 13);
        // monk must be dead;
        int expectedDmgToCastle = (int) (0.1 * 13);
        int expectedDmgToBarrack = (int) (0.7 * 13);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        castletest.setDead();

        castletest.attack(infantry);
        castletest.attack(archer);
        castletest.attack(calvary);
        castletest.attack(siege);
        castletest.attack(villager);
        castletest.attack(monk);

        castletest.attack(castle);
        castletest.attack(barrack);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

    }
    
}