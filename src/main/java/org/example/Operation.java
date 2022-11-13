package org.example;

public enum Operation {
    ADD {
        @Override
        public String toString() {
            return "+";
        }
    },
    SUB {
        @Override
        public String toString() {
            return "-";
        }
    },
    MULT {
        @Override
        public String toString() {
            return "*";
        }
    },
    DIVIDE {
        @Override
        public String toString() {
            return "/";
        }
    },
    EQUALS {
        @Override
        public String toString() {
            return "=";
        }
    }
}
