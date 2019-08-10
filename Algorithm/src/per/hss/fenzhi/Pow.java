package per.hss.fenzhi;

/**
 * pow(x,n)
 * log n
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().pow(4,4));
    }

    public double pow(int a,int n) {
        if (n==0)
            return 1;
        if(n<0)
            return 1/pow(a,-n);
        if(n%2==0)
            return pow(a*a,n/2);
        else
            return a*pow(a,n-1);

    }
}
