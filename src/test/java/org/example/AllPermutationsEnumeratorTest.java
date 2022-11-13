package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllPermutationsEnumeratorTest {
    @Test
    public void test1Element() {
        AllPermutationsEnumerator sut = new AllPermutationsEnumerator(1);
        assertEquals(0, sut.getValueAtPosition(0));
        assertFalse(sut.moveToNextState());
    }

    @Test
    public void test2Elements() {
       AllPermutationsEnumerator sut = new AllPermutationsEnumerator(2);
       assertState(new Integer[]{1, 0}, sut);
       assertNextState(new Integer[]{0, 1}, sut);
       assertFalse(sut.moveToNextState());
    }

    @Test
    public void test3Elements() {
        AllPermutationsEnumerator sut = new AllPermutationsEnumerator(3);
        assertState(new Integer[]{2, 1, 0}, sut);
        assertNextState(new Integer[]{2, 0, 1}, sut);
        assertNextState(new Integer[]{1, 2, 0}, sut);
        assertNextState(new Integer[]{0, 2, 1}, sut);
        assertNextState(new Integer[]{1, 0, 2}, sut);
        assertNextState(new Integer[]{0, 1, 2}, sut);
        assertFalse(sut.moveToNextState());

    }

    private void assertState(Integer[] expected, AllPermutationsEnumerator actual) {
        for (int i=0 ; i < expected.length ; i++ ){
            assertEquals(expected[i], actual.getValueAtPosition(i));
        }
    }

    private void assertNextState(Integer[] expected, AllPermutationsEnumerator actual) {
        assertTrue(actual.moveToNextState());
        assertState(expected, actual);
    }
}
