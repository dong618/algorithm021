package leetcode.editor.cn;
//Java：字符串转换整数 (atoi)
public class P8StringToIntegerAtoi{
    public static void main(String[] args) {
        Solution solution = new P8StringToIntegerAtoi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String str) {
        int index = 0,sign = 1,total = 0;
        //1. 空串
        if (str.length() == 0) {
            return  0;
        }
        //2. 移除空格
        while(str.charAt(index) == ' ' && index < str.length()){
            index++;
        }
        //3. 处理标志
        if (str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        //4. 转换数字同时避免溢出
        while (index<str.length()){
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit>9){
                break;
            }

            //检查total，并添加数字
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            }
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
