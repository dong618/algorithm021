//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1736 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：删除排序数组中的重复项
public class P26RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        // TO TEST
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @author dongxujiao
         * @description 思路2：删除重复的数组 = 将不重复的数组移到左侧         *
         * 设置两个指针 一个在前prev 一个在后next
         * 1.比较prev和next所在位置的元素是否相等
         * 相等：next后移一位
         * 不相等：将next位置的元素复制到prev+1,同时将next和prev都后移一位，直到prev=数组长度
         * 返回prev+1是新数组的长度
         * 先按照逻辑写代码而后整理
         * 参考：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
         * @date 2020-12-02 16:57
         * @param  nums
         * @return int
         */
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int prev = 0,next = 1;
            while (next < nums.length) {
                if ( nums[prev] != nums[next]){
                    nums[++prev] = nums[next];
                }
                next++;
            }
            return prev + 1;
        }

        public int removeDuplicates2(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int prev = 0,next = 1;
            while (next < nums.length) {
                if ( nums[prev] == nums[next]){
                    next++;
                }else{
                    nums[prev+1] = nums[next];
                    prev++;
                    next++;
                }

            }
            return prev + 1;
        }
        /**
         * @author dongxujiao
         * @description 依次比较
         * 思路1：
         * 定义起始位置 i
         * 将第一个元素和后面的每个元素进行比较
         * 不相等： i++; 并将第二个元素和后面的元素依次比较
         * √ 测试[1,1,2] 可以输出长度2
         * √ 测试[0,0,1,1,1,2,2,3,3,4] 输出长度5
         * @date 2020-12-02 16:29
         * @param  nums
         * @return
         */
        public int removeDuplicates1(int[] nums) {
            //元素的起始位置
            int i = 0;
            //比较第一个元素与第二个元素之后的每个值
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}