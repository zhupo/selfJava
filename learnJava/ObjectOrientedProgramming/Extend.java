package ObjectOrientedProgramming;

public class Extend extends Person {
    public Extend(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    private int score;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String hello() {
        return "Hello, " + super.name;
    }
}
