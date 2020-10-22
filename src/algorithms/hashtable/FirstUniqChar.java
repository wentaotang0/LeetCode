package algorithms.hashtable;

/**
 * @author twt
 * @description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/22
 */
public class FirstUniqChar {


    /**
     * 哈希表记录字符个数，遍历字符串
     *
     * @param s
     * @return
     */
    /*public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.replace(c, 1 + map.get(c));
            } else {
                map.put(c, 1);
            }
        }


        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]).equals(1)) {
                return i;
            }
        }
        return -1;
    }
*/

    /**
     * 数组代替map
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a'] += 1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
