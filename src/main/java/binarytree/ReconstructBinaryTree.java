package binarytree;

import java.util.Arrays;

/**
 * @Author Lujs
 * @Date 2022/7/20
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class ReconstructBinaryTree {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin){
        int n = pre.length;
        int m = vin.length;

        //每个遍历都不能为0
        if (n == 0 || m == 0){
            return null;
        }
        //构建根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            //找到中序遍历中的前序第一个元素
            if (pre[0] == vin[i]){
                //i+1为前序数组中左子树结束位置，根据中序数组中根节点左边元素个数计算
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(vin,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(vin,i + 1,vin.length));
                break;
            }
        }
        return root;
    }
}
