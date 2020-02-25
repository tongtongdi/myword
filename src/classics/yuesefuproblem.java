package classics;

import lib.ListNode;

/**
 * 约瑟夫问题，
 * 39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，
 * 41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，
 * 直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，
 * 越过k-2个人（因为第一个人已经被越过），并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。
 * 这个过程沿着圆圈一直进行，直到最终只剩下一个人留下，这个人就可以继续活着。问题是，给定了和，
 * 一开始要站在什么地方才能避免被处决？
 * Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
 */
public class yuesefuproblem {

    public static void main(String[] args) {
        //输入M表示多少个人，输入N表示要活几个人，输出他们的位置
        //问题要用到链表,
        //解法一
        int m = 1024, n = 2;
        if(m==0 || m==0){
            System.out.println(0);
            return;
        }
        ListNode star = new ListNode(0);
        ListNode p = star;
        //初始化这个链表
        for(int i=1;i<m+1;i++){
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        p.next = star.next;
        p = p.next;
        //到这个地方初始化完毕，star表示链表的开头，p表示第一个人
        //System.out.println(p.val);

        //这个就是把p的下一个的下一个删除掉
        //p表示一，然后p的下一个的下一个表示3，
        //删除完了之后的p，要指向被删除的的3的后面一个，然后再开始遍历
        for(int i=0;i<m-2;i++){
            //p向下走一位，然后把p的下一位删除掉，就是p.next = p.next.next;
            p = p.next;
            p.next = p.next.next;
            p = p.next;
        }
        //输出结果
        for(int i=0;i<n;i++){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
