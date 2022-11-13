package org.example;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
    private Integer lhs = null;
    private Integer rhs = null;
    private boolean hasInvalidDivision = false;

    public Evaluator(Integer v1, Operation o1, Integer v2, Operation o2, Integer v3, Operation o3, Integer v4) {
        List<Integer> values = new ArrayList<Integer>();
        values.add(v1);
        values.add(v2);
        values.add(v3);
        values.add(v4);

        List<Operation> operations = new ArrayList<Operation>();
        operations.add(o1);
        operations.add(o2);
        operations.add(o3);

        evaluateAll(values, operations);
    }

    private void evaluateAll(List<Integer> values, List<Operation> operations) {
        List<Integer> valuesForLhs = new ArrayList<Integer>();
        List<Integer> valuesForRhs = new ArrayList<Integer>();
        List<Operation> operationsForLhs = new ArrayList<Operation>();
        List<Operation> operationsForRhs = new ArrayList<Operation>();

        boolean isReadingForLhs = true;

        for (int i=0 ; i < values.size() ; i++) {
            if (isReadingForLhs) {
                valuesForLhs.add(values.get(i));
            } else {
                valuesForRhs.add(values.get(i));
            }

            if (operations.size() == i){
                break;
            }
            if (operations.get(i).equals(Operation.EQUALS)) {
                isReadingForLhs = false;
            } else {
                if (isReadingForLhs) {
                    operationsForLhs.add(operations.get(i));
                } else {
                    operationsForRhs.add(operations.get(i));
                }
            }
        }

        try {
            lhs = evaluate(valuesForLhs, operationsForLhs);
            rhs = evaluate(valuesForRhs, operationsForRhs);
        } catch (InvalidDivisionException e) {
            hasInvalidDivision = true;
        }
    }

    private Integer evaluate(List<Integer> values, List<Operation> operations) throws InvalidDivisionException {
        Integer buffer = values.get(0);
        return evaluateNext(buffer, 0, values, operations);
    }

    private Integer evaluateNext(Integer buffer, Integer idx, List<Integer> values, List<Operation> operations) throws InvalidDivisionException {
        if (idx == operations.size()) {
            return buffer;
        }
        Integer nextValue = values.get(idx+1);
        switch (operations.get(idx)) {
            case ADD:
                return evaluateNext(buffer + nextValue, idx+1, values, operations);
            case SUB:
                return evaluateNext(buffer - nextValue, idx+1, values, operations);
            case DIVIDE:
                int remainder = buffer % nextValue;
                if (remainder != 0) {
                    throw new InvalidDivisionException();
                }
                return evaluateNext(buffer / nextValue, idx+1, values, operations);
            case MULT:
                return evaluateNext(buffer * nextValue, idx+1, values, operations);
            default:
                throw new RuntimeException("Was not expecting operation " + operations.get(idx));
        }
    }

    public Integer lhs() {
        return lhs;
    }

    public Integer rhs() {
        return rhs;
    }

    public boolean hasInvalidDivision() {
        return hasInvalidDivision;
    }

    public boolean isValid() {
        return !hasInvalidDivision && lhs.equals(rhs);
    }

    private class InvalidDivisionException extends Exception {}
}
