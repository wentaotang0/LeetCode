package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author twt
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/15
 */
public class IsValidBST {


    /**
     * DFS
     *
     * @param root
     * @return
     */
    /*public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }*/
    private boolean helper(TreeNode node, Integer low, Integer high) {

        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;

        return helper(node.left, low, node.val) && helper(node.right, node.val, high);
    }


    /**
     * 中序遍历BFS
     * 如果为二叉搜索树，则中序遍历后的结果递增
     *
     * @param root
     * @return
     */
    /*public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        //Deque<TreeNode> stack = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }*/


    long pre = Long.MIN_VALUE;

    /**
     * 中序遍历DFS
     * 如果为二叉搜索树，则中序遍历后的结果递增
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //遍历左子树
        if (!isValidBST(root.left)) return false;
        //当前节点的值小于等于上一个节点的值，则不符合二叉搜索树
        if (root.val <= pre) return false;
        pre = root.val;
        //遍历右子树
        if (!isValidBST(root.right)) return false;
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        /*root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);*/

        System.out.println(new IsValidBST().isValidBST(root));
    }


}
