package per.offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Hongshui {
    public static void main(String[] args) {
        int a[][] = new int[][]
                {
                        {0, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 0, 0},
                };
        new Hongshui().floodFill(a,2,3);

    }
    public int floodFill(int[][] map, int n, int m) {
        // write code here

        int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0);
        while(!q.isEmpty()){
            int cur=q.peek();
            q.poll();
            int i=cur/m;   //得出x轴坐标
            int j=cur%m;   //得出y轴坐标
            if(i==n-1 && j==m-1)
            {
                return map[n-1][m-1];
            }
            for(int k=0;k<4;k++){
                int next_x=i+direction[k][0];
                int next_y=j+direction[k][1];
                if(next_x>=0 && next_x<n && next_y>=0 && next_y<m && map[next_x][next_y]==0){
                    q.offer(next_x*m+next_y);
                    map[next_x][next_y]=map[i][j]+1;
                }
            }
        }
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
