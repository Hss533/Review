package tu;

import java.util.*;

/**
 *
 *
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请不要在意数据类型，图是有向图),
 请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */

public class TestTu {
    public static void main(String[] args) {

    }
    //判断能否从A走到B
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        if(a==null||b==null)
            return false;
        Queue<UndirectedGraphNode> queue=new ArrayDeque<>();
        queue.offer(a);
        while (queue!=null){
            for(int  i=0;i<a.neighbors.size();i++){
                UndirectedGraphNode temp=a.neighbors.get(i);
                if(temp==b)
                    return true;
                queue.offer(temp);
            }
        }
        return false;
    }
}
