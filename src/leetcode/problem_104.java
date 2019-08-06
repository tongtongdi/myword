package leetcode;


import lib.TreeNode;

/**
 * @Description:
 * @Date: 2019/7/31
 * @Author 王通
 * @Version 1.0
 */

public class problem_104 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
