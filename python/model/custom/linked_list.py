class Node:

    def __init__(self , data):
        self.data= data
        self.next =None

class LinkedList:
    def __init__(self):
        self.head=None
        self.tail= None
        self.size = 0

    def __str__(self):
        elements = ""
        current = self.head
        while current is not None:
            elements = elements + " " + str(current.data)
            current = current.next

        return elements

    def add_unsorted (self, data):
        new_node = Node(data)

        if self.head is None:
            self.head= self.tail = new_node

        else:
            self.tail.next = new_node
            self.tail = new_node














        
