/**
 * Created by sidrao on 12/22/14.
 * Implementation of a Stack of Strings.
 * Linked list implementation.
 */
public class StackOfStrings {
    private Node first;

    //Private Inner class representing a Node
    private class Node {
        String item;
        Node next;
    }

    //Push
    public void push(String item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
    }

    //Pop. Throws illegalStateException if empty.
    public String pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue Empty!");
        }
        String result = first.item;
        first = first.next;
        return result;
    }

    //Returns true if Stack is empty.
    public boolean isEmpty() {
        return (first == null);
    }

    //Overrides toString
    public String toString() {
        Node current = first;
        //Fencepost
        String result = "[" + current.item;
        current = current.next;
        while(current != null) {
            result += ", " + current.item;
            current = current.next;
        }
        return result + "]";
    }
}
