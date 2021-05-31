package lib;

/**
 * @Description:
 * @Date: 2019/3/21
 * @Author 王通
 * @Version 1.0
 */

public class Util {
    public static ListNode makeListNode(int[] arrys){
        if(arrys.length<=0){
            return null;
        }
        ListNode list = new ListNode(arrys[0]);
        ListNode head = list;
        for(int i=1;i<arrys.length;i++){
            ListNode next = new ListNode(arrys[i]);
            list.next = next;
            list = next;
        }
        return head;
    }
    public static void listPrint(ListNode listNode) {
        while (listNode!=null){
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }

    // 前序遍历
    public static void DLRprintf(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf(root.val + ";");
        DLRprintf(root.left);
        DLRprintf(root.right);
    }
    // 中序遍历
    public static void LDRprintf(TreeNode root) {
        if (root == null) {
            return;
        }
        LDRprintf(root.left);
        System.out.printf(root.val + ";");
        LDRprintf(root.right);
    }
    // 后序遍历
    public static void RLDprintf(TreeNode root) {
        if (root == null) {
            return;
        }
        RLDprintf(root.left);
        RLDprintf(root.right);
        System.out.printf(root.val + ";");
    }
}
