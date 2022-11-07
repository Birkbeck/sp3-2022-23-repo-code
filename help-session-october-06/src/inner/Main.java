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

public final class Main {
    public void main(String... args) {
        LinkedList l = new LinkedList();
        l.add(10);
        System.out.println(l);
    }
}

final class LinkedList {
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

    private record Node(int value, Node next) { // nested or inner class
        Node(int i) {
            this(i, null);
        }
    }
}
