package leetcode.editor.cn;

//Java：最小路径和
public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @author dongxujiao
     * @description 这部分比较难，先默写别人的代码吧。
     * @date 2021-01-08 17:17
     * @param grid
     * @return int
     */
    public int minPathSum(int[][] grid) {
        //获取grid的长度
        int len = grid[0].length;
        //定义dp
        int[] dp = new int[len];
        //起始位置
        dp[0] = grid[0][0];
        //统计向右走
        for (int i = 1; i < len; i++){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            //向下走
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < len; j++){
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }
        return dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
