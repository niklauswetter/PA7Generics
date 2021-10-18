public interface StackInterface<T>
{
    void push(T o);

    T pop();

    T peek();

    boolean isEmpty();

    int size();

    void clear();

}
