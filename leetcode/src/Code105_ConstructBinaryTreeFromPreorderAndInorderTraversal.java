/**
 * @author CD
 * @since 2023/2/5 20:31
 * package: PACKAGE_NAME
 * class: Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal
 *<p>
 *Given two integer arrays preorder and inorder where preorder is
 * the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 */
public class Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }

        return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2) {
        if (left1 > right1){
            return null;
        }
        TreeNode head = new TreeNode(preorder[left1]);
        if (left1 == right1){
            return head;
        }

        int find = left2;
        while (inorder[find] != preorder[left1]) {
            find++;
        }

        head.left = buildTreeNode(preorder, left1 + 1, left1 + find - left2, inorder, left2, find - 1);
        head.right = buildTreeNode(preorder, left1 + find - left2 + 1, right1, inorder, find + 1, right2);
        return head;
    }
}
