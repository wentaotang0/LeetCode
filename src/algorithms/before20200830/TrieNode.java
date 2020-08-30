package algorithms.before20200830;

/**
 * @author twt
 * @description
 * @date 2020/03/29
 */
public class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char val) {
        this.val = val;
    }

}
