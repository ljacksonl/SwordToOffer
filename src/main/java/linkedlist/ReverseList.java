package linkedlist;

/*
 * 输入一个链表，反转链表后，输出新链表的表头。
 * */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //定义两个指针指向头节点和前置节点
        ListNode cur = head;
        ListNode pre = null;
        while (cur!= null){
            //保存一下 cur的下一个节点 因为接下来要改变cur->next
            ListNode temp = cur.next;
            //保存好了 翻转操作
            cur.next = pre;
            //最后更新一下pre和cur指针的位置
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
