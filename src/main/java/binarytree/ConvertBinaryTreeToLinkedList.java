package binarytree;

/**
 * @Author Lujs
 * @Date 2022/7/23
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 中序+连接链表
 */
public class ConvertBinaryTreeToLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //中序遍历当前值的上一位，初值为最小值，先定为null
    TreeNode pre = null;
    //链表的首节点，即根节点左子树的最小节点，在左子树左下角
    TreeNode head = null;

    public TreeNode convert(TreeNode root){
        convertSubTree(root);
        //返回链表首节点，即二叉树中左下角最小节点
        return head;
    }

    private void convertSubTree(TreeNode root){
        if (root == null){
            return;
        }
        //递归转换左子树
        convertSubTree(root.left);
        //如果没有左子树，则左侧最后一个节点即为当前根节点自己，链表首节点也是自己，一般发生在左侧叶子节点
        if (pre == null){
            head = root;
            pre = root;
        }else {
            //建立双向链接，左子树最后一个节点（即左子树右下角最大节点）的右链接指向根节点，根节点的左链接指向左子树最大节点，然后将左侧最大节点设为根节点，作为链表前半部分最大节点
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        //递归转换右子树
        convertSubTree(root.right);
    }
}
