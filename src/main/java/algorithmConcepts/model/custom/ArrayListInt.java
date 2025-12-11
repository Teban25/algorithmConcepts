package algorithmConcepts.model.custom;

public class ArrayListInt {

    private int[] elements;
    private int size;

    public ArrayListInt() {
        elements = new int[10];
        size = 0;
    }

    public ArrayListInt(int initialCapacity) {
        if (initialCapacity < 100000) {
            elements = new int[initialCapacity];
        } else {
            elements = new int[100000];
        }
        size = 0;
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
        if (size == elements.length) {
            int[] aux = elements;
            elements = new int[elements.length * 2];
            System.arraycopy(aux, 0, elements, 0, size);
        }
        elements[size++] = element;
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
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
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
        int aux = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = aux;
    }

    public void remove(int index) {

    }
}
