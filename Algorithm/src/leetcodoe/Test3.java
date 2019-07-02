package leetcodoe;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定2D平面上的n个点，找到位于同一直线上的最大点数。
 */
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Test3
{

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
//        n3.left=n4;
//        n2.left=n5;
        System.out.println(cengsi(n3));
    }
    public static int run(TreeNode root) {
        if(root==null)
            return 0;
        else {
            int left=run(root.left);
            int right=run(root.right);
            return Math.min(left,right)+1;
        }
    }
    public static  int cengsi(TreeNode root)
    {
        if(root==null)
            return 0;
        Queue<TreeNode> treeNodes=new ArrayDeque<>();
        treeNodes.offer(root);
        int i=0;
        while (!treeNodes.isEmpty())
        {
            int size=treeNodes.size();
            i++;
            while (size!=0){
                TreeNode a=treeNodes.poll();
                if(a.left==null&&a.right==null)
                    return i;
                if(a.left!=null)
                {
                    treeNodes.offer(a.left);
                }
                if(a.right!=null)
                {
                    treeNodes.offer(a.right);
                }
                size--;
            }
        }
        return i;
    }
}
