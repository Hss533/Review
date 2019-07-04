package leetcodoe;

public class Test104 {
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n4.right=n5;
        System.out.println(maxDepth(n1));
    }
    public  static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
