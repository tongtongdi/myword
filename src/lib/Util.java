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
}
