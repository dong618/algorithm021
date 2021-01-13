package leetcode.editor.cn;
//Java：爬楼梯
public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @author dongxujiao
         * @description 根据公式统计  dp[n] = dp[n-1] + dp[n-2]
         * @date 2021-01-13 14:12
         * @param n
         * @return int
         */
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n ; i++) {
                dp[i] = dp[i-1] + dp [i-2];
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}