package leetcode;

import lib.ListNode;

/**
 * @Description:删除链表的倒数第N个节点
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class problem_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        ListNode start = head;
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head;
    }
    public static void main(String[] args) {

    }
}
