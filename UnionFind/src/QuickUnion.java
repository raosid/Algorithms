/**
 * Created by sidrao on 12/15/14.
 * Implementation of QuickUnion. It's still not a good algorithm
 * for dynamic connectivity since it's every Find operation has to make
 * N array accesses.
 */
public class QuickUnion {
    private int[] ids;

    //Constructor. Initializes the array.
    public QuickUnion(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    //Finds the root of the given number.
    private int root(int num) {
        while (ids[num] != num) {
            num = ids[num];
        }
        return num;
    }

    //Union operation. Connects num1 to num2
    public void union(int num1, int num2) {
        int rootOfNum1 = root(num1);
        int rootOfNum2 = root(num2);
        ids[rootOfNum1] = rootOfNum2;
    }

    //Returns true if the two objects are connected.
    public boolean isConnected(int num1, int num2) {
        return root(num1) == root(num2);
    }
}
