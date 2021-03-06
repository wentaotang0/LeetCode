package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author twt
 * @description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 通过次数214,799提交次数337,446
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/10
 */
public class LevelOrder {


    /**
     * 思路：使用队列来存每层的节点，存每层节点数量时需要计数
     *
     * @param root
     * @return
     */
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        //作为临时变量统计每层节点的数量
        int count = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> nodes = new ArrayList<>();
            if (size == 0) {
                size = count;
            }
            count=0;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
                nodes.add(node.val);
                size--;
            }
            ans.add(nodes);
        }

        return ans;
    }*/


    /**
     * bfs代码优化
     *
     * @param root
     * @return
     */
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            //当前层节点个数
            int levelNum = queue.size();
            while (levelNum > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelNum--;
            }
            ans.add(level);
        }
        return ans;
    }*/

    private int depth;

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * dfs实现方式
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return ans;

    }

    /**
     * 后续遍历,需要在遍历节点之前创建每层的集合
     *
     * @param root     当前节点
     * @param curDepth 当前深度
     */
    private void dfs(TreeNode root, int curDepth) {
        if (root == null) return;
        //优化：depth可以替换为结果集合当前个数
        if (ans.size() == curDepth) {
        //if (depth == curDepth) {
            ArrayList<Integer> level = new ArrayList<>();
            ans.add(level);
            depth++;
        }
        ans.get(curDepth).add(root.val);
        dfs(root.left, curDepth + 1);
        dfs(root.right, curDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //System.out.println(new LevelOrder().levelOrder(root));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(null);
        System.out.println(queue.size());
    }
}
