package linkedlist;

/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 原理图解：https://uploadfiles.nowcoder.net/images/20170311/412362_1489225139482_4A47A0DB6E60853DEDFCFDF08A5CA249
 * */
public class ComplicatedLinkedListCopy {
    public class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label){
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        //初始化一个当前所遍历的节点的游标，用于从前往后遍历链表
        RandomListNode cur = pHead;
        while (cur != null){
            //拷贝节点
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            //游标跳过中间的克隆节点到达当前节点原来的下一跳节点
            cur = clone.next;
        }
        cur = pHead;
        while (cur != null){
            //cur.next就是当前节点的克隆节点，随机指针指向当前节点随机指向节点的下一跳，即随机指向节点的克隆节点
            cur.next.random = cur.random == null ? null : cur.random.next;
            //游标跳过当前节点的克隆节点，指向原链表的下一跳
            cur = cur.next.next;
        }
        cur = pHead;
        //指定新链表的首节点，即第一个克隆节点
        RandomListNode clone = pHead.next;
        while (cur != null){
            //当前节点的下一跳重新指向原链表的下一跳，不再指向克隆节点
            cur.next = cur.next.next;
            //cur.next已经指向原链表当前节点的原来下一跳，跳过了克隆节点，重新链接好原链表
            cur = cur.next;
        }
        if (clone.next != null){
            clone.next = clone.next.next;
            clone = clone.next;
        }
        return clone;

    }
}
