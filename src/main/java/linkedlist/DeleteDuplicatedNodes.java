package linkedlist;

/*
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * */
public class DeleteDuplicatedNodes {
    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicatedNodes(ListNode phead){
        if (phead == null){
            return null;
        }
        //在链表头前加一个表头
        ListNode first = new ListNode(0);
        first.next = phead;

        ListNode cur = first;
        while (cur.next != null && cur.next.next != null){
            //遇到相邻的两个节点值相同
            if (cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                //将这所有相同都跳过
                while (cur.next!=null && cur.next.val == temp){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        //返回时去掉表头
        return first.next;
    }
}
