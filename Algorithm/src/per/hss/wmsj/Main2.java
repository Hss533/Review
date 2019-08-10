package per.hss.wmsj;

import java.util.*;

/**
 * 田忌赛马
 */
public class Main2 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] tianji=new int[n];
        int[] diren=new int[n];
        for(int i=0;i<n;i++)
        {
            tianji[i]=sc.nextInt();

        }
        for(int i=0;i<n;i++)
        {  diren[i]=sc.nextInt();

        }
        Arrays.sort(tianji);
        Arrays.sort(diren);
        int i=0,j=0,x=n-1,y=n-1;
        int sum=0;
        boolean flag=true;
        while (flag)
        {
            if(x==i)
                flag=false;
            if(tianji[i]>diren[j]){
                i++;
                j++;
                sum+=100;
            }
            else if(tianji[x]>diren[y])
            {
                x--;
                y--;
                sum+=100;
            }
            else {
                if(tianji[i]<diren[y])
                    sum-=100;
                i++;
                y--;
            }
        }
        System.out.println(sum);
    }
}
