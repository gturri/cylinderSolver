package org.example;

public class Main {
    public static void main(String[] args) {
        CylinderSet set = new CylinderSet(
                new Cylinder<Integer>(1, 2, 3, 4),
                new Cylinder<Integer>(2, 3, 4, 1),
                new Cylinder<Integer>(3, 4, 1, 2),
                new Cylinder<Integer>(4, 1, 2, 3),
                new Cylinder<Operation>(Operation.ADD, Operation.MULT, Operation.DIVIDE, Operation.SUB),
                new Cylinder<Operation>(Operation.MULT, Operation.DIVIDE, Operation.SUB, Operation.ADD),
                new Cylinder<Operation>(Operation.EQUALS, Operation.EQUALS, Operation.EQUALS, Operation.EQUALS));


        int nbIterations = 0;
        if (set.isValid()) {
            System.out.println(set);
        }
        while (set.moveToNextState()) {
            nbIterations++;
            if (nbIterations % 100000 == 0) {
                System.out.println(nbIterations);
            }
            if (set.isValid()) {
                System.out.println(set);
            }
        }

        System.out.println("DONE");
    }
}