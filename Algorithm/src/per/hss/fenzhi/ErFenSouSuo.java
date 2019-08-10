package per.hss.fenzhi;

/**
 * 二分搜索 分治法
 */
public class ErFenSouSuo {

    private  int e;
    private int a[]={1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] args) {

        ErFenSouSuo test=new ErFenSouSuo();
        test.erfen(test.a,8,0,test.a.length-1);
        System.out.println(test.e);
        System.out.println(5/2);

    }

    /**
     *返回要搜索的数的位置
     * @param a
     * @param result
     * @return
     */
    public void  erfen(int[] a,int result,int left,int right)
    {
        int middle=(right+left)/2;

        if(left>right)
        {
           e=-1;
        }
        else{
            if(result<a[middle])
            erfen(a,result,left,middle-1);
            if(result>a[middle])
            erfen(a,result,middle+1,right);
            if(result==a[middle])
                e=middle;
        }
    }
}
