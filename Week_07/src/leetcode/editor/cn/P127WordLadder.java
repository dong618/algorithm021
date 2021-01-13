package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词接龙
public class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList1) {
            // List的查询复杂度为O(n) 转为HashSet,查询复杂度为O(1)
            Set<String> wordList = new HashSet<String>(wordList1);
            //定义begin end
            Set<String> beginSet = new HashSet<String>();
            Set<String> endSet = new HashSet<String>();

            int len = 1;
            int strLen = beginWord.length();
            //定义visited
            Set<String> visited = new HashSet<String>();

            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                //从比较小的set开始遍历
                if (beginSet.size() > endSet.size()) {
                    Set<String> tmp = beginSet;
                    beginSet = endSet;
                    endSet = tmp;
                }

                Set<String> temp = new HashSet<String>();
                for (String word : beginSet) {
                    char[] chs = word.toCharArray();

                    for (int i = 0; i < chs.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = chs[i];
                            chs[i] = c;
                            String target = String.valueOf(chs);

                            //如果与endSet重合，则找到目标元素
                            if (endSet.contains(target)) {
                                return len + 1;
                            }

                            //如果没有，则继续下一层搜索
                            if (!visited.contains(target) && wordList.contains(target)) {
                                temp.add(target);
                                visited.add(target);
                            }
                            chs[i] = old;
                        }
                    }
                }
                beginSet = temp;
                len++ ;
            }

            return  0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
