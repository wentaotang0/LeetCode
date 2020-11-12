package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author twt
 * @description 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/12
 */
public class IsSymmetric {


    /**
     * DFS
     * 判断一个树对称，把树赋值一份，成为tree1和tree2，树对称即tree1和tree2镜像。
     * tree1和tree2镜像即：
     * 1.tree1和tree2根节点相等
     * 2.tree1的左子树和tree2的右子树镜像
     * 3.tree1的右子树和tree2的左子树镜像
     * <p>
     * 这样形成了递归
     *
     * @param root
     * @return
     */
    /*public boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }*/
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        //走到这里说明root1、root2均不为null
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * BFS
     * <p>
     * 和DFS类似，把树赋值一份，假如为tree1和tree2，用队列存左右子树，每次比较两个左右子树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Object o1 = null;
        Object o2 = null;
        System.out.println(null == null);

    }
}
