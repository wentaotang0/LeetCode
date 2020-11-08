package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author twt
 * @description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/08
 */
public class MirrorTree {

    /**
     * DFS
     * 镜像即左右子节点交换
     * 递归公式：mirrorTree(root)=switch(mirrorTree(root.left),mirrorTree(root.right))
     * 结束条件：node==null
     *
     * @param root
     * @return
     */
    /*public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        TreeNode n1 = mirrorTree(root.left);
        TreeNode n2 = mirrorTree(root.right);
        //交换左右子节点
        TreeNode temp = n1;
        root.left = n2;
        root.right = temp;
        return root;
    }*/

    /**
     * DFS优化版
     * @param root
     * @return
     */
    /*public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        TreeNode n1 = mirrorTree(root.left);
        TreeNode n2 = mirrorTree(root.right);
        //交换左右子节点
        root.left = n2;
        root.right = n1;
        return root;
    }*/


    /**
     * 遍历法
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }


}
