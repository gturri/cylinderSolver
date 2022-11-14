package org.example;

public class Main {
    public static void main(String[] args) {
        CylinderSet set = new CylinderSet(
                new Cylinder<Integer>(1, 5, 8, 7),
                new Cylinder<Integer>(1, 3, 5, 2),
                new Cylinder<Integer>(0, 2, 9, 2),
                new Cylinder<Integer>(2, 4, 3, 3),
                new Cylinder<Operation>(Operation.ADD, Operation.ADD, Operation.SUB, Operation.SUB),
                new Cylinder<Operation>(Operation.ADD, Operation.MULT, Operation.DIVIDE, Operation.ADD));


        int nbIterations = 0;
        int nbSolutions = 0;
        if (set.isValid()) {
            nbSolutions++;
            System.out.println(set);
        }
        while (set.moveToNextState()) {
            nbIterations++;
            if (set.isValid()) {
                nbSolutions++;
                System.out.println(set);
            }
        }

        System.out.println("nb iterations: " + nbIterations);
        System.out.println("nbSolutions: " + nbSolutions);
        System.out.println("DONE");
    }
}