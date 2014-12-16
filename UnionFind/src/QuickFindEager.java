/**
 * Created by sidrao on 12/15/14.
 * Implementation of Quick Find. Eager approach.
 */
public class QuickFindEager {

    private int[] ids;

    /**
     * Constructor
     * Pre: N >= 0;
     * @param N The number of objects.
     */
    public QuickFindEager(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        }
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    /**
     *
     * @param num1 The first object's index
     * @param num2 The second object's index
     * @return True if they are connected. (Have the same
     * value at their indexes).
     */
    public boolean isConnected(int num1, int num2) {
        return ids[num1] == ids[num2];
    }

    /**
     * Connects 1st and 2nd object. Also,
     * connects everything that's connected to 1st to 2nd
     * @param num1 The id of the first object
     * @param num2 The id of the second object
     */
    public void union(int num1, int num2) {
        int value1 = ids[num1];
        int value2 = ids[num2];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == value1) {
                ids[i] = value2;
            }
        }
    }
}
