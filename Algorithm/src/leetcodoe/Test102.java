package leetcodoe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 */
public class Test102 {
    public static void main(String[] args) {

        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(4);
        TreeNode treeNode4=new TreeNode(5);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode3.left=treeNode4;


        levelOrder(treeNode);
    }
    public static   List<List<Integer>> levelOrder(TreeNode root)
    {

            if(root==null)
                return new ArrayList<>();
                        TreeNode node=root;
            Queue<TreeNode> treeNodes=new ArrayDeque<>();
            treeNodes.offer(node);
            List<List<Integer>> result=new ArrayList<>();
            while (!treeNodes.isEmpty()||node==null){

                int size=treeNodes.size();
                List<Integer> integers=new ArrayList<>();
                while (size>0)
                {
                    TreeNode treeNode=treeNodes.poll();
                    integers.add(treeNode.val);
                    if(treeNode.left!=null){
                        treeNodes.offer(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        treeNodes.offer(treeNode.right);
                    }

                    size--;
                }
                System.out.println(integers);
                result.add(integers);
            }
        return result;
    }
}
//dfs遍历二叉树
class Solution1
{
    List<List<Integer>> levels=new ArrayList<>();

    public void helper(TreeNode node,int level){
        //这一层还没有ArrayList
        if(levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        if(node.left!=null){
            helper(node.left,level+1);
        }
        if(node.right!=null){
            helper(node.right,level+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);
        return levels;
    }


}