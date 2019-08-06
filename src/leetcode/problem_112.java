package leetcode;

import lib.TreeNode;

/**
 * @Description:
 * @Date: 2019/7/31
 * @Author 王通
 * @Version 1.0
 */

public class problem_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null && sum==0) return true;
        if(hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)){
            return true;
        }else{
            return false;
        }
    }
}
