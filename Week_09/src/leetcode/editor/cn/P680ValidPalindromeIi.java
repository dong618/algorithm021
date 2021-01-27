package leetcode.editor.cn;
//Java：验证回文字符串 Ⅱ
public class P680ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new P680ValidPalindromeIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return validPalindromeUtil(s, start + 1, end) || validPalindromeUtil(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindromeUtil(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
