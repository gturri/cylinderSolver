package org.example;

public interface IEnumerator {
    /**
     * @return TRUE if we could move to the next state, or FALSE if we reached the end
     */
    boolean moveToNextState();

    Integer getValueAtPosition(int idx);
}
