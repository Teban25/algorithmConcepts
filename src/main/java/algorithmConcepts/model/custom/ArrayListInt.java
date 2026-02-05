package algorithmConcepts.model.custom;

public class ArrayListInt {

    private int[] elements;
    private int size;
    private final boolean isSorted;

    public ArrayListInt() {
        elements = new int[10];
        size = 0;
        isSorted = false;
    }

    public ArrayListInt(boolean isSorted) {
        elements = new int[10];
        size = 0;
        this.isSorted = isSorted;
    }

    public ArrayListInt(int initialCapacity) {
        if (initialCapacity < 100000) {
            elements = new int[initialCapacity];
        } else {
            elements = new int[100000];
        }
        size = 0;
        isSorted = false;
    }

    public ArrayListInt(int initialCapacity, boolean isSorted) {
        if (initialCapacity < 100000) {
            elements = new int[initialCapacity];
        } else {
            elements = new int[100000];
        }
        size = 0;
        this.isSorted = isSorted;
    }

    /*
        Python comparison
        def size():
            return size
     */
    public int size() {
        return size;
    }

    public void add(int element) {
        if (isSorted) {
            addSorted(element);
        } else {
            addUnsorted(element);
        }
    }

    private void addSorted(int element) {
        if (size == elements.length) {
            incrementCapacity();
        }
        // Find the position to insert the new element in a sorted way
        int indexToAdd = size;

        for (int i = 0; i < size; i++) {
            if (element < elements[i]) {
                indexToAdd = i;
                break;
            }
        }

        // Re-structure the array to move the elements after the new insertion
        for (int i = size; i > indexToAdd; i--) {
            elements[i] = elements[i - 1];
        }

        elements[indexToAdd] = element;
        size++;
    }

    private void addUnsorted(int element) {
        if (size == elements.length) {
            incrementCapacity();
        }
        elements[size++] = element;
    }

    public void incrementCapacity() {
        int[] aux = elements;
        elements = new int[elements.length * 2];
        System.arraycopy(aux, 0, elements, 0, size);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return elements[index];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
    /**
     * Algorithm Complex: O(n)
     * @param value, the element to search in the array
     * @return index of value found, otherwise -1
     */
    public int search(int value) {
        int i = 0;
        while(i < size && elements[i] != value) {
            i = i + 1;
        }
        return i == size ? -1 : i;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += elements[i];
        }
        return sum;
    }

    public int max() {
        int max = -1;
        if (size > 0) {
            max = 0;
            for (int i = 1; i < size; i++) {
                if (elements[i] > elements[max]) {
                    max = i;
                }
            }
        }
        return max;
    }

    public int min() {
        int min = -1;
        if (size > 0) {
            min = 0;
            for (int i = 1; i < size; i++) {
                if (elements[i] < elements[min]) {
                    min = i;
                }
            }
        }
        return min;
    }

    public void swap(int index1, int index2) {
        try {
            if (index1 >= size || index2 >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }

            int aux = elements[index1];
            elements[index1] = elements[index2];
            elements[index2] = aux;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.printf("ArrayIndexOutOfBoundsException: " +
                    "The indexes are out of bounds, please verify - Index1=%d; Index2=%d, but size=%d", index1, index2, size);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for(int j = index; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = 0;
        size--;
    }

    public void deleteOccurrencesOfD(int d) {
        int writeIndex = 0;
        for (int readIndex = 0; readIndex < size; readIndex++) {
            if (!(elements[readIndex] == d)) {
                elements[writeIndex++] = elements[readIndex];
            }
        }
        // Set the rest to null (optional, for clarity)
        int numberOfDeletedElements = size - writeIndex;
        while (writeIndex < size) {
            elements[writeIndex++] = 0;
        }
        size = size - numberOfDeletedElements;
    }

    public void deleteAllRepeatedElementsInSortedArrayUsingExtraSpace() {
        int[] auxElements = new int[elements.length];
        int indexForAux = 0;
        int sizeUpdated = 0;
        for (int i = 0; i < size - 1; i++) {
            if (elements[i + 1] != elements[i]) {
                auxElements[indexForAux] = elements[i];
                indexForAux++;
                sizeUpdated++;
            }
        }
        auxElements[indexForAux] = elements[size - 1];
        sizeUpdated++;
        elements = auxElements;
        size = sizeUpdated;
    }

    public void deleteAllRepeatedElements() {
        int writeIndex = 0;
        for (int i = 0; i < size; i++) {
            if ((i  == size - 1) || (elements[i] != elements[i + 1])) {
                elements[writeIndex++] = elements[i];
            }
        }
        for (int i = writeIndex + 1; i < size; i++) {
            elements[i] = 0;
        }
        size = writeIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        return sb.toString();
    }
}
