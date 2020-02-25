package leetcode;


import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class problem_101 {

    public  boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        if(root.right==null || root.left==null) return false;
        if(checkLeftRigt(root.left,root.right)) return true;
        return false;
    }

    public boolean checkLeftRigt(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        if(left.val!=right.val) return false;
        /*if(left.val==right.val) return true;*/
        if(checkLeftRigt(left.left,right.right)) return true;
        if(checkLeftRigt(left.right,right.left)) return true;
        return false;
    }
}
