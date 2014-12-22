/**
 * Created by sidrao on 12/22/14.
 *
 * Implementation of a Stack using Resizing Arrays.
 * Total time would be smaller than using Linked Lists
 * since no time wasted for links.
 * Amortized constant time
 * Worst Case for push/pop --> N
 * Would not be a good idea to use this implementation
 * if the client cares about every operation to be fast.
 * Example: Dealing with data packets.
 */

public class ResizingArrayStackOfStrings {
    private String[] stack;
    private int currentPosition;


    //Constructor
    public ResizingArrayStackOfStrings() {
        stack = new String[1];
        currentPosition = 0;
    }

    /*
        Push.
        item(String): Item to be pushed to the stack.

     */
    public void push(String item) {
        if (currentPosition == stack.length) {
            resizeStack(stack.length * 2);
        }
        stack[currentPosition++] = item;
    }

    /*
        Pop operation.
        Throws an illegal argument operation if the stack
        is empty.
     */
    public String pop() {
        if (currentPosition == 0) {
            throw new IllegalStateException("Queue Empty");
        }
        if (currentPosition > 0 && currentPosition == (stack.length / 4)) {
            resizeStack(stack.length / 2);
        }
        String result = stack[--currentPosition];
        stack[currentPosition] = null; //Avoids loitering of data.
        return result;
    }

    /*
        Private method that would resize the stack.
        size: The new size of the stack.
     */
    private void resizeStack(int size) {
        String[] newStack = new String[size];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    /*
        Returns if the stack is empty
     */
    public boolean isEmpty() {
        return (currentPosition == 0);
    }

    /*
        Overrides the toString method.
     */
    public String toString() {

        if (currentPosition != 0) {
            String result = "[" + stack[0]; //Fencepost
            for (int i = 1; i < currentPosition; i++) {
                result += ", " + stack[i];
            }
            return result + "]";
        } else {
            return "[]";
        }

    }
}
