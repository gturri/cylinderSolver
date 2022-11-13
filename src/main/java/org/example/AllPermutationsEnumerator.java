package org.example;

public class AllPermutationsEnumerator implements IEnumerator {
    private final int nbElements;
    private AllPermutationsEnumerator innerEnumerator;
    private int idxHighestElement = 0;

    public AllPermutationsEnumerator(int nbElements) {
        this.nbElements = nbElements;
        if (nbElements > 1 ){
            innerEnumerator = new AllPermutationsEnumerator(nbElements-1);
        }
    }

    @Override
    public boolean moveToNextState() {
        if (nbElements == 1) {
            return false;
        }
        if (!innerEnumerator.moveToNextState()) {
            if (idxHighestElement < nbElements - 1) {
                idxHighestElement++;
                innerEnumerator = new AllPermutationsEnumerator(nbElements-1);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer getValueAtPosition(int idx) {
        if (nbElements == 1) {
            return 0;
        }
        if (idx < idxHighestElement) {
            return innerEnumerator.getValueAtPosition(idx);
        } else if (idx == idxHighestElement) {
            return nbElements - 1;
        } else {
            return innerEnumerator.getValueAtPosition(idx-1);
        }
    }
}
