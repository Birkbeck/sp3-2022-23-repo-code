package inner;

// inner classes exist for encapsulation purposes

// The four key tents of OOP:
//
// encapsulation
//     - hiding the implementation and functionality not required externally
// message passing
//     - passing messages betweek objects
// inheritance
//     - single or multiple 
// polymorphism
//     - ad-hoc or parametric

public class Main {
    public void main(String... args) {
        LinkedList l = new LinkedList();
        l.add(10);
        System.out.println(l);
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int i) {
        Node temp = new Node(i);
        Node start = head;
        while (start != null) {
            start = start.next;
        }
        start = temp;
    }

    private class Node { // nested or inner class
        private int value;
        private Node next;

        Node(int i) {
            value = i;
            next = null;
        }
    }
}
