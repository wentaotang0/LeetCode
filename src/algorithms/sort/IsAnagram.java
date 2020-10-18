package algorithms.sort;

import java.util.Arrays;

/**
 * @author twt
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/10
 */
public class IsAnagram {


    /**
     * 使用数组，类似哈希的思想
     *
     * @param s
     * @param t
     * @return
     */
    /*public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] arr1 = new int['z' - 'a' + 1];
        int[] arr2 = new int['z' - 'a' + 1];
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            arr1[c1[i] - 'a'] += 1;
        }

        for (int i = 0; i < c2.length; i++) {
            arr2[c2[i] - 'a'] += 1;
        }

        for (int i = 0; i < ('z' - 'a' + 1); i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }*/

    /**
     * 数组优化版
     * @param s
     * @param t
     * @return
     */
    /*public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] counter = new int['z' - 'a' + 1];
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            counter[c1[i] - 'a'] += 1;
            counter[c2[i] - 'a'] -= 1;
        }

        for (int i = 0; i < ('z' - 'a' + 1); i++) {
            if (counter[i] != 0) return false;
        }

        return true;
    }*/

    /**
     * 排序
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }


    public static void main(String[] args) {
        System.out.println('a' + 0);
        System.out.println('z' + 0);
    }
}
