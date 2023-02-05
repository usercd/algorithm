/**
 * @author CD
 * @since 2023/2/5 20:10
 * package: PACKAGE_NAME
 * class: Code101_SymmetricTree
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Code101_SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null){
            return true;
        }

        if (root == null ^ root1 == null){
            return false;
        }

        return root.val == root1.val && isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }
}
