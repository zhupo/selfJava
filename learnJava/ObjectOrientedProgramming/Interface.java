package ObjectOrientedProgramming;

interface Interface {
    void run();
    String getName();

    default void runTwo() {
        System.out.println(getName() + " run");
    }
}
