package linkedlist;

/**
 * 输入两个递增的链表,合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 参考https://zhuanlan.zhihu.com/p/272507731
 */
public class MergeTwoSortedLinkedLists {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //用指针找到两个链表上当前结点小值的一方，然后其链接到 新链表
    public ListNode Merge(ListNode list1,ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        if (list1.val <= list2.val){ //利用归并排序的递归思想，将两个链表的较小节点链接起来
            list1.next = Merge(list1.next,list2); //如果list1当前节点小于等于list2当前节点，那么list1当前节点的值不动，并将索引往后一个节点，与list2的原较大节点继续比较
            return list1;
        }else {
            list2.next = Merge(list2.next,list1);//如果list2当前节点小于等于list1当前节点，那么list2当前节点的值不动，并将索引往后一个节点，与list1的原较大节点继续比较
            return list2;
        }
    }
}
