/**
 * Created by sidrao on 12/15/14.
 * Implementation of a Weighted QuickUnion Algorithm with path
 * compression. It makes the tree flat and the length of the tree
 * is reduced. Worst case for Union and Find is lgN.
 * N array accesses.
 */
public class WeightedQuickUnion {

    private int[] ids;
    private int[] size;

    //Constructor. Initializes the array.
    public WeightedQuickUnion(int N) {
        ids = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    //Finds the root of the given number.
    private int root(int num) {
        while (ids[num] != num) {
            //One traversal implementation of path compression.
            //Halving the path length
            ids[num] = ids[ids[num]]; //making the grandparent the root of the current node.
            num = ids[num];
        }
        return num;
    }

    //Union operation. Connects num1 to num2
    public void union(int num1, int num2) {
        int rootOfNum1 = root(num1);
        int rootOfNum2 = root(num2);
        //Making the graph weighted.
        if (size[rootOfNum1] > size[rootOfNum2]) {
            ids[rootOfNum2] = rootOfNum1;
            size[rootOfNum1]+=size[rootOfNum2];
        } else {
            ids[rootOfNum1] = rootOfNum2;
            size[rootOfNum2]+=size[rootOfNum1];
        }
    }

    //Returns true if the two objects are connected.
    public boolean isConnected(int num1, int num2) {
        return root(num1) == root(num2);
    }
}
