package Generics;

public class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + "," + this.score;
    }

    @Override
    public int compareTo(Person o) {
        if (this.score > o.score) {
            return -1;
        } else if (this.score == o.score) {
            return 0;
        } else {
            return 1;
        }
//        return this.name.compareTo(o.name);
    }
}
