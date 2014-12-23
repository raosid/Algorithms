/**
 * Created by sidrao on 12/22/14.
 * Linked list implementation of a Queue
 *
 */
public class LinkedQueueOfStrings {
    private Node first;
    private Node last;

    //Inner class representing a node in the linked list.
    private class Node {
        String item;
        Node next;
    }

    /*
        Enqueue.
        Takes care if adding to an empty list.
     */
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    /*
        Dequeue.
        Returns the String dequeued the most recent.
     */
    public String dequeue() {
        String result = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return result;
    }

    /*
        Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (first == null);
    }
}