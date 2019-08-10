package per.hss.tu;

import per.hss.shu.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * dfs求联通分量
 */
public class Fen {
    public static void main(String[] args) {

        int a=new Fen().test(new char[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {0,0,1,1,0},
                {0,0,0,1,1}
        });
        System.out.println(a);
    }
    int dic[][]=new int[][]{
            {1,0},{0,1},{0,-1},{-1,0}
    };
    public int  test(char[][] a)
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(a[i][j]==1)
                {
                    test(a,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void test(char[][] a,int m,int n)
    {
      for(int i=0;i<dic.length;i++)
      {
          if(m+dic[i][0]>=0&&m+dic[i][0]<a.length&&n+dic[i][1]>=0&&n+dic[i][1]<a[0].length)
          {
              if(a[m+dic[i][0]][n+dic[i][1]]==1)
              {
                    a[m+dic[i][0]][n+dic[i][1]]=0;
                    test(a,m+dic[i][0],n+dic[i][1]);
              }
          }
      }
    }
    public void bfs(int[][] a,int i,int j)
    {
        Queue<Integer> integers=new ArrayDeque<>();
        integers.offer(a[i][j]);
        while (!integers.isEmpty())
        {

            Integer temp=integers.poll();
            for(int k=0;k<dic.length;k++)
            {
                //如果使用dfs一个一个放进去，要放的是index
                //integers.offer();
            }
        }
    }
    //邻接矩阵
    public void test(int n,int m,int[][] a)
    {
        //n总人数 m关系数  a关系矩阵
        Queue<Integer> characters=new ArrayDeque<>();

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.leftNode==null && root.rightNode==null)
            return sum==root.value;
        return ( hasPathSum(root.leftNode, sum-root.value) || hasPathSum(root.rightNode, sum-root.value));
    }
}
