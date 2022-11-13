package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllPossibleValueEnumeratorTest {

    @Test
    public void testAllPossibleValueEnumerator() {
        AllPossibleValuesEnumerator sut = new AllPossibleValuesEnumerator(3, 4);

        assertState(new Integer[]{0, 0, 0}, sut);
        assertNextState(new Integer[]{1, 0, 0}, sut);
        assertNextState(new Integer[]{2, 0, 0}, sut);
        assertNextState(new Integer[]{3, 0, 0}, sut);
        assertNextState(new Integer[]{0, 1, 0}, sut);
        assertNextState(new Integer[]{1, 1, 0}, sut);
        assertNextState(new Integer[]{2, 1, 0}, sut);
        assertNextState(new Integer[]{3, 1, 0}, sut);
        assertNextState(new Integer[]{0, 2, 0}, sut);
        assertNextState(new Integer[]{1, 2, 0}, sut);
        assertNextState(new Integer[]{2, 2, 0}, sut);
        assertNextState(new Integer[]{3, 2, 0}, sut);
        assertNextState(new Integer[]{0, 3, 0}, sut);
        assertNextState(new Integer[]{1, 3, 0}, sut);
        assertNextState(new Integer[]{2, 3, 0}, sut);
        assertNextState(new Integer[]{3, 3, 0}, sut);
        assertNextState(new Integer[]{0, 0, 1}, sut);
        assertNextState(new Integer[]{1, 0, 1}, sut);


        for (int i=0 ; i < 16*4 - 16 - 2 ; i++ ){
            assertTrue(sut.moveToNextState());
        }

        assertFalse(sut.moveToNextState());
    }

    private void assertState(Integer[] expected, AllPossibleValuesEnumerator actual) {
       for (int i=0 ; i < expected.length ; i++ ){
           assertEquals(expected[i], actual.getValueAtPosition(i));
       }
    }

    private void assertNextState(Integer[] expected, AllPossibleValuesEnumerator actual) {
        assertTrue(actual.moveToNextState());
        assertState(expected, actual);
    }
}
