package zijieTest;

import java.util.Scanner;

public class Test00 {
    public static void main(String[] args) {

    }
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int count = sc.nextInt();
        int[] weight = new int[count];
        int[] value = new int[count];
        for (int i = 0; i < count; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int n = weight.length;
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = weight[i - 1];
            v[i] = value[i - 1];
        }
        int[] ans = new int[c + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (ans[t] < ans[t - w[i]] + v[i])
                {
                    ans[t] = ans[t - w[i]] + v[i];
                }
            }
        }
        System.out.println(ans[c]);

    }

}
