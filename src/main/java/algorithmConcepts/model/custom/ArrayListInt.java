package algorithmConcepts.model.custom;

public class ArrayListInt {

    private Integer[] elements;
    private int size;
    private final boolean isSorted;

    public ArrayListInt() {
        elements = new Integer[10];
        size = 0;
        isSorted = false;
    }

    public ArrayListInt(boolean isSorted) {
        elements = new Integer[10];
        size = 0;
        this.isSorted = isSorted;
    }

    public ArrayListInt(int initialCapacity) {
        if (initialCapacity < 100000) {
            elements = new Integer[initialCapacity];
        } else {
            elements = new Integer[100000];
        }
        size = 0;
        isSorted = false;
    }

    public ArrayListInt(int initialCapacity, boolean isSorted) {
        if (initialCapacity < 100000) {
            elements = new Integer[initialCapacity];
        } else {
            elements = new Integer[100000];
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

    private void checkCapacity() {
        if (size == elements.length) {
            incrementCapacity();
        }
    }

    public void add(int element) {
        if (isSorted) {
            addSorted(element);
        } else {
            addUnsorted(element);
        }
    }

    private void addSorted(int element) {
        checkCapacity();
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
        checkCapacity();
        elements[size++] = element;
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + ", Insertion out of bounds!");
        }
        checkCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = data;
        size++;
    }

    public void incrementCapacity() {
        Integer[] aux = elements;
        elements = new Integer[elements.length * 2];
        System.arraycopy(aux, 0, elements, 0, size);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return elements[index];
    }

    public void print() {
        System.out.println("ArrayList Elements:");
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
        int indexFound = 0;
        while(indexFound < size && elements[indexFound] != value) {
            indexFound = indexFound + 1;
        }
        return indexFound == size ? -1 : indexFound;
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
        Integer[] auxElements = new Integer[elements.length];
        int indexForAux = 0;
        int sizeUpdated = 0;
        for (int i = 0; i < size - 1; i++) {
            if (!elements[i + 1].equals(elements[i])) {
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
        for (int i = 0; i < size -1; i++) {
            if ((i  == size - 1) || (!elements[i].equals(elements[i + 1]))) {
                elements[writeIndex++] = elements[i];
            }
        }
        for (int i = writeIndex + 1; i < size; i++) {
            elements[i] = 0;
        }
        size = writeIndex;
    }

    public void sortBySelection(boolean desc) {
        if(desc) {
            sortBySelectionDesc();
        }else {
            sortBySelectionAsc();
        }
    }

    public void sortBySelectionDesc() {
        for (int i = 0; i < size - 1; i++) {
            int maxValue = i;
            for(int j = i + 1; j < size ; j++) {
                if (elements[j] > elements[maxValue]) {
                    maxValue = j;
                }
            }
            int aux = elements[maxValue];
            elements[maxValue] = elements[i];
            elements[i] = aux;
        }
    }

    public void sortBySelectionAsc() {
        for (int i = 0; i < size - 1; i++) {
            int minValue = i;
            for(int j = i + 1; j < size ; j++) {
                if (elements[j] < elements[minValue]) {
                    minValue = j;
                }
            }
            int aux = elements[minValue];
            elements[minValue] = elements[i];
            elements[i] = aux;
        }
    }

    public void sortByBubble() {
        boolean changed;
        for (int i = 0; i < size - 1 ; i++) {
            changed = false;
            for ( int j = 0; j < size - 1 ; j++) {
                if (elements[j + 1] < elements[j]) {
                    int aux = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = aux;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
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
