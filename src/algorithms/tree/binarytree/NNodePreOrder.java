package algorithms.tree.binarytree;

import java.util.*;

/**
 * @author twt
 * @description 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/26
 */
public class NNodePreOrder {


    /*List<Integer> ans = new ArrayList<Integer>();

     */

    /**
     * dfs
     * 当前节点、子树
     *
     * @param root
     * @return
     *//*
    public List<Integer> preorder(Node root) {

        dfs(root);
        return ans;
    }


    private void dfs(Node root) {
        if (root == null) return;
        ans.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }*/

    /**
     * bfs
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            ans.add(cur.val);
            for (Node node : root.children) {
                if (node != null) queue.add(node);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
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
        new NNodePreOrder().preorder(root);
    }
}
