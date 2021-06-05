package lib;

/**
 * @Description:
 * @Date: 2019/7/29
 * @Author 王通
 * @Version 1.0
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("["+this.val);
        ListNode next = this.next;
        while (next != null) {
            string.append(","+next.val);
            next = next.next;
        }
        string.append("]");
        return string.toString();
    }
}
