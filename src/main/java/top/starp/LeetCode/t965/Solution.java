package top.starp.LeetCode.t965;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//class Solution {
//    int val;
//    boolean good = true;
//
//    public boolean isUnivalTree(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        val = root.val;
//        pre(root);
//        return good;
//
//    }
//
//    void pre(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.val != val) {
//            good = false;
//            return;
//        }
//        pre(node.left);
//        pre(node.right);
//
//    }
//}
