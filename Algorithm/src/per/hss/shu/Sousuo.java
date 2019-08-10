package per.hss.shu;

public class Sousuo {
    public static void main(String[] args) {

    }
    /**
     *
     * 判断二叉搜索树
     * 左子树最大值小于根节点
     * 右子树最小值大于根节点
     *
     * 中序遍历的是递增的
     * 左->根->右
     */


    public boolean test(TreeNode node,int min,int max)
    {
        if(node==null)return true;
        if(min!=0&& node.value<=min)return false;
        if(max!=0&& node.value>=max)return false;

        return  test(node.leftNode,min,node.value)&&test(node.rightNode,node.value,max);

    }

}
