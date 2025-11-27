package algorithmConcepts;

import algorithmConcepts.model.custom.ArrayListInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}
