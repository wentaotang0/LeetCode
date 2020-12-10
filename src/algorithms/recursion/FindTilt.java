package algorithms.recursion;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description 给定一个二叉树，计算 整个树 的坡度 。
 * <p>
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * <p>
 * 整个树 的坡度就是其所有节点的坡度之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [21,7,14,1,1,2,2,3,3]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目的范围在 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/08
 */
public class FindTilt {


    int ans;


    /**
     * 1.遍历每个节点
     * 2.求每个节点的坡度
     * 3.坡度累加
     *
     * @param root
     * @return
     */
    /*public int findTilt(TreeNode root) {
        if (root == null) return 0;
        findTilt(root.left);
        findTilt(root.right);
        ans += Math.abs(sum(root.left) - sum(root.right));
        return ans;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        return sum(node.left) + node.val + sum(node.right);
    }*/
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        sum(root);
        return ans;
    }


    /**
     * 任意节点的和(包含当前节点)
     * 求任意节点和的过程中累加每个节点的坡度
     *
     * @param node
     * @return
     */
    private int sum(TreeNode node) {
        if (node == null) return 0;
        int lSum = sum(node.left);
        int RSum = sum(node.right);
        ans += Math.abs(lSum - RSum);
        return lSum + node.val + RSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //System.out.println(new FindTilt().sum(root));
        System.out.println(new FindTilt().findTilt(root));
    }
}
