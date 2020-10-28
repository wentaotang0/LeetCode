package algorithms.hashtable;

import java.util.*;

/**
 * @Description 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/27
 */
public class GroupAnagrams {

    /**
     * 思想：字母异位词指字母相同，但排列不同的字符串。即每个字符出现的个数相等
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();

            //每次进来需要重置count
            Arrays.fill(count, 0);
            for (char c : chars) {
                count[c - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                //添加“#”是因为存在num是10，1这种情况导致append后为101造成相同的key
                sb.append("#");
                sb.append(num);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
	
	  /**
     * 1.将每个字符串排序
     * 2.哈希表添加
     *
     * @param strs
     * @return
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String[] clone = strs.clone();
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strs[i] = String.valueOf(chars);
        }

        for (int i = 0; i < length; i++) {
            List<String> list = map.get(strs[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(clone[i]);
            map.put(strs[i], list);
        }
        ArrayList<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }*/

    /**
     * 字符串排序优化
     *
     * @param strs
     * @return
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }*/

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        sb.append("#").append(1);
        System.out.println(sb.toString());
    }
}
