package before20200830;

/**
 * @author twt
 * @description 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/03/17
 */
public class CountCharacters {


    /**
     * @param words 词汇表
     * @param chars 单词表
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int[] countChars = count(chars);
        int res = 0;
        for (String word : words) {
            int[] countWord = count(word);
            if (countains(countWord, countChars)) res+=word.length();
        }

        return res;
    }



    boolean countains(int[] countWord, int[] countChars) {
        for (int i = 0; i < 26; i++) {
            if (countChars[i] < countWord[i]) return false;//词汇表中每个字母出现的个数小于字母表
        }
        return true;
    }


    /**
     * 第一个位置代表a，第二个位置代表b，以此类推，每个位置存放字母的个数
     *
     * @param str
     * @return
     */
    int[] count(String str) {
        int[] cou = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cou[c - 'a']++;
        }
        return cou;
    }


    public static void main(String[] args) {

        CountCharacters characters = new CountCharacters();
        String []w = {"cat","bt","hat","tree"};
        String c = "atach";
        System.out.println(characters.countCharacters(w, c));

    }
}
