package algorithms.hashtable;

import algorithms.linkedlist.TreeNode;

import java.util.*;

/**
 * @author twt
 * @description 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/26
 */
public class InorderTraversal {

    ArrayList<Integer> ans = new ArrayList<>();

    /**
     * 1.递推公式 中序遍历的递推公式：inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
     * 2.结束条件 root==null
     *
     * @param root
     * @return
     */
    /*public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }*/

    /**
     * 使用栈来模拟递归中方法的调用
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //root表示的是当前遍历的节点，如果stack不为空，root==null，说明当前节点的右子树为null，需要stack pop走到当前节点的父节点
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //此时root==null
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        TreeNode r11 = new TreeNode(3);
        TreeNode l21 = new TreeNode(4);
        TreeNode r22 = new TreeNode(5);
        TreeNode l23 = new TreeNode(6);
        root.left = l11;
        root.right = r11;
        l11.left = l21;
        l11.right = r22;
        r11.left = l23;

        new InorderTraversal().inorderTraversal(root);
    }
}
