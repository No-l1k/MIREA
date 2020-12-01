package lab_10;

import java.util.ArrayList;

public class MyArrayList<T> {
    private final int max_size;
    private ArrayList<T> data;

    MyArrayList(int size) throws IllegalArgumentException {
        data = new ArrayList<>(size);
        max_size = size;
    }

    public void addElement(T element) throws ArrayIndexOutOfBoundsException {
        if (data.size()+1 > max_size)
            throw new ArrayIndexOutOfBoundsException("Can't add element, " +
                    "no more space");
        data.add(element);
    }

    T getElement(int index) throws IndexOutOfBoundsException {
        return data.get(index);
    }
}