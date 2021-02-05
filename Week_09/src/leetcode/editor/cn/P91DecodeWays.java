package leetcode.editor.cn;
//Java：解码方法
public class P91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        //一个数字只有一种
        dp[0] = 1;
        //0x是0种，两个数字只有1种
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) < '7')){
                // 10 20
                if (s.charAt(i) == '0'){
                    dp[i+1] = dp[i-1];
                }else{
                    dp[i+1] = dp[i] + dp[i-1];
                }
            }else if(s.charAt(i) == '0'){
                //0 30 40...
                return  0;
            }else {
                //i和i-1 无法构成字母
                dp[i+1] = dp[i];
            }
        }
        return  dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
