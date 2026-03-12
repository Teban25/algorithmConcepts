package algorithmConcepts.model.custom;

import java.util.Objects;

public class LinkedListInt {

    private Node head;
    private Node tail;
    private int size;
    private final boolean IS_SORTED;

    public void initializeLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedListInt() {
        initializeLinkedList();
        IS_SORTED = false;
    }

    public LinkedListInt(boolean isSorted) {
        initializeLinkedList();
        IS_SORTED = isSorted;
    }

    public int size() {
        return size;
    }

    public void addUnsorted(int data){
        Node nodeToAdd =  new Node(data);
        if (head == null) {
            head = tail = nodeToAdd;
        } else {
            tail.next = nodeToAdd;
            tail = tail.next;
        }
        size++;
    }

    public void addSorted(int data){
        Node nodeToAdd =  new Node(data);
        if (head == null) {
            head = tail = nodeToAdd;
        } else {
            Node current = head;
            Node previous = null;
            while (current.data < data && current.next != null) {
                previous = current;
                current = current.next;
            }

            if (current == head) {
                nodeToAdd.next = head;
                head = nodeToAdd;
            } else if (current == tail && current.data < data) {
                current.next = nodeToAdd;
                tail = nodeToAdd;
            } else {
                nodeToAdd.next = current;
                previous.next = nodeToAdd;
            }
        }
        size++;
    }

    public void add(int data) {
        if (IS_SORTED) {
            addSorted(data);
        } else {
            addUnsorted(data);
        }
    }

    public void insert(int index, int data) {
        int position = 0;
        if(head !=  null) {
            Node current = head;
            while (position < index - 1 && current.next != null) {
                current = current.next;
                position++;
            }

            Node nodeInsert = new Node(data);
            if (current == head) {
                nodeInsert.next = head;
                head = nodeInsert;
            } else if (current == tail) {
                tail.next = nodeInsert;
                tail = nodeInsert;
            } else {
                nodeInsert.next = current.next;
                current.next = nodeInsert;
            }
            size++;
        } else {
            add(data);
        }
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + ", Get out of bounds!");
        }
        int position = 0;
        Node current = head;
        while (position < index) {
            current = current.next;
            position++;
        }
        return current.data;
    }

    public void print() {
        Node current = head;
        System.out.println("LinkedList:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void remove (int index) {
        Node current = head;

        if( index >= size ) {
            index = size - 1;
        }

        int position = 0;
        while (position < index - 1 && current.next != null) {
            current = current.next;
            position++;
        }

        if (current == head) {
            head = head.next;
            if (current == tail) {
                tail = head;
            }
        } else if (current.next == tail) {
            tail = current;
            tail.next = null;
        } else {
            Node nodeNext = current.next;
            if (nodeNext != null && nodeNext.next != null)
                current.next = nodeNext.next;
        }
        size--;
    }

    public void deleteOccurrencesOfD(int d){
        Node current = head;
        Node previous = null;

        while (current != null ){
            if(current.data == d ){
                if(current == head){
                  head = current.next;
                  size--;
                }
                else if(current == tail){
                    tail = previous;
                    tail.next = null;
                    size--;
                }
                else{
                    previous.next = current.next;
                    size--;
                }
            }
            previous = current;
            current = current.next;
        }



    }

    public void swap(int index1 , int index2) {
        if (index1 != index2) {

            if (index1 > index2) {
                int aux = index1;
                index1 = index2;
                index2 = aux;
            }

            if (index2 >= size) {
                index2 = size - 1;
            }

            if (index1 < 0) {
                index1 = 0;
            }

            Node current = head;
            Node previous1 = null;
            Node previous2 = head;
            Node nodeIndex1 = current;
            Node nodeIndex2 = tail;
            int currentIndex = 0;

            while(current != null && currentIndex < index1) {
                previous1 = current;
                current = current.next;
                nodeIndex1 = current;
                currentIndex++;
            }

            while(current != null && currentIndex < index2) {
                previous2 = current;
                current = current.next;
                nodeIndex2 = current;
                currentIndex++;
            }

            if (nodeIndex1 == head && nodeIndex2 == tail) {
              if(size == 2) {
                  tail.next = head;
                  head.next = null;
                  tail = nodeIndex1;
                  head = nodeIndex2;
              } else {
                  previous2.next = nodeIndex1;
                  nodeIndex2.next = nodeIndex1.next;
                  nodeIndex1.next = null;
                  head = nodeIndex2;
                  tail = nodeIndex1;
              }
            } else if (nodeIndex1 == head) {
                previous2.next = head;
                Node aux = nodeIndex2.next;
                nodeIndex2.next = head.next;
                head.next = aux;
                head = nodeIndex2;
            } else if (nodeIndex2 == tail) {
                previous2.next = nodeIndex1;
                Node aux = nodeIndex1.next;
                nodeIndex1.next = null;
                previous1.next = tail;
                tail.next = aux;
                tail = nodeIndex1;
            } else {
                previous1.next = nodeIndex2;
                previous2.next = nodeIndex1;
                Node aux = nodeIndex2.next;
                nodeIndex2.next = nodeIndex1.next;
                nodeIndex1.next = aux;
            }
        }
    }


    public int sum() {
        int sum = 0;
        Node node = head;

        while (node != null) {
            sum += node.data;
            node = node.next;
        }
        return sum;
    }

    public int max() {
        Node node = head;
        int max =0;
        while (node != null) {
            if (node.data > max) {
                max = node.data;
            }
            node = node.next;
        }
        return max;
    }

    public int search(int value) {
        Node current = head;
        int indexFound = 0;
        while (current != null && current.data != value) {
            indexFound++;
            current = current.next;
        }

        return indexFound == size ? -1 : indexFound;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            if (current.next != null) {
                sb.append(current.data).append(" ");
            }  else {
                sb.append(current.data);
            }

            current = current.next;
        }
        return sb.toString();
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }
}
