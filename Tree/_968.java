package Tree;
import java.util.*;
/**
  Definition for a binary tree node.*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class _968 {

        private int cameras = 0;

        public int minCameraCover(TreeNode root) {
            if (dfs(root) == 0) {
                cameras++;
            }
            return cameras;
        }
        private int dfs(TreeNode node) {
            if (node == null) return 1;

            int left = dfs(node.left);
            int right = dfs(node.right);

            if (left == 0 || right == 0) {
                cameras++;
                return 2;
            }

            if (left == 2 || right == 2) {
                return 1;
            }

            return 0;
        }
}

class Test_968{
    public static void main(String[] args) {
        _968 solution = new _968();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.right.left = new TreeNode(0);
        root.left.right.left.right = new TreeNode(0);
        root.left.right.left.right.left = new TreeNode(0);
        System.out.println(solution.minCameraCover(root));
    }
}
