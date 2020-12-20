package algorithms.hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author twt
 * @description 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/16
 */
public class WordPattern {


    /**
     * 哈希
     * 一一对应关系
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        String[] words = s.split(" ");
        //长度不相等不符合
        if (patternChars.length != words.length) return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < patternChars.length; i++) {
            if (!map1.containsKey(patternChars[i]) && !map2.containsKey(words[i])) {
                map1.put(patternChars[i], words[i]);
                map2.put(words[i], patternChars[i]);
                continue;
            }
            if (!words[i].equals(map1.get(patternChars[i]))) return false;
            if (!(patternChars[i] == map2.get(words[i]).charValue())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, false);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey() + "," + e.getValue());
        }
        //System.out.println(linkedHashMap);
        //linkedHashMap.put(4,2);
        //linkedHashMap.get(1);
        //System.out.println(linkedHashMap);
    }
}
