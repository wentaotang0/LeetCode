package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twt
 * @description 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/07
 */
public class Hanota {

    /**
     * 骚操作
     *
     * @param A
     * @param B
     * @param C
     */
    /*public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        C.addAll(A);
        A.clear();
    }*/


    /**
     * 分治+递归
     * n = 1 时，直接把盘子从 A 移到 C；
     * n > 1 时，
     * 先把上面 n - 1 个盘子从 A 移到 B（子问题，递归）；
     * 再将最大的盘子从 A 移到 C；
     * 再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归）。
     *
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }


    /**
     * 将A的前size个元素移动到C
     * @param size
     * @param A
     * @param B
     * @param C
     */
    private void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {

        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        new Hanota().hanota(A, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
}
