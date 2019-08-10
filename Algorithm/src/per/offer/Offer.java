package per.offer;


import java.util.ArrayList;

public class Offer {
    public static void main(String[] args) {

        Offer offer= new Offer();
        offer.test();
    }

    public boolean match(char[] str, char[] pattern)
    {
        return true;
    }
    void swap(char[] a,int i,int j)
    {
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    void perm(char[] a,int p,int q)
    {
        if(p==q)
        {
            for(int i=0;i<a.length;i++)
            {
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        for(int i=p;i<q;i++)
        {
            swap(a,p ,i);
            perm(a,p+1,q);
            swap(a,p,i);

        }
    }
    public void test()
    {
        char[] a=new char[]{'1','2','3'};
        perm(a,0,3);
    }


}
