//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 473 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * @author dongxujiao
     * @description 参考之前的中序遍历，采用颜色标记法
     * @date 2020-12-10 15:52
     * @param root
     * @return List<Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null) {
            return res;
        }

        Stack<ColorNode> stack = new Stack<ColorNode>();
        //将新节点标记为白色
        stack.push(new ColorNode(root, "white"));


        while (!stack.empty()) {
            ColorNode cn = stack.pop();
            TreeNode node = cn.node;

            //然后依次访问节点进行入栈：右-左-根
            if ("white".equals(cn.color)) {
                if (node.right != null) {
                    stack.push(new ColorNode(node.right,"white"));
                }
                if (node.left != null) {
                    stack.push(new ColorNode(node.left,"white"));
                }
                stack.push(new ColorNode(node,"gray"));
            }else{
                res.add(node.val);
            }

        }

        return res;
    }

    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}