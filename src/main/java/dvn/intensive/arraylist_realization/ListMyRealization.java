package dvn.intensive.arraylist_realization;

import java.util.Collection;

public interface ListMyRealization<E> {
    public boolean add(E element);

    public boolean addAll(E[] elements);

    public boolean addAll(Collection<? extends E> collection);

    public boolean addAll(ListMyRealization<E> listToAdd);

    public E get(int index) throws IndexOutOfBoundsException;

    public E remove(int index);

    public int size();

    boolean replace(int index, E element);
}
