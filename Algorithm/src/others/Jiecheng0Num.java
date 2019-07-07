package others;

/**
 * 计算阶乘的结果末尾的0
 */
public class Jiecheng0Num {
    public static void main(String[] args) {

        System.out.println();
        int result = 1;
        for (int i = 1; i <= 10; i++) {
            result *= i;
        }
        System.out.println(result);
        System.out.println(5/5);
        test(10);
    }

    public static void test(int n) {
        int count=0;
        for (int i = 5; i <= n; i++) {
            int temp=i;
            while (temp%5==0){
                count++;
                temp=temp/5;
                if(temp==1)
                    break;
            }
        }
        System.out.println(count);
    }
}
