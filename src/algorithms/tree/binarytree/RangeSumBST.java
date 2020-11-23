package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description
 * @date 2020/11/18
 */
public class RangeSumBST {


    int ans;
    int low;
    int high;

    /**
     * 每遍历一个节点，判断是否符合范围，符合范围则累加，返回累加和
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return ans;
    }

    /*private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.val >= low && root.val <= high) ans += root.val;
        dfs(root.right);
    }*/


    /**
     * 优化
     * 我们对树进行深度优先搜索，对于当前节点 node，如果 node.val 小于等于 L，那么只需要继续搜索它的右子树；如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树。
     *
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val < low) {
            dfs(root.right);
        } else if (root.val > high) {
            dfs(root.left);
        } else {
            ans += root.val;
            dfs(root.left);
            dfs(root.right);
        }
    }
}
