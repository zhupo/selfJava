package rumen;

public class Command {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
            if ("-version".equals(arg)) {
                System.out.println("v 1.0");
                break;
            }
        }
    }
}
