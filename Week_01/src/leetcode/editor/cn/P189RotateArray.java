//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 744 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：旋转数组
public class P189RotateArray{
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
        int[] nums = new int[]{1,2,3,4,5,6,7};
//        solution.rotate1(nums,3);
        solution.rotate4(nums,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @author dongxujiao
         * @description 思路4
         * 使用反转
         * 1. 将所有元素反转
         * 2. 反转前k个元素
         * 3. 反转len-k个元素
         * 时间复杂度：O(n) 。 n 个元素被反转了总共 3 次。
         * 空间复杂度：O(1) 。 没有使用额外的空间
         * @date 2020-12-03 10:00
         * @param nums
         * @param k
         * @return void
         */
        public void rotate4(int[] nums, int k) {
            int len = nums.length;
            //如果k>len 则只需要旋转 k%len 次
            k = k % len;
            reverse(nums,0,len-1);
            reverse(nums,0,k-1);
            reverse(nums,k,len-1);
            System.out.println(Arrays.toString(nums));
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        /**
         * @author dongxujiao
         * @description 思路3
         * 利用新的数组 将坐标i位置的元素移动到（i+k）% nums.length
         * 时间复杂度 O(k*n)
         * 空间复杂度 O(n) 建立了新的数组
         * @date 2020-12-03 10:00
         * @param nums
         * @param k
         * @return void
         */
        public void rotate3(int[] nums, int k) {
            int len = nums.length;
            int[] newArr = new int[len];
            for(int i = 0; i < len; i++ ){
                newArr[(i+k)%len] = nums[i];
            }
            // leetcode 官网执行错误，需要循环赋值
            // nums = newArr;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = newArr[i];
            }
            System.out.println(Arrays.toString(nums));
        }

        /**
         * @author dongxujiao
         * @description 思路2
         * 利用新的数组
         * 1 将最后的k个元素 移动到 0到k-1的位置
         * 2 将开始的len-k个元素 移动到 k到len的位置
         * 时间复杂度 O(n)
         * 空间复杂度 O(n) 建立了新的数组
         * @date 2020-12-03 10:00
         * @param nums
         * @param k
         * @return void
         */
        public void rotate2(int[] nums, int k) {
            int len = nums.length;
            int[] newArr = new int[len];
            int i = 0;
            // 将最后的k个元素 移动到 0到k-1的位置
            for(int j = len-k; j < len; j++ ){
                newArr[i++] = nums[j];
            }
            // 将开始的len-k个元素 移动到 k到len的位置
            for(int j = 0; j < len-k; j++ ){
                newArr[i++] = nums[j];
            }
            // leetcode 官网执行错误，需要循环赋值
            // nums = newArr;
            for (int j = 0; j < nums.length; i++) {
                nums[j] = newArr[j];
            }
            System.out.println(Arrays.toString(nums));
        }


        /**
         * @author dongxujiao
         * @description 思路1
         * 根据需要翻转的次数，循环数组，每次移动一个
         * 时间复杂度 O(k*n)
         * 空间复杂度 O(1)
         * @date 2020-12-03 10:00
         * @param nums
         * @param k
         * @return void
         */
        public void rotate1(int[] nums, int k) {
            for(int i = 0; i < k ; i++){
                int len = nums.length;
                int last = nums[len-1];
                for(int j = 0; j < len-1; j++ ){
                    nums[len-j-1] = nums[len-j-2];
                }
                nums[0] = last;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}