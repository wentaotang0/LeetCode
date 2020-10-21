package before20200830;

/**
 * @author twt
 * @description 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 * <p>
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 * <p>
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/03/24
 */
public class MassageQuestion {

    /**
     * dp[i] = max((dp[i-2]+num[i]),dp[i-1])
     * dp[i]表示预约到第i个顾客的最久休息时长,假如a=dp[i-2],b=dp[i-1],则dp[i] = max((a+num[i]),b)
     *
     * @param nums
     * @return
     */
    public int massage(int[] nums) {              
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        //数组个数为0时最久休息时长
        int a = 0;
        //数组个数为1时最久休息时长
        int b = nums[0];
        //从有两名顾客开始
        for (int i = 1; i < n; i++) {
            int max = Math.max(a + nums[i], b);
            a = b;
            b = max;
        }
        return b;
    }


}
