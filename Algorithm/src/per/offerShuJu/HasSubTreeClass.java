package per.offerShuJu;

import java.util.Stack;

public class HasSubTreeClass
{
    Stack<TreeNode> stack1=new Stack<>();
    Stack<TreeNode> stack2=new Stack<>();

    public boolean HasSubtree(TreeNode root1,TreeNode root2)
    {
        /*if(root2==null||root1==null)
            return false;
        while ()
        {

        }*/
         return true;
    }
    public void Print(TreeNode treeNode)
    {
        if(stack1!=null)
        stack1.add(treeNode);
        while(true)
        {
            if(stack1==null&&stack1==null)
                break;
            while (!stack1.isEmpty())
            {
                if(stack1.pop()!=null)
                {
                    stack1.pop();
                    stack2.push(stack1.pop().left);
                    stack2.push(stack1.pop().left);

                }

            }
            while (!stack2.isEmpty())
            {
                if(stack2.pop()!=null)
                {
                    stack1.pop();
                    stack1.push(stack2.pop().left);
                    stack1.push(stack2.pop().right);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
