package leetcode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import lib.ListNode;
import lib.Util;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/7/30
 * @Author 王通
 * @Version 1.0
 */

public class problem_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<=0) return null;
        ListNode min = lists[0];
        return merge(lists,0,lists.length-1);
    }

    public static ListNode merge(ListNode[] list, int s, int e) {
        if(s==e) return list[s];
        int mid = e + (e - s) / 2;
        ListNode l1 = merge(list, s, mid);
        ListNode l2 = merge(list, mid + 1, e);
        return mergeTwoNode(l1, l2);
    }

    public static ListNode mergeTwoNode(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val>l2.val){
            l2.next = mergeTwoNode(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoNode(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = Util.makeListNode(new int[]{1,4,5});
        ListNode list2 = Util.makeListNode(new int[]{1,3,4});
        ListNode list3 = Util.makeListNode(new int[]{2,6});
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = list1;
        listNodes[1] = list2;
        listNodes[2] = list3;
        Util.listPrint(mergeKLists(listNodes));
    }


}
