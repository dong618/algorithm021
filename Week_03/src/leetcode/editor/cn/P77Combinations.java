//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 454 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k,1, path, res);
        return res;
    }

    private void dfs(int n, int k,int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 1 写终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        //处理当前逻辑
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            //下一个起点
            dfs(n,k,i+1,path,res);
            // 清理当前层
            path.removeLast();
        }

    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}