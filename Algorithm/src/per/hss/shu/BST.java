package per.hss.shu;

public class BST {
    Node root;
    int n=1; // 结点总数
    private class Node{
        Integer data;
        Node lchild, rchild;
    }
    /*public BST(){
        build(); // 递归构造
        System.out.println("根结点：" + root.data);
        btDepth();
    }*/
    /**
     * 构造一棵二叉排序树
     */
    public void build(){
//        Integer[] ins = new Integer[] { 8, 4, 9, 2, 7, 5, 6 };
        Integer[] ins = new Integer[] { 8, 4, 2, 7, 5, 6, 16, 10, 9, 14, 15, 11, 12};
        root = new Node();
        root.data = ins[0];
        for (int i = 1; i < ins.length; i++) {
            insert(root, ins[i]);
            n++;
        }
    }
    public static void main(String[] args) {
        BST a=new BST();
        a.build();
    }
    public Node insert(Node node, Integer info){
        if(node == null){
            node = new Node();
            node.data = info;
        }
        if(info < node.data){
            node.lchild = insert(node.lchild, info);
        } else if(info > node.data){
            node.rchild = insert(node.rchild, info);
        } else { }
        return node;
    }
}
