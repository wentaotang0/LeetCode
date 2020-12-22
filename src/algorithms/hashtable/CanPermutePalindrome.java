package algorithms.hashtable;

import java.util.HashSet;

/**
 * @author twt
 * @description 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 *  
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/22
 */
public class CanPermutePalindrome {


    /**
     * 某个字符的个数出现两次奇数则不满足回文序列
     *
     * 哈希表+栈(存在相同字符移除，不存在添加)，最后判断剩余的字符个数
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 1) return true;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                continue;
            }
            set.remove(c);
        }
        return set.size() > 1 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(new CanPermutePalindrome().canPermutePalindrome("code"));
    }
}
