package linkedlist;

/**
 * 输入一个链表和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 */
public class DeleteNode {
    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deteleNode(ListNode head,int val){
        //加入一个头节点
        ListNode res = new ListNode(0);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //遍历链表
        while (cur != null){
            //找到目标节点
            if (cur.val == val){
                //断开连接
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        //返回去掉头节点
        return res.next;
    }
}
