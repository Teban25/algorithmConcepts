package algorithmConcepts;

import algorithmConcepts.model.custom.ArrayListInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListIntTest {


    @Test
    public void initializeAndCheckSizeOfCustomArrayListInt() {
        // GIVEN
        ArrayListInt list = new ArrayListInt();
        // WHEN
        int size = list.size();
        // THEN
        assertEquals(0, size);
    }

    @Test
    public void addANewElementToTheArray() {
        // GIVEN
        ArrayListInt list = new ArrayListInt();
        //WHEN
        list.add(2);
        list.add(10);
        list.add(25);
        //THEN
        assertEquals(3, list.size());
        assertEquals(2, list.get(0));
        assertEquals(25, list.get(2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void severalCommandsInTraditionalApproaches() {
        // GIVEN
        ArrayListInt list = new ArrayListInt();
        ArrayListInt emptyList = new ArrayListInt();
        // WHEN
        list.add(2);
        list.add(10);
        list.add(25);
        list.add(7);
        list.add(11);
        list.add(9);
        // THEN
        list.print();
        assertEquals(4, list.search(11));
        assertEquals(-1, list.search(1));
        assertEquals(64, list.sum());
        assertEquals(-1, emptyList.max());
        assertEquals(-1, emptyList.min());
        assertEquals(25, list.get(list.max()));
        assertEquals(2, list.get(list.min()));
        list.swap(1, 4);
        assertEquals(10, list.get(4));
    }
}
