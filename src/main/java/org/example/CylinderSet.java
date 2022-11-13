package org.example;

import java.util.ArrayList;
import java.util.List;

public class CylinderSet {
    private List<Cylinder<Integer>> values = new ArrayList<>();
    private List<Cylinder<Operation>> operations = new ArrayList<>();

    private AllPossibleValuesEnumerator valuesRotationsEnumerator = new AllPossibleValuesEnumerator(4, 4);
    private AllPossibleValuesEnumerator operationSRotationsEnumerator = new AllPossibleValuesEnumerator(3, 4);
    private AllPermutationsEnumerator valuesPositionsEnumerator = new AllPermutationsEnumerator(4);
    private AllPermutationsEnumerator operationPositionsEnumerator = new AllPermutationsEnumerator(3);

    public CylinderSet(Cylinder<Integer> cv0, Cylinder<Integer> cv1, Cylinder<Integer> cv2, Cylinder<Integer> cv3, Cylinder<Operation> co0, Cylinder<Operation> co1, Cylinder<Operation> co2) {
        values.add(cv0);
        values.add(cv1);
        values.add(cv2);
        values.add(cv3);

        operations.add(co0);
        operations.add(co1);
        operations.add(co2);
    }

    public boolean moveToNextState() {
       if (valuesRotationsEnumerator.moveToNextState()) {
           return true;
       }
       valuesRotationsEnumerator = new AllPossibleValuesEnumerator(4, 4);
       if (operationSRotationsEnumerator.moveToNextState()) {
           return true;
       }
       operationSRotationsEnumerator = new AllPossibleValuesEnumerator(3, 4);
       if (valuesPositionsEnumerator.moveToNextState()) {
           return true;
       }
       valuesPositionsEnumerator = new AllPermutationsEnumerator(4);
       if (operationPositionsEnumerator.moveToNextState()) {
           return true;
       }
       return false;
    }

    public Integer getValue(int idxCylinder, int idxSide) {
        return values.get(valuesPositionsEnumerator.getValueAtPosition(idxCylinder))
                .getSide(valuesRotationsEnumerator.getValueAtPosition(idxCylinder), idxSide);
    }

    public Operation getOperation(int idxCylinder, int idxSide) {
        return operations.get(operationPositionsEnumerator.getValueAtPosition(idxCylinder))
                .getSide(operationSRotationsEnumerator.getValueAtPosition(idxCylinder), idxSide);
    }

    public boolean isValid() {
        for (int side=0 ; side < 4 ; side++ ){
            if ( ! new Evaluator(getValue(0, side),
                    getOperation(0, side),
                    getValue(1, side),
                    getOperation(1, side),
                    getValue(2, side),
                    getOperation(2, side),
                    getValue(3, side))
                    .isValid()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String out = "";
        for (int side=0 ; side < 4 ; side++ ){
            out += getValue(0, side).toString() +
                    getOperation(0, side) +
                    getValue(1, side) +
                    getOperation(1, side) +
                    getValue(2, side) +
                    getOperation(2, side) +
                    getValue(3, side) +
                    "\n";
        }
        return out;
    }
}
