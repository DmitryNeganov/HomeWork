package dvn.intensive.arraylist_realization;

import java.util.Arrays;
import java.util.Collection;

public class ArrayListMyRealization<E> implements ListMyRealization<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementsOfInstance;
    private int capacity;
    private int size;


    /**Constructor without parameters
     */
    public ArrayListMyRealization() {
        this.elementsOfInstance = new Object[DEFAULT_CAPACITY];
    }

    /**Constructor with initial capacity parameter
     * @param capacity
     */
    public ArrayListMyRealization(int capacity) {
        this.capacity = capacity;
        this.elementsOfInstance = new Object[capacity];
    }

    /**Constructor with initial collection as a parameter
     * @param collection
     */
    public ArrayListMyRealization(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        size = array.length;
        this.capacity = array.length;
        if (size != 0) {
                elementsOfInstance = Arrays.copyOf(array, capacity, Object[].class);
        } else {
            elementsOfInstance = new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * @return - size of ArrayList
     */
    @Override
    public int size() {
        return size;
    }

    /**Add element to the end of ArrayList
     * @param element
     * @return true if it was added
     * @throws IndexOutOfBoundsException, if index is out of ArrayList size.
     */
    @Override
    public boolean add(E element) {
        checkCapacity(size + 1);
        elementsOfInstance[size++] = element;
        return true;
    }

    @Override
    public boolean addAll(E[] elements) {
        checkCapacity(size + elements.length);
        for (int i = 0; i < elements.length; i++) {
            elementsOfInstance[size++] = elements[i];
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        checkCapacity(size + collection.size());
        for (E element: collection) {
            elementsOfInstance[size++] = element;
        }
        return true;
    }

    @Override
    public boolean addAll(ListMyRealization<E> listToAdd) {
        checkCapacity(size + listToAdd.size());
        for (int i = 0; i < listToAdd.size(); i++) {
            elementsOfInstance[size++] = listToAdd.get(i);
        }
        return false;
    }

    /**Get element by index
     * @param index
     * @return element
     * @throws IndexOutOfBoundsException, if index is out of ArrayList size.
     */
    @Override
    public E get(int index) {
        checkOutOfIndexException(index);
        return (E) elementsOfInstance[index];
    }

    /**Remove element by index from array
     * @param index
     * @return removed element
     * @throws IndexOutOfBoundsException, if index is out of ArrayList size.
     */
    @Override
    public E remove(int index) {
        E elementToDelete = get(index);
        size--;
        for (int i = index; i < size; i++) {
            elementsOfInstance[i] = elementsOfInstance[i + 1];
        }
        return elementToDelete;
    }

    /** Replace element by newElement in index position
     * @param index
     * @param newElement
     * @return
     */
    @Override
    public boolean replace(int index, E newElement) {
        checkOutOfIndexException(index);
        elementsOfInstance[index] = newElement;
        return true;
    }

    private void checkOutOfIndexException(int index) throws IndexOutOfBoundsException{
        if (index + 1 > this.size) {
            throw new IndexOutOfBoundsException("Index " + index +" is more than array size " + size);
        }
    }

    private void checkCapacity(int neededCapacity) {
        if (neededCapacity >= this.capacity) {
            growCapacity(neededCapacity);
        }
    }

    private void growCapacity(int neededCapacity) {
        this.capacity += (capacity >> 1); //150% of the previous value of capacity
        if (neededCapacity > capacity) {
            capacity = neededCapacity;
        }
        elementsOfInstance = Arrays.copyOf(elementsOfInstance, capacity);
    }
}