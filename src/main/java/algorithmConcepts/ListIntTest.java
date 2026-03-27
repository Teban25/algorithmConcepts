package algorithmConcepts;

import algorithmConcepts.model.custom.ArrayListInt;
import algorithmConcepts.model.custom.LinkedListInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListIntTest {


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
        LinkedListInt linkedList1 = new LinkedListInt();
        // WHEN
        list.add(2);
        list.add(10);
        list.add(25);
        list.add(7);
        list.add(11);
        list.add(9);
        list.insert(2, 3);

        linkedList1.add(2);
        linkedList1.add(10);
        linkedList1.add(25);
        linkedList1.add(7);
        linkedList1.add(11);
        linkedList1.add(9);
        linkedList1.insert(2, 3);
        // THEN
        list.print();
        linkedList1.print();
        assertEquals(7, linkedList1.size());
        assertEquals(5, list.search(11));
        assertEquals(-1, list.search(1));
        assertEquals(67, list.sum());
        assertEquals(-1, emptyList.max());
        assertEquals(-1, emptyList.min());
        assertEquals(25, list.get(list.max()));
        assertEquals(2, list.get(list.min()));
        list.swap(1,4);
        list.swap(7,8);
        assertEquals(10, list.get(4));
        list.remove(5);
        assertEquals(6, list.size());
    }

    @Test
    public void testThatCheckUnsortedAndSortedArrays() {
        // GIVEN
        ArrayListInt unsortedList = new ArrayListInt();
        ArrayListInt sortedList = new ArrayListInt(true);
        // WHEN
        unsortedList.add(10);
        unsortedList.add(3);
        unsortedList.add(5);
        unsortedList.add(2);

        sortedList.add(10);
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(2);
        sortedList.add(7);
        // THEN
        assertEquals(4, unsortedList.size());
        assertEquals("10,3,5,2", unsortedList.toString());
        assertEquals("2,3,5,7,10", sortedList.toString());
    }

    @Test
    public void testThatDeleteOccurrencesOfD() {
        ArrayListInt list = new ArrayListInt();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);
        list.deleteOccurrencesOfD(3);
        assertEquals("2,5,7,8,4", list.toString());
    }

    @Test
    public void testThatDeleteRepeatedElementsUsingExtraSpace() {
        ArrayListInt list = new ArrayListInt(true);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);
        list.deleteAllRepeatedElementsInSortedArrayUsingExtraSpace();
        assertEquals("2,3,4,5,7,8", list.toString());
    }

    @Test
    public void testThatDeleteRepeatedElements() {
        ArrayListInt list = new ArrayListInt(true);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);
        list.deleteAllRepeatedElements();
        assertEquals("2,3,4,5,7,8", list.toString());
    }

    @Test
    public void testLinkedLists() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);

        linkedList1.insert(0,5);
        linkedList1.insert(2,7);
        linkedList1.insert(11,10);
        linkedList1.print();
        assertEquals(6, linkedList1.size());
        System.out.println(linkedList1);
    }

    @Test
    public void testLinkedListMethods() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);
        linkedList1.add(10);
        linkedList1.add(25);
        linkedList1.add(7);
        linkedList1.add(11);
        linkedList1.add(9);
        LinkedListInt linkedList2 = new LinkedListInt(true);
        linkedList2.add(25);
        linkedList2.add(7);
        linkedList2.add(11);
        linkedList2.add(9);
        linkedList2.add(24);
        linkedList2.add(28);

        assertEquals(3, linkedList1.search(7));
        assertEquals(-1, linkedList1.search(201));
        assertEquals(64, linkedList1.sum());
        assertEquals(6, linkedList2.size());
        linkedList2.print();
        assertEquals(1, linkedList2.search(9));
        assertEquals(0, linkedList2.search(7));
    }

    @Test
    public void testToRemoveElements1() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);
        linkedList1.add(5);
        linkedList1.add(20);
        linkedList1.add(8);

        linkedList1.remove(2);
        linkedList1.print();
    }

    @Test
    public void testToRemoveElements2() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);
        linkedList1.add(5);
        linkedList1.add(20);
        linkedList1.add(8);

        linkedList1.remove(0);
        linkedList1.print();
    }

    @Test
    public void testToRemoveElements3() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);
        linkedList1.add(5);
        linkedList1.add(20);
        linkedList1.add(8);

        linkedList1.remove(3);
        linkedList1.print();
    }

    @Test
    public void testToRemoveElements4() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(2);

        linkedList1.remove(0);
        linkedList1.print();
        linkedList1.add(5);
        linkedList1.add(20);
        linkedList1.add(8);
        linkedList1.print();
    }

    @Test
    public void testToRemoveOccurrencesOfDInLinkedList() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(3);
        linkedList1.add(8);
        linkedList1.add(3);
        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.add(3);

        linkedList1.print();

        linkedList1.deleteOccurrencesOfD(3);
        linkedList1.print();
        assertEquals(3, linkedList1.size());
    }

    @Test
    public void testSwapNodesLinkedList() {
        LinkedListInt linkedList1 = new LinkedListInt();
        linkedList1.add(3);
        linkedList1.add(8);
        linkedList1.add(3);
        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.add(11);

        linkedList1.print();
        linkedList1.swap(0,5);
        assertEquals(11, linkedList1.get(0));
        linkedList1.print();
        linkedList1.swap(1,4);
        assertEquals(6, linkedList1.get(1));
        linkedList1.print();
        linkedList1.swap(0,4);
        assertEquals(8, linkedList1.get(0));
        linkedList1.print();
        linkedList1.swap(1, 5);
        assertEquals(6, linkedList1.get(5));
        linkedList1.print();
        linkedList1.swap(2,4);
        assertEquals(11, linkedList1.get(2));
        linkedList1.print();
        linkedList1.swap(2,3);
        assertEquals(11, linkedList1.get(3));
        linkedList1.print();
        linkedList1.swap(0,1);
        assertEquals(3, linkedList1.get(0));
        linkedList1.print();

        LinkedListInt linkedList2 = new LinkedListInt();
        linkedList2.add(3);
        linkedList2.add(8);

        linkedList2.swap(0,1);
        assertEquals(8, linkedList2.get(0));
        linkedList2.print();
    }
    @Test
    public void testSelectionSort() {
        ArrayListInt list = new ArrayListInt();

        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);

        list.sortBySelection(false);
        assertEquals("2,3,3,3,3,4,5,7,8", list.toString());


    }

    @Test
    public void testSelectByBubble() {
        ArrayListInt list = new ArrayListInt();

        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);

        list.sortByBubble();
        assertEquals("2,3,3,3,3,4,5,7,8" , list.toString());

    }
    @Test
    public void sortBySelectionDesc() {
        ArrayListInt list = new ArrayListInt();

        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(4);

        list.sortBySelectionDesc();
        assertEquals("8,7,5,4,3,3,3,3,2" , list.toString());
    }
}
