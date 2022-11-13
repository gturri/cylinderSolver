package org.example;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleValuesEnumerator implements IEnumerator {
    private int valueMax;

    private List<Integer> state = new ArrayList<>();

    public AllPossibleValuesEnumerator(int nbCells, int valueMax) {
        this.valueMax = valueMax;

        for (int i=0 ; i < nbCells ; i++ ){
            state.add(0);
        }
    }

    @Override
    public boolean moveToNextState() {
        for ( int i=0 ; i < state.size() ; i++ ) {
            if (state.get(i) < valueMax-1 ) {
                state.set(i, state.get(i) + 1);
                return true;
            }
            state.set(i, 0);
        }
        return false;
    }

    @Override
    public Integer getValueAtPosition(int idx) {
        return state.get(idx);
    }
}
