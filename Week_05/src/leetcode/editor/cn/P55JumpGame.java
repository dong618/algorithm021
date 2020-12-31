package leetcode.editor.cn;
//Java：跳跃游戏
public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int move = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (i <= move) {
                //去最大可移动的步数
                move = Math.max(move, i + nums[i]);
                if (move >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
