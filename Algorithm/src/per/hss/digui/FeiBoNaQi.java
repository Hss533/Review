package per.hss.digui;

/**
 * 斐波那契
 */
public class FeiBoNaQi {


    private int[] a = new int[20];

    public static void main(String[] args) {
        FeiBoNaQi test = new FeiBoNaQi();
        for(int i=1;i<20;i++)
        {
            System.out.println(test.fei(i));
            test.a[i-1]=test.fei(i);
        }
    }

    public int fei(int i) {
        if (i == 1||i==2)
            return 1;
        else {
            System.out.println("xixi");
            return fei(i-1)+fei(i-2);
        }
    }
}