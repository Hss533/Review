package per.offer;

import per.hss.shu.TreeNode;

import java.util.Stack;

/**
 * 把二叉排序树转换为
 */
public class Solution {
    public static void main(String[] args) {

    }
    public TreeNode Convert(TreeNode root) {

        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.leftNode;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.rightNode = p;
                p.leftNode = pre;
                pre = p;
            }
            p = p.rightNode;
        }
        return root;
    }
}
