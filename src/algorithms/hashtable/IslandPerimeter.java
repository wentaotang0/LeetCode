package algorithms.hashtable;

/**
 * @author twt
 * @description 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0]]
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/23
 */
public class IslandPerimeter {

    /**
     * 小岛的周长为每个陆地的周长（边长*4）减去每个陆地间重合的部分。
     * 所以遇到小岛后可以向左、右、上、下、走一走看看有没有重合
     *
     * @param grid
     * @return
     */
    /*public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int island = grid[i][j];
                if (island == 0) continue;
                island *= 4;
                //向左
                if (j - 1 >= 0 && grid[i][j - 1] == 1) island -= 1;
                //向右
                if (j + 1 <= grid[i].length - 1 && grid[i][j + 1] == 1) island -= 1;
                //向上
                if (i - 1 >= 0 && grid[i - 1][j] == 1) island -= 1;
                //向下
                if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 1) island -= 1;
                ans += island;
            }
        }
        return ans;
    }*/


    //上下左右四个方向
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};


    /**
     * dfs思路
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;//对应dx
        int n = grid[0].length;//对应dy
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //存在陆地和陆地不相连的情况，所以每次遇到陆地都需要dfs，不然可以一次dfs
                if (grid[i][j] == 1) {
                    ans += dfs(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        //越界或者周边是水域
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 1;

        //防止陷入死循环
        if (grid[i][j] == 2) return 0;
        grid[i][j] = 2;

        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            ans += dfs(grid, x, y, m, n);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().islandPerimeter(arr));
    }
}
