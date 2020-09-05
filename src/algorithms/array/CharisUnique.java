package algorithms.array;

/**
 * @author twt
 * @description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/04
 */
public class CharisUnique {

    /**
     * 使用额外空间
     *
     * @param astr
     * @return
     */
    /*public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (set.contains(c)) return false;
            set.add(c);
        }

        return true;
    }*/


    /**
     *不用额外空间，参考别人滴
     * 由于字符的ASCII值范围为0-127即128个，所以可以用两个long来表示。
     * long8个字节，每个字节8位，所以两个long总共2*8*8=128位，每一位用1表示出现过，0表示没出现。
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {

        long high64 = 0L;
        long low64 = 0L;

        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //64-128
            if (c>=64){
                long binIndex = 1L << (c - 64);
                if ((high64&binIndex)!=0){
                    return false;
                }
                //相当于保存前面的字符
                high64|=binIndex;
                //0-63
            }else {
                long binIndex = 1L << c;
                if ((low64&binIndex)!=0){
                    return false;
                }
                low64|=binIndex;
            }
        }
        return true;
    }



}
