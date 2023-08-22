package Collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackTest {
    public void run() {
        //在Java中，我们用Deque可以实现Stack的功能：
        //
        //把元素压栈：push(E)/addFirst(E)；
        //把栈顶的元素“弹出”：pop()/removeFirst()；
        //取栈顶元素但不弹出：peek()/peekFirst()。
        //注意只调用push()/pop()/peek()方法

        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    public String toHex(int n) {
//        Deque<Integer> stack = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        int divisor = 16;
        while (n > 0) {
            int remainder = n % divisor;
            char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder -10 + 'A');
            n = n / divisor;
            stack.push(hexDigit);
        }
        StringBuilder hexadecimalBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            hexadecimalBuilder.append(stack.pop());
        }

        return hexadecimalBuilder.toString();
    }
}
