package Entity.Units;

import Entity.Buildings.Barrack;
import Entity.Buildings.Castle;
import Entity.Buildings.Building;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SiegeUnitTest {
    private Unit siegetest;
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
        siegetest = new SiegeUnit();
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
        assertEquals(400, siegetest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(800, siegetest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(15, siegetest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(siegetest.isAlive());
    }

    @Test
    void setDead() {
        siegetest.setDead();
        assertTrue(!siegetest.isAlive());
        assertEquals(0, siegetest.getHP());
    }

    @Test
    void setHP() {
        siegetest.setHP(37);
        assertEquals(37, siegetest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        siegetest.attack(infantry);
        siegetest.attack(archer);
        siegetest.attack(calvary);
        siegetest.attack(siege);
        siegetest.attack(villager);
        siegetest.attack(monk);

        siegetest.attack(castle);
        siegetest.attack(barrack);

        int expectedDmgToInfantry = (int) (1.5 * 15);
        int expectedDmgToArcher = (int) (1.5 * 15);
        int expectedDmgToCavalry = (int) (1.0 * 15);
        int expectedDmgToSiege = (int) (1.5 * 15);
        int expectedDmgToVillager = (int) (1.5 * 15);
        // monk must be dead;
        int expectedDmgToCastle = (int) (2.0 * 15);
        int expectedDmgToBarrack = (int) (2.0 * 15);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        siegetest.setDead();

        siegetest.attack(infantry);
        siegetest.attack(archer);
        siegetest.attack(calvary);
        siegetest.attack(siege);
        siegetest.attack(villager);
        siegetest.attack(monk);

        siegetest.attack(castle);
        siegetest.attack(barrack);

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

