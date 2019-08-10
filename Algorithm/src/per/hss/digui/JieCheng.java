package per.hss.digui;

/**
 * 阶乘
 */
public class JieCheng {

    private int sum=1;
    public static void main(String[] args) {
        JieCheng test=new JieCheng();
        test.jiecheng(5);
        System.out.println(test.sum);
    }
    public void  jiecheng(int a)
    {
        if(a<=1)
            return;
        else{
            sum*=a;
            a=a-1;
            jiecheng(a);

        }
    }
}
