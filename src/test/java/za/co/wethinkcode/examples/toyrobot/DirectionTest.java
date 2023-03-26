package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    public void startDirection() {
        Direction direction = new Direction();
//    Level myVar = Level.MEDIUM;
//        Direction.Direction_list n = Direction.Direction_list.EAST;
//        direction.setDirection(n);
        assertEquals("NORTH", String.valueOf(direction.returnDirection()));

    }


}