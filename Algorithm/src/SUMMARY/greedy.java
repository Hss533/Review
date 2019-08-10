package SUMMARY;

/**
 * 贪心法相关经典算法
 *
 */
/**
 * 商品买卖问题
 * 只能买一次
 * 只能买一次
 * 记录一个最小值，不断找出最大值
 */
public class greedy {
    /**
     * 每天可以买卖无数次
     * 但是最多只能持有一股
     * 1.DFS 买1股  卖1股
     * 2.只要后一天价格比前一天高
     * @param a
     */
    public void test(int[] a)
    {
        int count=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>a[i-1])
            {
                count+=a[i]-a[i-1];
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        new greedy().test(a);
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] - a[i] > max)
                    max = a[j] - a[i];
            }
        }
        System.out.println(max);

        int min = a[0];
        int MaxCha;
        if (a[1] - a[0] > 0)
            MaxCha = a[1] - a[0];
        else MaxCha = 0;
        for (int i = 2; i < a.length; i++) {
            if (a[i - 1] < min)
                min = a[i - 1];
            if ((a[i] - min) > MaxCha)
                MaxCha = a[i] - min;
        }
        System.out.println(MaxCha);

    }
}
