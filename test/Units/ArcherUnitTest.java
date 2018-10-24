package Units;

import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherUnitTest {
    private Unit archer1;
    private Unit archer2;
    private int initialHP=30;
    private int AP=4;
    @BeforeEach
    void setUp() {
        archer1= new ArcherUnit();
        archer2= new ArcherUnit();
    }

    @Test
    void getHP() {
        assertEquals(30, archer1.getHP());
    }

    @Test
    void getMaxHP() {

    }

    @Test
    void getAP() {
    }

    @Test
    void getMultiplier() {
    }

    @Test
    void setDead() {
    }

    @Test
    void isAlive() {
    }

    @Test
    void setHP() {
    }

    @Test
    void attack() {

    }

//    @Test
//    void attackedByInfantry() {
//    }

    @Test
    void attackedByArcher() {
    }
/*
    @Test
    void attackedByCavalry() {
    }

    @Test
    void attackedBySiege() {
    }

    @Test
    void attackedByVillager() {
    }

    @Test
    void attackedByMonk() {
    }

    @Test
    void attackedByCastle() {
    }
*/
}