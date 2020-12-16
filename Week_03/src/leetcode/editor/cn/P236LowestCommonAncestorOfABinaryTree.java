//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 866 👎 0


package leetcode.editor.cn;
//Java：二叉树的最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * @author dongxujiao
     * @description 题目比较复杂，开始有些吃力，先按照题解写一遍，理解吧。
     *
     * @date 2020-12-16 14:34
     * @param root
     * @param p
     * @param q
     * @return leetcode.editor.cn.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.递归终止条件，如果root=p 或者 q 则返回root
        if (root == p || root == q) {
            return root;
        }
        //2.处理当前逻辑
        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);
            if (lNode != null && rNode != null) {
                return root;
            }else if ( lNode == null) { //都在右子树
                return rNode;
            }else if (rNode == null) {
                return lNode;
            }
        }
        return  null;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}