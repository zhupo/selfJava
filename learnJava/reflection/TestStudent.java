package reflection;

public class TestStudent extends TestPerson {
    public int score;
    private  int grade;

    public TestStudent(int age, String name) {
        super(age, name);
    }

    public TestStudent(int age, String name, int grade) {
        super(age, name);
        this.grade = grade;
    }

    public int getScore(String type) {
        return 99;
    }

    private  int getGrade(int year) {
        return 1;
    }

    public void hello() {
        System.out.println("student:hello");
    }
}
