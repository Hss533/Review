package per.hss.fenzhi;

/**
 * 二分
 */
public class ErFen {

    private int[] a={1,2,3,4,5,6,7,8,9,10};
    private int  target=10;
    public static void main(String[] args) {
        ErFen test=new ErFen();
        int left=0;
        int right=test.a.length-1;
        while(left<=right)
        {
            int middle=(left+right)/2;
            if(test.a[middle]<test.target)
            {
                left=middle+1;
            }
            if(test.a[middle]>test.target)
            {
                right=middle-1;
            }
            if(test.a[middle]==test.target)
            {
                System.out.println(middle);
                break;
            }
        }
    }
}
