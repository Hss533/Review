package per.leetcode;

public class L198 {
    public static void main(String[] args) {
        int s=new L198().rob(new int[]{1,2,3,1});
        System.out.println(s);
    }

    public int rob(int[] nums) {

        if(nums.length==0)
        {
            return 0;
        }
        int[] a=new int[nums.length+1];
        for(int i=1;i<a.length;i++)
        {
            a[i]=nums[i-1];
        }

        int[] dp = new int[a.length + 1];
        dp[0] = 0;
        dp[1] = a[1];
        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);
        }
        int max=0;
        for (int i = 0; i < dp.length; i++) {
           if(dp[i]>max)
               max=dp[i];
        }
        return max;
    }
}
