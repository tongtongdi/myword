package leetcode;

import lib.ListNode;
import lib.Util;

/**
 * @Description:
 * @Date: 2019/7/30
 * @Author 王通
 * @Version 1.0
 */

public class problem_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = head;
        ListNode tou = new ListNode(0);
        ListNode e = new ListNode(0);
        ListNode d = new ListNode(0);
        if(k==1) return head;
        tou.next = d;
        int i = 0;

        int k = 0;
        ListNode start = head;
        while (h != null) {
            i++;
            h = h.next;
            if(i==k-1) {
                if(h==null) break;
                ListNode t = h.next;
                h.next = null;
                e = exChangeGroup(start);
                d.next =e;
                while (e.next!=null){
                    e = e.next;
                }
                d= e;
                h = start = t;
                i=0;
                k = 1;
            }
        }
        if (i != 0) {
            if(k==0) return head;
            e.next = start;
        }
        return tou.next.next;
    }

    public static ListNode exChangeGroup(ListNode listNode) {
        ListNode p = new ListNode(listNode.val);
        listNode = listNode.next;
        ListNode head = null;
        while (listNode != null) {
            head = listNode;
            listNode = listNode.next;
            head.next = p;
            p = head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = Util.makeListNode(new int[]{1});
        Util.listPrint(reverseKGroup(list, 2));
    }
}
