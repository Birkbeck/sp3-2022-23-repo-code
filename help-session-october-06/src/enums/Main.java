package enums;

class Main {
    // private final static int CONSTANT = 30;

    public static void main(String[] args) {
        System.out.println(Constants.MIN);
        Constants con = Constants.NORMAL;
        switch (con) {
            case MIN -> System.out.println("Min");

            // fall through
            case NORMAL, MAX -> System.out.println("Normal or Max");
            default -> System.out.println("Error!");
        }
    }

    enum Constants {
        MIN, NORMAL, MAX
    }

    // Differences between classes and enums

    /*
     *
     * The main difference is that enum constants
     * are public, static and final
     */

    enum Colors {
        BLUE, RED, YELLOW
    }
}