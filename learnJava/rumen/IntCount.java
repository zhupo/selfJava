package rumen;

public class IntCount {
    public static void main(String[] args) {
        int n = 100;
        int sum = ((1 + n) * n) / 2;
        System.out.println(sum);
        System.out.println(sum == 5050 ? "success" : "failed");
    }
}
