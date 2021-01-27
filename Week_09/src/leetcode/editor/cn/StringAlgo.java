package leetcode.editor.cn;

/**
 * @author doongxujiao
 * @version V1.0
 * @package leetcode.editor.cn
 * @description TODO
 * @date 2021/1/27
 * @Copyright 2020 nuoyun All rights reserved.
 */
public class StringAlgo {

    public static void main(String[] args) {
        String str = "65535";
        System.out.println(myAtoi(str));
        System.out.println(Integer.parseInt(str));

    }
    public static int myAtoi(String str){
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
