package leetcode;

import lib.ListNode;
import lib.Util;

import java.util.List;

public class problem_203 {
    public static void main(String[] args) {
        int nums[] = {7,7,7,7};
        ListNode list = Util.makeListNode(nums);
        ListNode out = removeElements(list, 7);
        if (out != null) {
            System.out.println(out.toString());
        } else {
            System.out.println("error!");
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        while (start != null && start.val == val) {
            start = start.next;
        }
        if (start == null) {
            return null;
        }
        ListNode p = start;
        while (p.next != null) {
            if (p.next.val == val) {
                RemovePnext(p);
            } else {
                p = p.next;
            }
        }
        return start;
    }
    public static void RemovePnext(ListNode p) {
        p.next = p.next.next;
    }
}
