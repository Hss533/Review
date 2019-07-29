package SUMMARY;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * 总结一下dp
 */
//背包问题 拆分问题 硬币问题 打家劫舍问题 编辑距离问题
//TODO 合唱团问题 股票买卖问题 最长公共子序列
public class dp {
    public static void main(String[] args) {
            he(new int[]{6,-3,-2,7,-15,1,2,2});
    }
    //最大连续子数和
    /**
     * 使用一个cur数组和一个max数组
     *
     */
    public static void he(int[] a){
        int cur[]=new int[a.length];
        int max[]=new int[a.length];
        cur[0]=a[0];
        max[0]=a[0];
        for(int i=1;i<a.length;i++)
        {
            if(cur[i-1]>0)
                cur[i]=cur[i-1]+a[i];
            else
                cur[i]=a[i];

            if(cur[i]>max[i-1])
            {
                max[i]=cur[i];
            }
            else
                max[i]=max[i-1];
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(max[i]+" ");
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(cur[i]+" ");
        }
    }
    //最长上升子序列
    /**
     *
     * 找出一个序列的最长上升子序列
     * 10, 9, 2, 5, 3, 7, 101, 18, 20的最长上升子序列是5 : 2 3 7 18 20
     * dp数组的输出1 1 1 2 2 3 4 4 5
     */
    public void Lis(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int j;
            dp[i]=1;
            for(j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
    }
    /**
     *  第二种解决方法
     *  TODO 看的不是很懂
     *  返回值是最长上升子序列的长度
     */
    public int Lis2(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            System.out.println(num);
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    // 编辑距离问题

    /**
     *
     qweq
     qwwq
     0 1 2 3 4
     1 0 1 2 2
     2 1 0 1 2
     3 2 0 1 2
     4 2 1 1 1
     1
     编辑距离问题：
     */
    public static void distance(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        char[] a=new char[str.length()];
        char[] b=new char[str1.length()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=str.charAt(i);
        }
        for(int i=0;i<b.length;i++)
        {
            b[i]=str1.charAt(i);
        }
        int row = b.length + 1;
        int col = a.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (b[i - 1] == a[j - 1])
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[b.length][a.length]);
    }

    //背包问题
    /**
     * 0 1 背包问题是动态规划问题
     * 还有一种背包是贪心问题
     *
     */
    public static  void back(){
        int[][] nArr = new int[6][13];
        int[] nCost = {0, 2, 5, 3, 10, 4};  //花费
        int[] nVol = {0, 1, 3, 2, 6, 2}; //物体体积
        int bagV = 12;

        for (int i = 1; i < nCost.length; i++) {
            for (int j = 1; j <= bagV; j++) {
                if (j < nVol[i])
                    nArr[i][j] = nArr[i - 1][j];//说明j
                else
                    nArr[i][j] = max(nArr[i - 1][j], nArr[i - 1][j - nVol[i]] + nCost[i]);
                if (nArr[i][j] < 10)
                    System.out.print(nArr[i][j] + "  ");
                else
                    System.out.print(nArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(nArr[5][12]);
    }

    //硬币问题
    /**
     * 1 2 5 三种硬币
     * 每种硬币的个数不限
     * 问凑成11所需要的硬币的最少的个数
     * 1 6 7
     */
    public static  void coin(){
        int count = 11;
        int[] dp = new int[count + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < count + 1; i++)
        {
            if ((i - 2) > 0 && (i - 5) < 0)
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + 1;
            if (i - 5 == 0)
                dp[i] = 1;
            if ((i - 5) > 0) {
                dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 5]), dp[i - 2]) + 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "  ");
        }
    }

    //打家劫舍问题 LeetCode上的题
    /**
     *  相邻的房间装有相互连通的防盗装置，如果两件相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     *  求小偷能偷到的最高的金额
     *
     *  example:
     *  1,2,3,1
     *  4
     *  偷窃1,3
     *
     *  2,7,9,3,1
     *  12
     *  偷窃1,3,5
     */
    public static void dajia(){
        int[] a=new int[]{0,2,7,9,3,1};
        int[] dp=new int[a.length+1];
        dp[0]=0;
        dp[1]=a[1];
        for(int  i=2;i<a.length;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+a[i]);
        }
        for(int i=0;i<dp.length;i++)
        {
            System.out.print(dp[i]+" ");
        }
    }

    //拆分整数:使乘积最大

    /**
     * 10 应该拆分成3,3,4
     */
    public static void chaifen(){
        int shu=11;//最大的应该是3,3,4
        int dp[]=new int[shu];
        dp[1]=1;
        for(int i=2;i<shu;i++)
        {
            dp[i]=i;
            for(int j=1;j<=i;j++)
            {
                dp[i]=Math.max(dp[i-j]*j,dp[i]);
                System.out.print("i = "+i+",Max = "+dp[i]+" ");
            }
            System.out.println();
        }
    }

    //机器人走路
    /**
     * 从起点走到终点，只能往右走或者往下走，遇到石头不能走
     * 一共有多少条已能走的路径
     *
     * 当前能走的路径就是它左边的节点能走的路径，加上它上边节点能走的路径
     */
    public static void findPathNum()
    {
        int[][] a=new int[][]
                {
                        {0,0,0,0,0,0,0,0},
                        {0,0,1,0,0,0,1,0},
                        {0,0,0,0,1,0,0,0},
                        {1,0,1,0,0,1,0,0},
                        {0,0,1,0,0,0,0,0},
                        {0,0,0,1,1,0,1,0},
                        {0,1,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,0},
                };
        int row=a.length;
        int col=a[0].length;
        int[][] dp=new int[row][col];
        for(int i=0;i<row;i++)
        {
            if(a[i][0]==1)
                break;
            dp[i][0]=1;
        }
        for(int i=0;i<col;i++)
        {
            if(a[0][i]==1)
                break;
            dp[0][i]=1;
        }
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(a[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                if(a[i][j]==1)
                    dp[i][j]=0;
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }

    //乘积最大的子序列
    /**
     * 要考虑正负数的问题
     */
    public static void maxSum() {
        int[] a = {2, 3, -2, 4, -5};
        int[][] dp = new int[a.length][2];
        if (a[0] >= 0) {
            dp[0][0] = a[0];
            dp[0][1] = 0;
        } else {
            dp[0][0] = 0;
            dp[0][1] = a[0];
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * a[i], a[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * a[i], a[i]);

            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * a[i], a[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * a[i], a[i]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(dp[i][0] + "  " + dp[i][1]);
        }

    }

    //最长连续上升子序列
    public static void xulie() {
        int[] a = new int[]{10, 9, 2, 5, 3, 4, 5, 100};
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int temp=a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {
                    break;
                }
                temp=a[j];
                result[i]++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    //求三角形的最短路径

    /**
     * 这个应该从最底下来找
     * 这个是LeetCode上的题
     */
    public static void trangle() {
        int[][] a = new int[][]{{2, 0, 0, 0},
                {3, 4, 0, 0},
                {6, 5, 1, 0},
                {4, 1, 8, 3}};
        int[][] dp = new int[a.length][a[0].length];
        for (int i = 0; i < a[0].length; i++) {
            dp[a.length - 1][i] = a[a.length - 1][i];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + a[i][j];
            }
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
