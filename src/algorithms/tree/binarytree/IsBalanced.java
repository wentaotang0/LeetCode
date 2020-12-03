package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/01
 */
public class IsBalanced {

    /**
     * 平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     * <p>
     * 如果根节点及左右子树都为平衡树则为平衡树
     *
     * @param root
     * @return
     */
    /*public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        int left = nodeHeigh(root.left);
        int right = nodeHeigh(root.right);
        //根节点是否为平衡树
        //if (Math.abs(left - right) > 1) return false;
        //判断左右子树是否为平衡树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    private int nodeHeigh(TreeNode root) {
        if (root == null) return 0;
        int leftHeigh = nodeHeigh(root.left);
        int rightHeigh = nodeHeigh(root.right);
        return Math.max(leftHeigh, rightHeigh) + 1;
    }*/


    private boolean isBalance = true;

    /**
     * 优化：因为求高度的时候会由下往上遍历节点，所以在求根节点的高度时可以知道每个节点的高度，即可以求一次根节点的高度，有不满足节点时提前结束
     *
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        nodeHeigh(root);
        return isBalance;
    }


    private int nodeHeigh(TreeNode root) {
        //返回0或者不是0都可以，不影响是否为平衡树
        if (root == null || !isBalance) return 0;
        int leftHeigh = nodeHeigh(root.left);
        int rightHeigh = nodeHeigh(root.right);
        //记录当前节点是否为平衡树
        if (Math.abs(leftHeigh - rightHeigh) > 1) isBalance = false;
        return Math.max(leftHeigh, rightHeigh) + 1;
    }
}
