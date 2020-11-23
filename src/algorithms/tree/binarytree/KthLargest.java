package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/17
 */
public class KthLargest {


    //private List<Integer> ans = new ArrayList();


    /**
     * DFS
     * 右子树，当前节点，左子树遍历，遍历到第k个即为第k大
     *
     * @param root
     * @param k
     * @return
     */
    /*public int kthLargest(TreeNode root, int k) {

        helper(root);
        return ans.get(k - 1);
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        ans.add(root.val);
        helper(root.left);
    }*/


    int k;
    int ans;

    /**
     * DFS
     * 右子树，当前节点，左子树遍历，遍历到第k个即为第k大
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        ans = root.val;
        k--;
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        //root.right.right = new TreeNode(7);
        System.out.println(new KthLargest().kthLargest(root, 1));
    }
}
