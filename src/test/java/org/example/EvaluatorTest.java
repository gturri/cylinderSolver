package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluatorTest {
    @Test
    public void evaluateWithAddAndEqualsInTheMiddle() {
        Evaluator sut = new Evaluator(1, Operation.ADD, 2, Operation.EQUALS, 3, Operation.ADD, 4);
        assertEquals(3, sut.lhs());
        assertEquals(7, sut.rhs());
        assertFalse(sut.hasInvalidDivision());
        assertFalse(sut.isValid());
    }

    @Test
    public void evaluateWithAddAndEqualsOnTheRight() {
        Evaluator sut = new Evaluator(1, Operation.ADD, 2, Operation.ADD, 3, Operation.EQUALS, 6);
        assertEquals(6, sut.lhs());
        assertEquals(6, sut.rhs());
        assertFalse(sut.hasInvalidDivision());
        assertTrue(sut.isValid());
    }

    @Test
    public void evaluateWithSubAndMultAndEqualsOnTheLeft() {
        Evaluator sut = new Evaluator(9, Operation.EQUALS, 9, Operation.SUB, 5, Operation.MULT, 2);
        assertEquals(9, sut.lhs());
        assertEquals(8, sut.rhs());
        assertFalse(sut.hasInvalidDivision());
        assertFalse(sut.isValid());
    }

    @Test
    public void evaluateWithValidDivisionAndEqualInTheMiddle() {
        Evaluator sut = new Evaluator(9, Operation.DIVIDE, 3, Operation.EQUALS, 8, Operation.DIVIDE, 2);
        assertEquals(3, sut.lhs());
        assertEquals(4, sut.rhs());
        assertFalse(sut.hasInvalidDivision());
        assertFalse(sut.isValid());
    }

    @Test
    public void evaluateWithValidDivisionAndEqualOnTheRight() {
        Evaluator sut = new Evaluator(9, Operation.SUB, 1, Operation.DIVIDE, 4, Operation.EQUALS, 2);
        assertEquals(2, sut.lhs());
        assertEquals(2, sut.rhs());
        assertFalse(sut.hasInvalidDivision());
        assertTrue(sut.isValid());
    }

    @Test
    public void evaluateWithInvalidDivision() {
        Evaluator sut = new Evaluator(9, Operation.DIVIDE, 4, Operation.EQUALS, 8, Operation.ADD, 2);
        assertTrue(sut.hasInvalidDivision());
        assertFalse(sut.isValid());
    }
}
