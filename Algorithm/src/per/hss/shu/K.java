package per.hss.shu;
import java.util.ArrayList;
import java.util.Stack;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class K {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(2);
        a1.leftNode = a2;
        a1.rightNode = a3;
        a2.rightNode = a5;
        a2.leftNode = a4;
        a3.rightNode = a7;
        a3.leftNode = a6;

        K k = new K();
        System.out.println("\n-------判断二叉树是不是镜像-------");
        System.out.println(k.isSymmetrical(a1));
        System.out.println("\n-------判断二叉树是不是平衡二叉树-------");
        System.out.print(k.IsBalanced_Solution(a1));
        System.out.println("\n-------判断后续遍历是不是二叉搜索树");
        System.out.print(k.fenzhi(new int[]{2,6,7,5},0,3));
        System.out.println("\n-------中序遍历---------");
        k.innerorder(a1);
        System.out.println("\n-------先序遍历---------");
        k.preorder(a1);
        System.out.println("\n-------后序遍历---------");
        k.postorder(a1);
        System.out.println("\n-------镜像二叉树---------");
        k.Mirror(a1);
        k.preorder(a1);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        return null;
    }
    //判断二叉树是不是对称的
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;

        return f(pRoot.leftNode,pRoot.rightNode);
    }
    boolean f(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 != null && t2 != null)
            return t1.value== t2.value && f(t1.leftNode,t2.leftNode) && f(t1.leftNode, t2.leftNode);

        return false;
    }
    //二叉树的下一个结点 中序遍历
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
            return null;
        if(pNode.next==null)
            return null;
        if(pNode==null) return null;
        if(pNode.right!=null){    //如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while(pNode.left!=null) pNode = pNode.left;
            return pNode;
        }
        while(pNode.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }


    //平衡二叉树 判断一个树是不是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        int mac=deep(root);
        int Mindeep=Mindeep(root);
        if(Math.abs(mac-Mindeep)>1)
            return false;
        return true;
    }
    public int deep(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(deep(root.leftNode),deep(root.rightNode));
    }
    public int Mindeep(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.min(deep(root.leftNode),deep(root.rightNode));
    }
    //二叉树镜像
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp=root.leftNode;
        root.leftNode=root.rightNode;
        root.rightNode=temp;
        Mirror(root.leftNode);
        Mirror(root.rightNode);
    }


    //将二叉搜索树转换为排序的双向链表，不能创建新的结点
    public TreeNode Convert(TreeNode pRootOfTree) {
    return null;
    }


    //搜索树中序遍历寻找第k个
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.leftNode, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return pRoot;
            node = KthNode(pRoot.rightNode, k);
            if (node != null)
                return node;
        }
        return null;
    }
    //搜索树中序遍历寻找第k个
    TreeNode KthNode1(TreeNode root, int k) {
        if (root == null || k == 0) return null;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftNode;
            }
            root = stack.pop();
            count++;
            if (count == k) return root;
            root = root.rightNode;
        }
        return null;
    }
    //根据后续遍历，判断是不是二叉搜索树？
    boolean fenzhi(int[] a, int l, int r) {
        if(a.length==0)
            return false;
        if(l>=r)
            return true;
        int i=r;
        while (i>l&&a[i-1]>a[r])
            i--;
        for(int j=l;j<i-1;j++)
        {
            if(a[j]>a[r])
            {
                return false;
            }
        }
        return fenzhi(a,l,i-1)&&fenzhi(a,i,r-1);
    }
    //先序遍历
    void innerorder(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()) {

            if (node!=null)
            {
                stack.push(node);
                node=node.leftNode;

            }
            else{
                node = stack.pop();
                System.out.print(node.value + " ");
                node = node.rightNode;
        }
        }
    }
    //前序遍历
    void preorder(TreeNode node)
    {
        Stack<TreeNode> stack=new Stack();
        TreeNode newnode=node;
        while (newnode!=null||!stack.isEmpty())
        {
            if(newnode!=null)
            {
                System.out.print(newnode.value+" ");
                stack.push(newnode);
                newnode=newnode.leftNode;
            }
            else {
                newnode=stack.pop();
                newnode=newnode.rightNode;
            }
        }
    }
    //后续遍历
     void postorder(TreeNode root)
     {
         Stack<TreeNode> stack=new Stack<>();
         Stack<TreeNode> stack1=new Stack<>();
         TreeNode node=root;
         while (node!=null||!stack.isEmpty()) {

             if (node!=null)
             {
                 stack1.add(node);
                 stack.push(node);
                 node=node.rightNode;

             }
             else{
                 node = stack.pop();

                 node = node.leftNode;
             }
         }
         while (!stack1.isEmpty())
         {
             System.out.print(stack1.pop().value+" ");
         }
     }
}
