package leetcodoe;

public class Test69
{
    public static void main(String[] args) {

        System.out.println(new Test69().myS(5));
    }
    public int myS(int x){
        long left=1;
        long right=x/2+1;
        long mid= (left + right + 1) >>> 1;
        while (left<right){
            mid= (left + right + 1) >>> 1;
            long square=mid*mid;
            if(square>x){

                right=mid-1;
                continue;
            }
            else if(square<x){

                left=mid;
                continue;
            }else
                {
                return (int)mid;
            }

        }
        return  (int)left;
    }
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public int mySqrt1(int x) {

        if(x==1||x==2||x==3)
            return 1;
        if(x==4){
            return 2;
        }
        for(long i=0;i<=x/2;i++){


            if(i*i==x)
            {
                return (int) i;
            }

             if(((i*i)<x)&&((i+1)*(i+1)>x))
             {
                 return (int)i;
            }
        }
        return 0;
    }
}
