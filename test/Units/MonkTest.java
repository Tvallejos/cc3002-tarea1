package Units;

import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkTest {

    private Unit monktest;
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
        monktest = new Monk();
        infantry = new InfantryUnit();
        calvary = new CavalryUnit();
        archer = new ArcherUnit();
        monk = new Monk();
        siege = new SiegeUnit();
        villager = new Villager();

        castle = new Castle();
        barrack = new Barrack();
    }

    //getters test
    @Test
    void getHP() {
        assertEquals(100, monktest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(200, monktest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(10, monktest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(monktest.isAlive());
    }

    @Test
    void setDead() {
        monktest.setDead();
        assertTrue(!monktest.isAlive());
        assertEquals(0, monktest.getHP());
    }

    @Test
    void setHP() {
        monktest.setHP(37);
        assertEquals(37, monktest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        monktest.attack(infantry);
        monktest.attack(archer);
        monktest.attack(calvary);
        monktest.attack(siege);
        monktest.attack(villager);
        monktest.attack(monk);

        monktest.attack(castle);
        monktest.attack(barrack);

        // monk heals multiplier% of the maximum health of the unit

        int expectedHealToInfantry = (int) (0.5 * 10*300/100);
        int expectedHealToArcher = (int) (0.5 * 10*200/100);
        int expectedHealToCavalry = (int) (0.5 * 10*400/100);
        int expectedHealToSiege = 0;
        int expectedHealToVillager = (int) (0.5 * 10*200/100);
        int expectedHealToMonk = (int) (0.5*10*200/100);

        assertEquals(150 + expectedHealToInfantry, infantry.getHP());
        assertEquals(100 + expectedHealToArcher, archer.getHP());
        assertEquals(200 + expectedHealToCavalry, calvary.getHP());
        assertEquals(400 + expectedHealToSiege, siege.getHP());

        assertEquals(100 + expectedHealToVillager, villager.getHP());
        assertTrue((monk.isAlive()) && (100+expectedHealToMonk == monk.getHP()));
        assertEquals(4800, castle.getHP());
        assertEquals(1200, barrack.getHP());

        // dont attack if is dead
        monktest.setDead();

        monktest.attack(infantry);
        monktest.attack(archer);
        monktest.attack(calvary);
        monktest.attack(siege);
        monktest.attack(villager);
        monktest.attack(monk);


        castle.setHP(100);
        barrack.setHP(100);
        monktest.attack(castle);
        monktest.attack(barrack);

        assertEquals(150 + expectedHealToInfantry, infantry.getHP());
        assertEquals(100 + expectedHealToArcher, archer.getHP());
        assertEquals(200 + expectedHealToCavalry, calvary.getHP());
        assertEquals(400 + expectedHealToSiege, siege.getHP());

        assertEquals(100 + expectedHealToVillager, villager.getHP());
        assertTrue((monk.isAlive()) && (100+expectedHealToMonk == monk.getHP()));
        assertEquals(100 , castle.getHP());
        assertEquals(100 , barrack.getHP());

    }
}

