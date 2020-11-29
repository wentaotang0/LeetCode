package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 *  /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 * 9
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/29
 */
public class IncreasingBST {


    /*ArrayList<TreeNode> list = new ArrayList<>();

     */
    /**
     * dfs额外空间
     *
     * @param root
     * @return
     *//*
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        inorder(root);
        for (TreeNode node : list) {
            cur.right = new TreeNode(node.val);
            cur = cur.right;
        }
        return ans.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }*/


    TreeNode pre = new TreeNode(0);


    /**
     * 当我们遍历到一个节点时，把它的左孩子设为空，并将其本身作为上一个遍历到的节点的右孩子。
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = pre;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        root.left = null;
        pre.right = root;
        pre = pre.right;
        inorder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        System.out.println(new IncreasingBST().increasingBST(root));
    }
}
