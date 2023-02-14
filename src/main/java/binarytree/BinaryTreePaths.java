package binarytree;

import java.util.ArrayList;

/**
 * @Author Lujs
 * @Date 2022/7/23
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        getPath(root,target);
        return result;
    }


        private void getPath(TreeNode root, int target){
        if (root == null){
            return;
        }
        //在代表所经过路径的列表中加入当前根节点
        list.add(root.val);
        //路径列表加入当前根节点后，求和的值减去已经算在路径中的节点的值
        target -= root.val;
        if (root.left == null && root.right == null && target == 0){
            //当二叉树路径遍历完下面再也没有节点，并且路径所经过节点的值的和正好等于输入的整数时，重新用一个新的列表存放这一条路径，以免和公用的list混淆
            result.add(new ArrayList<>(list));
        }
        //递归从当前根节点的左子树继续遍历路径，看看是否经过的值的和能等于输入的整数
        getPath(root.left,target);
        //递归从当前根节点的右子树继续遍历路径，看看是否经过的值的和能等于输入的整数
        getPath(root.right,target);
        //存放经过路径的列表移除最后存放的值，即经过的最后一个节点，这样路径就能回退一个节点到自己的父节点上，层层递归后就能回退到一开始的根节点上，能够继续往下遍历另一条路径
        list.remove(list.size()-1);
    }
}
