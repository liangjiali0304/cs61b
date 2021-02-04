import java.util.LinkedList;
import java.util.NoSuchElementException;

public interface Deque<Sometype> {

    void addFirst(Sometype item);

    void addLast(Sometype item);

    default boolean isEmpty() {
        return this.size() == 0;
    }

    int size();

    void printDeque();

    Sometype removeFirst();

    Sometype removeLast();

    Sometype get(int index);


}
