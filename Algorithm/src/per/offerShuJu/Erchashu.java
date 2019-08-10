package per.offerShuJu;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Erchashu {


    ArrayList<Integer> arrayList = new ArrayList<>();
    int i = 0;

    ArrayList<Integer> Print(TreeNode pRoot) {
        if (i == 0 && pRoot != null)
            arrayList.add(pRoot.val);
        i++;
        if (pRoot == null)
            return null;
        else {
            TreeNode left = pRoot.left;
            TreeNode right = pRoot.right;

            if (pRoot.left != null) {
                System.out.println(pRoot.left.val);
                arrayList.add(pRoot.left.val);
            }
            if (pRoot.right != null) {
                System.out.println(pRoot.right.val);
                arrayList.add(pRoot.right.val);
            }

            this.Print(left);
            this.Print(right);
        }
        return arrayList;
    }

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    public void PrintTree(TreeNode treeNode) {
        stack1.push(treeNode);
        while (!stack1.empty()) {
            TreeNode t = stack1.pop();
            stack2.push(t.left);
            stack2.push(t.right);
        }
        while (!stack2.empty()) {
            TreeNode t = stack2.pop();
            stack1.push(t.left);
            stack1.push(t.right);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);


            /*a.right=c;
            TreeNode d=new TreeNode(4);
            TreeNode e=new TreeNode(5);
            b.right=d;
            b.left=e;*/
        TreeNode d = null;
        System.out.println(new Erchashu().Print(a));
    }
}
