//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 313 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：有效的字母异位词
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        System.out.println(solution.isAnagram3("abcc","bacc"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @author dongxujiao
     * @description 考虑Unicode 利用map记录每个字符的频次
     * 时间复杂度：O(n)，其中 n 为 s 的长度。     *
     * 空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。
     * @date 2020-12-10 09:44
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
            if ( map.get(ch) < 0 ){
                return false;
            }
        }

        return true;

    }
    /**
     * @author dongxujiao
     * @description 利用hash表 定义一个len=26的数组，
     * 对于s中的出现的字母进行计数 ++
     * 对于t中出现的字母进行 --
     * 如果出现 < 0的则返回false
     * @date 2020-12-10 09:23
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int cnt = arr[t.charAt(i) - 'a']--;
            if ( cnt-1 < 0 ){
                return false;
            }
        }

        return true;

    }
    /**
     * @author dongxujiao
     * @description 先理解题目 字母异位词 指：字母相同,但排列不同的字符串
     * 利用数组：将转化为char 排序之后再比较
     * 时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)，
     * 因此总体时间复杂度为 O(nlogn+n)=O(nlogn)。
     * 空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。
     * @date 2020-12-10 08:40
     * @param s
     * @param t
     * @return boolean
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //将数组转化为char 排序之后再进行比较
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}