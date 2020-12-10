package leetcode.editor.cn;

/**
 * @author doongxujiao
 * @version V1.0
 * @package leetcode.editor.cn
 * @description TODO
 * @date 2020/12/10
 * @Copyright 2020 nuoyun All rights reserved.
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
