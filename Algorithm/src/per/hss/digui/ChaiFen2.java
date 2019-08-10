package per.hss.digui;

import java.util.Scanner;

/**
 * 拆分整数2
 * 算一下一个整数可以拆分成多种形式？
 * 1+2+1
 * 1+1+2
 * 算一种形式
 */
public class ChaiFen2 {
    public void test(int a)
    {
         a=a+1;
        int dp[]=new int[a+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            dp[i]=dp[i-1];
            int count=0;
            int m=i;
            if(m%2==1)
               m=i-1;
            for(int j=m/2;j<i-1;j++)
            {
                count++;
            }
            dp[i]+=count;
            System.out.println(dp[i]);
        }
    }
    public static void main(String[] args) {
        new ChaiFen2().test(12);
        int i,j,k;
        int[] c1=new int[125];
        int[] c2=new int[125];
        Scanner reader=new Scanner(System.in);
        while(true)
        {
            int n=reader.nextInt();
            for(i=0;i<=n;i++)
            {
                c1[i]=1;
                c2[i]=0;
            }
            for(i=2;i<=n;i++)
            {
                for(j=0;j<=n;j++)
                {
                    for(k=0;j+k<=n;k+=i)
                        c2[j+k]+=c1[j];
                }
                for(j=0;j<=n;j++)
                {
                    c1[j]=c2[j];
                    c2[j]=0;
                }
            }
            System.out.println(c1[n]);
        }
    }
}
