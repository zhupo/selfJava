package Generics;

public class ManyPair<T, K> {
    //多个泛型类型
    private T first;

    private K last;

    public ManyPair(T first, K last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public K getLast() {
        return last;
    }
}
