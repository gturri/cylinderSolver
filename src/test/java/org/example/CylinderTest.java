package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    @Test
    public void testGetSide(){
        Cylinder<Integer> sut = new Cylinder<Integer>(10, 20, 30, 40);

        assertEquals(10, sut.getSide(0, 0));
        assertEquals(20, sut.getSide(0, 1));
        assertEquals(30, sut.getSide(0, 2));
        assertEquals(40, sut.getSide(0, 3));

        assertEquals(20, sut.getSide(1, 0));
        assertEquals(10, sut.getSide(2, 2));
        assertEquals(30, sut.getSide(3, 3));
    }
}
