package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.LinkedList;

/**
 * @author twt
 * @description 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/08
 */
public class MaxDepth {

    /**
     * DFS
     * 递归公式：maxDepth(root)=Max(maxDepth(root.left),maxDepth(root.right))+1;
     * 结束条件：节点为null
     *
     * @param root
     * @return
     */
    /*public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftHigh = maxDepth(root.left);
        int rightHigh = maxDepth(root.right);
        return Math.max(leftHigh, rightHigh) + 1;
    }*/


    /**
     * BFS
     * 队列里面存每层节点
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            //当前层节点的个数
            int size = queue.size();
            while (size > 0) {
                TreeNode peek = queue.poll();
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
                size--;
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
