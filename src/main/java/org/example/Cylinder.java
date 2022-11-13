package org.example;

import java.util.ArrayList;
import java.util.List;

class Cylinder<T> {
    private List<T> values;

    public Cylinder(T v1, T v2, T v3, T v4) {
        values = new ArrayList<T>();
        values.add(v1);
        values.add(v2);
        values.add(v3);
        values.add(v4);
    }

    public T getSide(int nbRotations, int idxSide) {
        return values.get((nbRotations + idxSide) % values.size());
    }
}