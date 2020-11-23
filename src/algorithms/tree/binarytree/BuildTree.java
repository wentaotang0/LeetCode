package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author twt
 * @description 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/22
 */
public class BuildTree {


    Map<Integer, Integer> map = new HashMap();
    int[] preorder;
    int[] inorder;


    /**
     * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLength = preorder.length;
        int inLength = inorder.length;
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preLength-1, 0, inLength-1);
    }


    /**
     *
     * @param preLeft 前序遍历左边界
     * @param preRight 前序遍历有边界
     * @param inLeft 中序遍历左边界
     * @param inRight 中序遍历有边界
     * @return
     */
    private TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        Integer pivot = map.get(val);
        root.left = dfs(preLeft + 1, pivot + preLeft - inLeft, inLeft, pivot - 1);
        root.right = dfs(pivot + preLeft - inLeft+1, preRight, pivot+1, inRight);
        return root;
    }
}
