package per.hss.fenzhi;

/**
 * 全排列
 */
public class QunaPaiLie {


    private int[] a={1,2,3,4};
    public static void main(String[] args)
    {
        QunaPaiLie test=new QunaPaiLie();
        test.quanPailie(test.a,0,test.a.length-1);
    }
    public void swap(int m,int n)
    {
        int t=this.a[m];
        this.a[m]=this.a[n];
        this.a[n]=t;

    }
    public void quanPailie(int a[],int num,int len)
    {

        if(num==len) {
            for (int j = 0; j <=len; j++) {
              System.out.print(a[j] + " ");
            }
            System.out.println();
            return;
        }
        else
        for(int i=num;i<=len;i++)
        {
            this.swap(num,i);
            quanPailie(a,1+num,len);
            this.swap(num,i);
        }
    }

}
