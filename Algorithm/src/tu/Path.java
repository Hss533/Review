package tu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * TODO
 有向路径检查：
    对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
    给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请不要在意数据类型，图是有向图),
    请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。

 */
class UndirectedGraphNode
{
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}

public class Path {
    public static void main(String[] args) {

    }
    //判断能否从A走到B
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return false;
    }
}
