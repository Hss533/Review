package per.leetcode;

/**
 * 200
 */
public class L200 {
    public static void main(String[] args) {
        int a=new L200().numIslands(new char[][]{
                {0,0,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        });
        System.out.println(a);
    }
    int dic[][]=new int[][]{
            {1,0},{0,1},{0,-1},{-1,0}
    };
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    test(grid,i,j);
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
                if(a[m+dic[i][0]][n+dic[i][1]]=='1')
                {
                    a[m+dic[i][0]][n+dic[i][1]]='0';
                    test(a,m+dic[i][0],n+dic[i][1]);
                }
            }
        }
    }
}
