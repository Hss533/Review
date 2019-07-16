package leetcodoe;

/**
 * 对称的二叉树
 */
public class Test101
{
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {

        return help(root,root);
    }
    public static boolean help(TreeNode root1,TreeNode root2)
    {
        if(root1==null&&root2==null)
            return true;
        else if(root1==null ||root2!=null)
            return false;
        return (root1.val==root2.val)&&help(
                root1.left,root2.right
        )&&help(root2.left,root1.right);
    }
}
