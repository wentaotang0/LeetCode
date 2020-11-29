package algorithms.tree.binarytree;

import java.util.*;

/**
 * @author twt
 * @description 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/25
 */
public class NNodePostOrder {

    /*List<Integer> ans = new ArrayList<>();

     *//**
     * dfs
     * 遍历顺序：子树、当前节点
     *
     * @param root
     * @return
     *//*
    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root == null) return;
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i));
            }
        }
        ans.add(root.val);
    }*/


    /**
     * bfs
     *
     * @param root
     * @return
     */
    /*public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return res;
    }*/

    /**
     * bfs
     *
     * @param root
     * @return
     */
    /*public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return res;
    }*/

    /**
     * bfs
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*Node root = new Node(1);
        ArrayList<Node> children1 = new ArrayList<>();
        children1.add(new Node(3));
        children1.add(new Node(2));
        children1.add(new Node(4));
        root.children = children1;
        ArrayList<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        children1.get(0).children = children2;
        System.out.println(new NNodePostOrder().postorder(root));*/
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }

    }
}
