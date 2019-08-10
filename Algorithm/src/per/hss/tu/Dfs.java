package per.hss.tu;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * dfs
 */
public class Dfs {
    int dic[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};//四个方向 右  下  上  左
    public static void main(String[] args) {
        int a[][] = new int[][]
                {
                        {0, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 0, 0},
                };
        new Dfs().dfs(a,0,0);
    }
    public void dfs(int[][] a,int i,int j)
    {
        if(i==a.length-1&&j==a[0].length-1)
        {
            System.out.println("到达终点");
            return;
        }

        for(int k=0;k<dic.length;k++)
        {
            if(i+dic[k][0]>=0&&i+dic[k][0]<=a.length-1&&j+dic[k][1]>=0&&j+dic[k][1]<=a[0].length-1&&a[i+dic[k][0]][j+dic[k][1]]!=1)
            {
                a[i+dic[k][0]][j+dic[k][1]]=1;
                dfs(a,i+dic[k][0],j+dic[k][1]);

            }
        }
    }
    public void stackDfs(int[][] a,int i,int j)
    {
        Queue<Integer> integers=new ArrayDeque<>();
        integers.offer(a[i][j]);

    }
}
