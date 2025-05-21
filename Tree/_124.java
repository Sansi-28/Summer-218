package Tree;

public class _124 {
    /**
     * Definition for a binary tree node.*/
    static class TreeNode {
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

        public static int max = Integer.MIN_VALUE;

         static int helper(TreeNode root){
            if(root == null)return 0;

            int leftGain = Math.max(helper(root.left), 0);
            int rightGain = Math.max(helper(root.right), 0);
            int priceNewPath = root.val + leftGain + rightGain;
            max = Math.max(max, priceNewPath);
            return root.val + Math.max(leftGain, rightGain);

        }
         static int maxPathSum(TreeNode root) {
            if(root.left == null && root.right == null)return root.val;
            helper(root);
            return max;
        }

        public static void main(String[] args) {
            TreeNode l1 = new TreeNode(20);
            TreeNode  l2 = new TreeNode(6);
            TreeNode  l3 = new TreeNode(7);
            TreeNode  l4 = new TreeNode(9);
            TreeNode node1 = new TreeNode(-4, l1, null);
            TreeNode node2 = new TreeNode(15, node1, l2);
            TreeNode node3 = new TreeNode(20, node2, l3);
            TreeNode node4 = new TreeNode(-10, l4, node3);
            System.out.println(maxPathSum(node4));
    }
}
