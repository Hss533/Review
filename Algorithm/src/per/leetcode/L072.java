package per.leetcode;

public class L072 {
    public static void main(String[] args) {

        int a = new L072().minDistance("zoologicoarchaeologist" ,"zoogeologist");
        System.out.println(a);
    }

    public int minDistance(String word1, String word2) {
        String str = word1;
        String str1 = word2;
        char[] a = new char[str.length()];
        char[] b = new char[str1.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = str.charAt(i);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = str1.charAt(i);
        }
        System.out.println(a);
        System.out.println(b);
        int row = b.length+1;
        int col = a.length+1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (b[i - 1] == a[j - 1])
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j]+1, dp[i - 1][j - 1]), dp[i][j - 1]+1);
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j]+1, dp[i - 1][j - 1]+1), dp[i][j - 1]+1);

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] < 10)
                    System.out.print(dp[i][j] + "  ");
                else
                    System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[b.length][a.length];
    }
}
