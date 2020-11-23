package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

/**
 * @author twt
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/23
 */
public class LowestCommonAncestor {


    /**
     * 公共祖先：若节点 p 在节点 root 的左（右）子树中，或 p = root ，则称 root 是 p 的祖先。
     * 最近公共祖先的定义：设节点 root为节点 p, q某公共祖先，若其左子节点 root.left和右子节点 root.right都不是 p,q的公共祖先，则称 root是 “最近的公共祖先” 。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //若根节点和p或q节点相等，则最小公共祖先为root
        if (root.val == p.val || root.val == q.val) return root;

        //左子树的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右子树的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //left、right其中之一为null，则最近公共祖先为另一个
        if (left == null) return right;
        if (right == null) return left;

        //left和right分别在root的异侧（左子树或者右子树），则p和q的最近公共祖先为root
        return root;
    }
}
