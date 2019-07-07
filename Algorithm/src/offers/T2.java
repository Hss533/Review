package offers;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 序列化二叉树 和反序列化二叉树
 */
public class T2 {
    static int index=-1;
    public static void main(String[] args)
    {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n4.right=n5;

//        System.out.println(Serialize(n1));
        TreeNode test=Deserialize("8,6,10,5,7,9,11");
        System.out.println(Serialize(test));
    }
    static String Serialize(TreeNode root) {
        StringBuffer result=new StringBuffer("");
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                result.append(root.val+",");
                stack.push(root);
                root=root.left;
            }
            else {
                result.append("#,");
                root=stack.pop();
                root=root.right;
            }
        }


        String s=result.toString();

//        System.out.println(s.substring(0,s.length()-1));
        return s.substring(0,s.length()-1);
    }
    static TreeNode Deserialize(String str) {

        TreeNode head = null;
        if(str == null || str.length() == 0)
            return head;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++){
            if(!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        for(int i=0, j=1; j<treeNodes.length; i++){
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }
}
