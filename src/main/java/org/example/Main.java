package org.example;

public class Main {
    public static void main(String[] args) {
        CylinderSet set = new CylinderSet(
                new Cylinder<Integer>(1, 2, 3, 4),
                new Cylinder<Integer>(5, 6, 7, 8),
                new Cylinder<Integer>(1, 3, 5, 7),
                new Cylinder<Integer>(2, 4, 6, 8),
                new Cylinder<Operation>(Operation.ADD, Operation.MULT, Operation.DIVIDE, Operation.SUB),
                new Cylinder<Operation>(Operation.ADD, Operation.ADD, Operation.DIVIDE, Operation.SUB),
                new Cylinder<Operation>(Operation.EQUALS, Operation.EQUALS, Operation.EQUALS, Operation.EQUALS));

        System.out.println(set);
        System.out.println(set.isValid());

        set.moveToNextState();
        System.out.println(set);
        System.out.println(set.isValid());

        System.out.println("DONE");
    }
}