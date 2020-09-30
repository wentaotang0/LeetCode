package algorithms.queue;

/**
 * @Description 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * <p>
 * 请你实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * <p>
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [<u>1</u>]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [<u>1</u>, <u>100</u>]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002</u>]，范围是 [2,3002]，返回 3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= t <= 104
 * 保证每次对 ping 的调用都使用比之前更大的 t 值
 * 至多调用 ping 方法 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/29
 */

import java.util.LinkedList;
import java.util.Queue;


public class RecentCounter {


    /**
     * 暴力
     */
    /*private List<Integer> times;


    public RecentCounter() {
        //当前时间集合
        times = new ArrayList();
    }

    public int ping(int t) {

        if (times.isEmpty()) {
            times.add(t);
            return 1;
        }

        int num = 1;
        int begin = t - 3000;
        for (int i = times.size() - 1; i >= 0; i--) {
            int preTime = times.get(i);
            if (begin <= preTime) {
                num++;
            } else {
                break;
            }
        }
        times.add(t);
        return num;
    }*/

    //使用队列，队列的长度为当前时间的3000ms内的请求个数
    private Queue<Integer> times;

    public RecentCounter() {
        times = new LinkedList<>();
    }

    public int ping(int t) {
        times.add(t);
        int begin = t - 3000;
        while (begin > times.peek()) {
            times.poll();
        }
        return times.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
