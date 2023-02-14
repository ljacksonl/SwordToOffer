package binarytree;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/7/24
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针next。
 */
public class FindNextNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    ArrayList<TreeLinkNode> nodes = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        //获取根节点，因为next指针是指向父结点，当next为空是即为根节点
        TreeLinkNode root = pNode;
        while (root.next != null){
            root = root.next;
        }
        InOrder(root);
        int n = nodes.size();
        for (int i = 0; i < n-1; i++) {
            TreeLinkNode cur = nodes.get(i);
            if (pNode == cur){
                return nodes.get(i+1);
            }
        }
        return null;
    }

    //中序遍历
    void InOrder(TreeLinkNode root){
        if (root!=null){
            InOrder(root.left);
            nodes.add(root);
            InOrder(root.right);
        }
    }
}
