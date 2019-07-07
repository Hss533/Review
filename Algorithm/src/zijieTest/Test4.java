package zijieTest;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class Node{
    int value;
    int i;
    public Node(int value,int i){
        this.i=i;
        this.value=value;
    }
}
public class Test4 {
    public static void main(String[] args) {
        test(new int[][]{
                {1,2,3,4,5,6},
                {1,2,3,4,5,7},
                {3,4,5,6,7,8},
                {1,4,5,6,7,9}
        });
    }
    public static void test(int[][] test)
    {
        int n=test.length;
        int l=test[0].length;
        int[] result=new int[n*l];//要返回的数组
        int[] index=new int[n];//用来判断数组到第几个了
        for(int i=0;i<n;i++){
            index[i]=0;
        }
        PriorityQueue<Node> queue=new PriorityQueue<Node>
                (new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value<o2.value)return -1;
                else if(o1.value>o2.value)return 1;
                else return 0;

            }
        });
        for(int i=0;i<n;i++){
            Node node=new Node(test[i][index[i]++],i);
            queue.offer(node);
        }
        System.out.println(queue.size());
        for(Node node:queue){
            System.out.print(node.value+" ");

            System.out.println(node.i);
        }
        System.out.println(queue);

        for(Node node:queue){
            System.out.print(node.value+" ");
            System.out.println(node.i);
        }

        int idx=0;//判断添加了多少个
        while (idx<n*l)
        {
            Node minNode=queue.poll();
            result[idx++]=minNode.value;
            if(index[minNode.i]<l)
            {
                queue.offer(
                        new Node(test[minNode.i][index[minNode.i]]
                        ,minNode.i));
                index[minNode.i]++;
            }
        }
        return;
    }
}
