package cxyms;

/**
 * 约瑟夫环问题
 */
public class Yuesefu {

    public int getResult(int n, int m)
    {
        int[] a=new int[n+1];
        int[] in=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=i;
            in[i]=0;
        }
        int count=0;

        int i=1;
        while (count<n)
        {
            int t=1;
            if(t<m&&in[i]==0){
                t++;
                i++;
            }
            if(t==m){
                in[i]=1;
                i++;
                count=+1;
            }
            if(i>n){
                i=i%n;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        new Yuesefu().getResult(10,1);
    }
}
