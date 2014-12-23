/**
 * Created by sidrao on 12/22/14.
 * Implementation of a resizing array queue of Strings.
 */
public class ResizingArrayQueueOfStrings {
    private String[] queue;
    private int currentSize;
    private int first;
    private int last;

    //Constructor
    public ResizingArrayQueueOfStrings() {
        queue = new String[1];
    }

    public void enqueue(String item) {
        if (currentSize == queue.length) {
            resizeQueue(queue.length * 2);
        }
        queue[currentSize++] = item;
    }

    private void resizeQueue(int size) {
        String[] result = new String[size];
        int indexForNewQueue = 0;
        for (int i = first; i < first + queue.length; i++) {
            int loopedIndex = i % queue.length;
            result[indexForNewQueue++] = queue[loopedIndex];
        }
        queue = result;
    }

    public String dequeue() {
        if (currentSize)

        String result = queue[first];
        first = (first + 1) % queue.length;
    }
}
