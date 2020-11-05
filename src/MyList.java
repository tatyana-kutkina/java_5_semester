import java.util.*;

public class MyList implements List {

    Object[] listArray;
    int maxSize;
    int currentSize;
    private static final int defaultSize = 20;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
        listArray = new Object[maxSize];
        currentSize = 0;
    }

    public MyList() {
        this(defaultSize);
    }


    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }


    @Override
    public boolean add(Object o) {
        if (currentSize >= maxSize) {
            return false;
        }
        listArray[currentSize++] = o;
        return true;
    }


    @Override
    public void add(int i, Object o) {
        if (i >= maxSize) {
            throw new IndexOutOfBoundsException("Index is greater than maximum allowable size");
        }
        if (currentSize >= maxSize) {
            throw new IndexOutOfBoundsException("There is no space to add new element");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (currentSize == i) {
            listArray[currentSize++] = o;
        } else {
            for (int j = currentSize; j > i; j--) {
                listArray[j] = listArray[j - 1];
            }
            listArray[i] = o;
            currentSize++;
        }

    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < currentSize; i++) {
            if (listArray[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object get(int i) {
        if (i >= currentSize || i < 0) {
            throw new NoSuchElementException("Element with this index doesn't exist in the list");
        }
        return listArray[i];
    }


    @Override
    public Object remove(int i) {
        if (i >= currentSize || i < 0) {
            throw new NoSuchElementException("Element with this index doesn't exist in the list");
        }
        Object object = listArray[i];
        for (int j = i; j < currentSize - 1; j++) {
            listArray[j] = listArray[j + 1];
        }
        currentSize--;
        return object;
    }

    @Override
    public int size() {
        return currentSize;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }
}
