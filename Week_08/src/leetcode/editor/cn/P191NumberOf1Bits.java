package leetcode.editor.cn;
//Java：位1的个数
public class P191NumberOf1Bits{
    public static void main(String[] args) {
        Solution solution = new P191NumberOf1Bits().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int cnt = 0;
            while ( n != 0) {
                cnt++;
                n = n & (n-1); //清零操作
            }
            return cnt;
        }

        /**
         * @author dongxujiao
         * @description 循环，利用左移
         * @date 2021-01-22 12:14
          * @param n
         * @return int
         */
        public int hammingWeight1(int n) {
            int cnt = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                //确认最低位是否为0
                if ((n & mask)!=0) {
                    cnt ++;
                }
                mask <<= 1;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
