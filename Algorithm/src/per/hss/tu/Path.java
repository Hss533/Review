package per.hss.tu;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 *
 * 有向图两点之间是否存在一条路径
 * 采用广度优先遍历 是使用的是队列
 *
 */
class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
public class Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here


        return dfs(a,b);
    }
    public boolean dfs(UndirectedGraphNode a, UndirectedGraphNode b)
    {
        if(a==null||b==null)
            return false;
        if(a==b)
            return true;
        HashMap<UndirectedGraphNode,Boolean> map=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new ArrayDeque<>();
        queue.offer(a);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode ptr=queue.poll();
            map.put(ptr,true);
            for(int i=0;i<ptr.neighbors.size();i++)
            {
                if(ptr.neighbors.get(i)==b)
                    return true;
                if(ptr.neighbors.get(i)!=null&&map.get(ptr.neighbors.get(i))!=true)
                    queue.offer(ptr.neighbors.get(i));
            }
            queue.poll();
        }
        return false;
    }
    public static void main(String[] args) {
        UndirectedGraphNode a=new UndirectedGraphNode(2);
        UndirectedGraphNode b=new UndirectedGraphNode(3);

//        new Path().dfs();
    }
}
