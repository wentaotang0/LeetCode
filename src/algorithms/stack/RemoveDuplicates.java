package algorithms.stack;

/**
 * @author twt
 * @description 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/23
 */
public class RemoveDuplicates {


    /**
     * 遍历字符串中的字符，遍历一个往栈里面push一个，push的之前判断字符与peek字符是否一样，一样栈则pop，不一样完成push。
     * 最后pop完栈中的所有字符为字符串，反转后即为结果。
     *
     * @param S
     * @return
     */
   /* public String removeDuplicates(String S) {
        if (S == null) return null;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            //为空直接push，跳过本次遍历
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }

            if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }*/


    /**
     * 优化版
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        if (S == null) return null;
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (sbLength != 0 && (c == sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
                sbLength--;
            } else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
    }

}
