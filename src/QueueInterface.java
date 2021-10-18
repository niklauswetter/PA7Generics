public interface QueueInterface<T>
{
    void enqueue(T o);

    T dequeue();

    T peek();

    boolean isEmpty();

    int size();

    void clear();

}
