package org.tel.ran._2025_04_15.mainClass;

import java.util.Arrays;

public class DynamicArray<D> {
    private D[] data;
    private int currentLength;

    public DynamicArray() {
        data = (D[]) new Object[10];
    }

    public void add(D dataToAdd) {
        if (currentLength != data.length) {
            data[currentLength] = dataToAdd;
            currentLength++;
        } else {
            growArray();
            add(dataToAdd);
        }
    }

    public D remove(int index) {
        checkIndex(index);
        D removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, currentLength - index - 1);
        data[currentLength - 1] = null;
        currentLength--;
        return removedElement;
    }

    public boolean remove(D element) {
        for (int i = 0; i < currentLength; i++) {
            if (data[i] == element) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    public D get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 && index > currentLength) {
            throw new RuntimeException("Index " + index + " is out of bounds. The largest index of this list is " + (currentLength - 1) + ".");
        }
    }

    private void growArray() {
        data = Arrays.copyOf(data, data.length * 3 / 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
