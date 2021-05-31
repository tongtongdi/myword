package swordforoffer;

import lib.TreeNode;
import lib.Util;

/**
 *
 */
public class problem_8 {
    public static void main(String[] args) {
        int numberpre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int numbermid[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node1 = Construct(numberpre, numbermid);
        System.out.printf("前序遍历");
        Util.DLRprintf(node1);
        System.out.printf("\n中序遍历");
        Util.LDRprintf(node1);
        System.out.printf("\n后序遍历");
        Util.RLDprintf(node1);
    }

    static TreeNode Construct(int pre[], int []in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        return ConstructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    static private TreeNode ConstructCore(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = pre[preL];
        int index = 0;
        // 这一步是找到中序遍历的中间节点，rootVal 表示的肯定是根节点，找到中序遍历中的根节点
        while (index <= inR && in[index] != rootVal) {
            index++;
        }
        TreeNode root = new TreeNode(rootVal);
        // preL + 1，这个是因为left左子树从后面找就完事了，加一个1。
        // 前序遍历的截止就是preL 加上 以rootVal为根的二叉树的个数。
        // 以rootVal为根的二叉树数目为：index - inL
        root.left = ConstructCore(pre, preL + 1, preL - inL + index, in, inL, index);
        root.right = ConstructCore(pre, preL-inL + index + 1, preR, in, index + 1, inR);
        return root;
    }
}
