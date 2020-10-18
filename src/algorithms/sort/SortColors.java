package algorithms.sort;

/**
 * @author twt
 * @description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/14
 */
public class SortColors {

    /**
     * 偷懒用下自带的库
     *
     * @param nums
     */
    /*public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }*/


    /**
     * 哈希思想
     * 1.创建长度为3的数组，分别存放三种颜色
     * 2.遍历长度为3的数组
     *
     * @param nums
     */
    /*public void sortColors(int[] nums) {
        int[] colorKind = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colorKind[nums[i]] += 1;
        }

        int index = 0;
        for (int i = 0; i < colorKind.length; i++) {
            int num = colorKind[i];
            while (num > 0) {
                nums[index++] = i;
                num--;
            }
        }
    }*/

    /**
     * 单指针交换
     *
     * @param nums
     */
    /*public void sortColors(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[p];
                nums[p] = 0;
                nums[i] = temp;
                p++;
            }
        }

        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[p];
                nums[p] = 1;
                nums[i] = temp;
                p++;
            }
        }

    }*/

    /**
     * 双指针交换
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < p2; i++) {
            while (nums[i] == 2 && i < p2) {
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
            }

            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(arr);
    }
}
