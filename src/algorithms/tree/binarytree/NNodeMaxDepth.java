package algorithms.tree.binarytree;

import java.util.ArrayList;

/**
 * @author twt
 * @description 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/30
 */
public class NNodeMaxDepth {

    /**
     * N叉树的最大深度等于所有子树深度中最大的一个加1
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {

        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;
        int ans = Integer.MIN_VALUE;
        for (Node node : root.children) {
            int cur = maxDepth(node);
            if (ans < cur) ans = cur;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        ArrayList<Node> children1 = new ArrayList<>();
        children1.add(new Node(3));
        children1.add(new Node(2));
        children1.add(new Node(4));
        root.children = children1;
        ArrayList<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        children1.get(0).children = children2;

        System.out.println(new NNodeMaxDepth().maxDepth(root));



    }
}
