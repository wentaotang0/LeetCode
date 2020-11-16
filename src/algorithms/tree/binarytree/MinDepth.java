package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author twt
 * @description 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/15
 */
public class MinDepth {


    /**
     * DFS
     * 考虑边界条件
     *
     * @param root
     * @return
     */
    /*public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
            //最小深度定义为：根节点到叶子节点
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            int leftHigh = minDepth(root.left);
            int rightHigh = minDepth(root.right);
            return Math.min(leftHigh, rightHigh) + 1;
        }
    }*/


    /**
     * BFS
     * 最先搜索到的叶子节点一定是深度最小
     * 叶子节点即左子节点和右子节点均不存在
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<NodeDepth> queue = new LinkedList<>();
        queue.add(new NodeDepth(1, root));

        while (!queue.isEmpty()) {
            NodeDepth nodeDepth = queue.poll();
            if (nodeDepth.node.left == null && nodeDepth.node.right == null) return nodeDepth.depth;
            if (nodeDepth.node.left != null) queue.add(new NodeDepth(nodeDepth.depth + 1, nodeDepth.node.left));
            if (nodeDepth.node.right != null) queue.add(new NodeDepth(nodeDepth.depth + 1, nodeDepth.node.right));
        }
        return 0;
    }

    class NodeDepth {
        int depth;
        TreeNode node;

        public NodeDepth(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
}
