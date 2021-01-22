package leetcode.editor.cn;
//Java：2的幂
public class P231PowerOfTwo{
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * @author dongxujiao
     * @description 2的幂
     * 恒有 n & (n - 1) == 0，这是因为：
     * n 二进制最高位为 1，其余所有位为 0；
     * n−1 二进制最高位为 0，其余所有位为 1；
     * 一定满足 n > 0。
     *  因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^x     *
     * @date 2021-01-22 13:38
     * @param n
     * @return boolean
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
