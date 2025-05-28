package Tree;
import java.util.*;
public class _1993 {

}
class LockingTree {
    private int[] parent;
    private boolean[] isLocked;
    private int[] userMap;
    private List<Integer>[] children;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        isLocked = new boolean[n];
        userMap = new int[n];
        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (!isLocked[num]) {
            isLocked[num] = true;
            userMap[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (isLocked[num] && userMap[num] == user) {
            isLocked[num] = false;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (isLocked[num]) return false;


        int curr = parent[num];
        while (curr != -1) {
            if (isLocked[curr]) return false;
            curr = parent[curr];
        }


        boolean[] foundLocked = new boolean[1];
        unlockDescendants(num, foundLocked);

        if (!foundLocked[0]) return false;


        isLocked[num] = true;
        userMap[num] = user;
        return true;
    }

    private void unlockDescendants(int node, boolean[] foundLocked) {
        for (int child : children[node]) {
            if (isLocked[child]) {
                isLocked[child] = false;
                foundLocked[0] = true;
            }
            unlockDescendants(child, foundLocked);
        }
    }
}

