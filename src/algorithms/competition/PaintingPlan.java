package algorithms.competition;

/**
 * @author twt
 * @description 小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
 * <p>
 * 小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
 * <p>
 * 注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, k = 2
 * <p>
 * 输出：4
 * <p>
 * 解释：一共有四种不同的方案：
 * 第一种方案：涂第一列；
 * 第二种方案：涂第二列；
 * 第三种方案：涂第一行；
 * 第四种方案：涂第二行。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：不可行，因为第一次涂色至少会涂两个黑格。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 2, k = 4
 * <p>
 * 输出：1
 * <p>
 * 解释：共有 2*2=4 个格子，仅有一种涂色方案。
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 6
 * 0 <= k <= n * n
 * 通过次数1,182提交次数5,829
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ccw6C7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/19
 */
public class PaintingPlan {

    /**
     * 暂时没做出来
     *
     * @param n
     * @param k
     * @return
     */
    public int paintingPlan(int n, int k) {

        if (k < n || (k % n) != 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        if (k == n * n) {
            return 1;
        }

        if (k / n == 1) {
            return n * 2;
        }

        int i = 1;
        int ans = 1;
        int j = k / n;
        while (i <= j) {
            ans *= (n - i + 1);
            i++;
        }
        ans /= (j * (j - 1));
        return ans * 2;
    }

    public static void main(String[] args) {
//        System.out.println(new PaintingPlan().paintingPlan(4, 8));
        System.out.println(Math.pow(2, 4));
    }
}
