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
    boolean solve(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;

        if(root1.val!=root2.val)return false;
        boolean r1 = solve(root1.left,root2.left);
        boolean r2 =   solve(root1.right,root2.right);
        return r1&&r2;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }
}
