package binarytree;

/**
 * @Author Lujs
 * @Date 2022/7/23
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 题解：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/
 */
public class IsPostorderTraversal {

    public boolean verifySquenceOfBST(int[] sequence){
        if (sequence.length == 0){
            return false;
        }
        if (sequence.length == 1){
            return true;
        }
        return isPostorderTraversal(sequence,0,sequence.length-1);
    }

    private boolean isPostorderTraversal(int[] a ,int start ,int end){
        //如果指针从底往上递归的过程到最后开始和结束索引相遇，说明已经遍历到根节点，整个数组确实为后序遍历二叉树
        if (start >= end){
            return true;
        }
        //后序遍历是先左节点，再右节点，最后根节点，因此数组开头元素一定是二叉树左下角最小节点，sequence[end]一定是根节点
        int i = start;
        //这里从左往右找出第一个比根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，因为最后一个是根节点），他前面的都是根节点的左子节点
        while (a[start] < a[end]){
            i++ ;
        }
        //sequence[i]前面的值都是比根节点root小的，我们还需要确定sequence[i]后面的值都要比根节点root大，如果后面有比根节点小的直接返回false
        for (int j = i; j < end; j++) {
            if (a[j] < a[end]){
                return false;
            }
        }
        //然后对左右子节点进行递归调用
        return isPostorderTraversal(a,0,i-1)&&isPostorderTraversal(a,i,end-1);
    }
}
