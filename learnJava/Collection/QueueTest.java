package Collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    //int size()：获取队列长度；
    //boolean add(E)/boolean offer(E)：添加元素到队尾；
    //E remove()/E poll()：获取队首元素并从队列中删除；
    //E element()/E peek()：获取队首元素但并不从队列中删除。
    public void run() {
        //1,功能	2, throw Exception	3,返回false或null
        //添加元素到队尾	add(E e)	boolean offer(E e)
        //取队首元素并删除	E remove()	E poll()
        //取队首元素但不删除	E element()	E peek()
        //要避免把null添加到队列。
        Queue<String> queue = new LinkedList<>();

        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");
        this.peek(queue);
        this.poll(queue);
    }

    public void peek(Queue<String> queue) {
        //从队列中取出但不删除
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }

    public void poll(Queue<String> queue) {
        //从队列中取出元素并删除
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
