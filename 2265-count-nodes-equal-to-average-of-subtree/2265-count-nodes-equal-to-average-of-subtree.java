/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;

    class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return ans;
    }

    private Pair postorder(TreeNode node) {

        // Base case
        if (node == null) {
            return new Pair(0, 0);
        }

        // First solve left and right subtree
        Pair left = postorder(node.left);
        Pair right = postorder(node.right);

        // Calculate current subtree's sum and count
        int sum = node.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        // Calculate average and compare with current node
        int average = sum / count;

        if (node.val == average) {
            ans++;
        }

        // Return current subtree information to parent
        return new Pair(sum, count);
    }
}