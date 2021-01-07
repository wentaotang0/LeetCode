package algorithms.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twt
 * @description
 * @date 2021/01/06
 */
public class FindWords {

    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();

        // 字典行
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        // 挨个单词匹配是否满足条件
        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }


    private boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // 先用word首字符确定属于哪一行
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }

        if (find == null) {
            ok = false;
            return ok;
        }

        // 判断word字符串所有字符是否都属于同一行
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        System.out.println(181338494 / 62);
        System.out.println(181338494 % 62);
    }
}
