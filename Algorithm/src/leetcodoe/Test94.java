package leetcodoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class Test94 {
     List<Integer> result=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode0=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(4);
        treeNode0.left=treeNode1;
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;

        new Test94().zxbl(treeNode0);

    }
    public   List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }
    //二叉树的中序遍历 非递归
    public void zxbl(TreeNode root){
        Stack<TreeNode> result=new Stack<TreeNode>();
        TreeNode node=root;
        while (result.size()>0 || node!=null){
            if(node!=null)
            {
                result.push(node);
                node=node.left;
            }
            else
            {
                node=result.pop();
                System.out.println(node.val);
                node=node.right;
            }
        }
    }
    public void theInOrderTraversal_Stack(TreeNode root) {  //中序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
