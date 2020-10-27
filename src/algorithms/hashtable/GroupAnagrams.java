package algorithms.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
     * 1.将每个字符串排序
     * 2.哈希表添加
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String[] clone = strs.clone();
        for (int i = 0; i < strs.length; i++) {
            //strs[i]=
        }

        return null;
    }

    public static void main(String[] args) {
        String str = "cab";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));

        String[] arr = {"qw", "ert"};
        String[] clone = arr.clone();
        arr[0] = "wq";
        System.out.println(Arrays.toString(clone));
        System.out.println(Arrays.toString(arr));
    }
}
