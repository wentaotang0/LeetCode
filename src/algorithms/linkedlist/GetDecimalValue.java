package algorithms.linkedlist;

/**
 * @author twt
 * @description 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/08
 */
public class GetDecimalValue {

    /**
     * 1.保存（头节点有值，一直以为头节点不保存值，被坑死了）
     * 2.计算
     *
     * @param head 链表头
     * @return
     */
   /* public int getDecimalValue(ListNode head) {

        //数组保存链表结果
        int[] node = new int[30];
        int num = 0;
        while (head != null) {
            node[num++] = head.val;
            head = head.next;
        }

        //遍历链表计算
        int result = 0, offset = 0, temp = 1;
        for (int i = num - 1; i >= 0; i--) {
            if (i != num - 1) {
                temp *= 2;
            }
            result += (node[i] * temp);
            offset++;
        }
        return result;
    }*/

    /**
     * 如果一个十进制的数字，542要和1拼接，需要542*10+1=5421
     * 如果一个二进制的数字，101要和1拼接，需要101*10+1=1011（注意按照二进制的方法计算）
     * <p>
     * 2进制表示101：（101）=（1*（10）+0）*（10）+1
     * 把101转成十进制 即：（5）=（1*（2）+0）*2+1（2进制的10，10进制为2）
     * 所以公式为：ans=ans*2+head.val
     *
     * @param head
     * @return
     */
  /*  public int getDecimalValue(ListNode head) {

        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }*/

    /**
     * 再次升级版本，使用<<和|运算符
     *
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {

        int ans = 0;
        while (head != null) {
            //代替ans = ans * 2 + head.val;左移1位即乘2，由于左移一位后，有一个位置空下来，所以可以|
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
      /*  ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        ListNode head = new ListNode(9);
        head.next = n1;
        head.next.next = n2;
        head.next.next.next = n3;
        System.out.println(new GetDecimalValue().getDecimalValue(head));*/

        int i = 10 | 8;
        System.out.println(i);
        System.out.println(10 + 8);
        System.out.println(0 << 10);
    }
}
