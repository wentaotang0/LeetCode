package algorithms.before20200830;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author twt   广度优先-图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 * <p>
 * image 和 image[0] 的长度在范围 [1, 50] 内。
 * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description
 * @date 2020/08/16
 */
public class BFSFloodFill {


    private final int[] xarr = {-1, 1, 0, 0};
    private final int[] yarr = {0, 0, -1, 1};

    /**
     * 深度优先
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int m = image.length;
        int n = image[0].length;
        int initColor = image[sr][sc];
        if (initColor == newColor) return image;

        Queue q = new LinkedList<int[]>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] head = (int[]) q.poll();
            int x = head[0];
            int y = head[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + xarr[i];
                int newy = y + yarr[i];
                if (0 <= newX && newX < m && 0 <= newy && newy < n && image[newX][newy] == initColor) {
                    image[newX][newy] = newColor;
                    q.offer(new int[]{newX, newy});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 1}};
        int[][] ints = new BFSFloodFill().floodFill(arr, 1, 1, 1);
    }
}

class DFSFloodFill {

    private final int[] xarr = {-1, 1, 0, 0};
    private final int[] yarr = {0, 0, -1, 1};

    private int m;
    private int n;

    /**
     * 广度优先
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        m = image.length;
        n = image[0].length;

        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {

        if (image[sr][sc] == currentColor) {
            image[sr][sc] = newColor;

            for (int i = 0; i < 4; i++) {
                int newX = xarr[i] + sr;
                int newy = yarr[i] + sc;
                if (0 <= newX && newX < m && 0 <= newy && newy < n) {
                    dfs(image, newX, newy, currentColor, newColor);
                }

            }

        }
    }

    public static void main(String[] args) {

    }

}
