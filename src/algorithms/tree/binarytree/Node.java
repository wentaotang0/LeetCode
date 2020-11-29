package algorithms.tree.binarytree;

import java.util.List;

/**
 * @author twt
 * @description
 * @date 2020/11/25
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
