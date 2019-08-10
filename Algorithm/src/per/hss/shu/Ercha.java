package per.hss.shu;

import java.util.*;

/**
 * 二叉树的之字形遍历
 */
public class Ercha {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);

        treeNode1.leftNode=treeNode2;
        treeNode1.rightNode=treeNode3;
        treeNode2.leftNode=treeNode4;
        treeNode2.rightNode=treeNode5;
        treeNode3.leftNode=treeNode6;
        treeNode3.rightNode=treeNode7;


        //new Ercha().Print(treeNode1);
      /*  String str=new Ercha().Serialize(treeNode1);
        System.out.println(str);*/
        new Ercha().Deserialize("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,");
    }
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value + ",");
        sb.append(Serialize(root.leftNode));
        sb.append(Serialize(root.rightNode));
        return sb.toString();
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        System.out.println(str);
        index++;
        //int len = str.length();
        //if(index >= len){
        //    return null;
        // }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.leftNode= Deserialize(str);
            node.rightNode = Deserialize(str);
        }
        return node;
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if(pRoot==null)
            return new ArrayList<>();
        Queue<TreeNode> treeNodes=new ArrayDeque<>();
        treeNodes.offer(pRoot);
        int index=1;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        while (!treeNodes.isEmpty())
        {
            int size=treeNodes.size();
            ArrayList<Integer> arrayList=new ArrayList<>();
            while (size!=0)
            {
                TreeNode temp=treeNodes.poll();
                arrayList.add(temp.value);
                if(temp.leftNode!=null)
                treeNodes.offer(temp.leftNode);
                if(temp.rightNode!=null)
                treeNodes.offer(temp.rightNode);
                size--;
            }

            result.add(arrayList);
            index++;
        }
        return result;
    }


}
