package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */
public class ReversePrintLinkedList {
    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    //利用栈先进后出的特性从尾到头打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){{
        list.add(stack.pop());
        }}
        return list;
    }
}
