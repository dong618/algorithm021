//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 437 👎 0


package leetcode.editor.cn;
//Java：丑数 II
public class P264UglyNumberIi{
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @author dongxujiao
     * @description 参考官网，先默写 采用动态规划
     * @date 2020-12-10 16:30
     * @param n
     * @return int
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if ( dp[i] == n2) a++;
            if ( dp[i] == n3) b++;
            if ( dp[i] == n5) c++;
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}