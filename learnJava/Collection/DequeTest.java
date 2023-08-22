package Collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public void run() {
        //功能    	Queue	Deque
        //添加元素到队尾	add(E e) / offer(E e)	addLast(E e) / offerLast(E e)
        //取队首元素并删除	E remove() / E poll()	E removeFirst() / E pollFirst()
        //取队首元素但不删除	E element() / E peek()	E getFirst() / E peekFirst()
        //添加元素到队首	无	addFirst(E e) / offerFirst(E e)
        //取队尾元素并删除	无	E removeLast() / E pollLast()
        //取队尾元素但不删除	无	E getLast() / E peekLast()

        //Deque是一个接口，它的实现类有ArrayDeque和LinkedList。

        //不推荐的写法
        LinkedList<String> d1 = new LinkedList<>();
        d1.offerLast("a");

        //推荐的写法
        Deque<String> d2 = new LinkedList<>();
        d2.offerLast("a");
        d2.offerLast("b");
        d2.offerFirst("c");
        System.out.println(d2);//c, a, b
        System.out.println(d2.pollFirst());//c
        System.out.println(d2.pollLast());//b
        System.out.println(d2.pollFirst());//a
        System.out.println(d2.pollFirst());//null
    }
}
