package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author twt
 * @description 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * intervals[i][0] <= intervals[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/12
 */
public class MergeIntervals {

    /**
     * 1.先根据区间的起始位置排序
     * 2.添加区间，当前区间开始位置大于上一个区间的结束位置则不合并，否则更新上一个区间的结束位置为当前区间的结束位置和上个区间结束位置的最大值
     * 因为存在[[1,4],[2,3]]
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //第一个区间
            if (list.size() == 0) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                continue;
            }
            //当前前区间开始位置小于等于上一个区间的结束位置
            int preR = list.get(list.size() - 1)[1];
            if (intervals[i][0] <= preR) {
                int[] pre = list.get(list.size() - 1);
                pre[1] = Math.max(intervals[i][1], preR);
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }

        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {0, 2}, {3, 5}};
        MergeIntervals intervals = new MergeIntervals();
        intervals.merge(arr);
    }
}
