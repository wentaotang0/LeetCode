package algorithms.recursion;

import algorithms.linkedlist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author twt
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
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
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/13
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }


    private TreeNode buildTree(Map<Integer, Integer> map, int pleft, int pright, int[] preorder, int ileft, int iright, int[] inorder) {
        if (pleft > pright || pleft > pright) return null;
        TreeNode root = new TreeNode(preorder[pleft]);
        Integer pivot = map.get(preorder[pleft]);
        root.left = buildTree(map, pleft + 1, pivot - ileft + pleft, preorder, ileft, pivot - 1, inorder);
        root.right = buildTree(map, pivot - ileft + pleft + 1, pright, preorder, pivot + 1, iright, inorder);
        return root;
    }

}
