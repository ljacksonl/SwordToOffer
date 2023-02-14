package linkedlist;

/*
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 传统解法的原理解释：https://blog.csdn.net/snow_7/article/details/52181049
 * */
public class EntranceOfLoopLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //判断有没有环，返回相遇的地方
    public ListNode hasCycle(ListNode head){
        //先判断链表为空的情况
        if (head == null){
            return null;
        }
        //快慢双指针
        ListNode fast = head;
        ListNode slow = head;
        //如果没环快指针会先到链表尾
        while (fast != null && fast.next != null){
            //快指针移动两步
            fast = fast.next.next;
            //慢指针移动一步
            slow = slow.next;
            //相遇则有环，返回相遇的位置
            if (fast == slow){
                return slow;
            }
            //到末尾说明没有环，返回null
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);
        if (slow == null){
            return null;
        }
        ListNode fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



}
