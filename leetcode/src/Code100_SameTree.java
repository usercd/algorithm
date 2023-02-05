/**
 * @author CD
 * @since 2023/2/5 19:38
 * package: PACKAGE_NAME
 * class: Code100_SameTree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class Code100_SameTree {
    /**
     * 二叉树结构
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //都是空
        if (p == null && q == null){
            return true;
        }
        //一空一不空
        if (p == null ^ q == null){
            return false;
        }
        //都不空
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
