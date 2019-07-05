package leetcodoe;

import java.util.Scanner;

/**
 * 使用回溯法解决这个问题？？
 * 暴力求解
 */
public class Test55_2 {
    public static void main(String[] args) {
        System.out.println(new Test55_2().canJump(new int[]{3,2,1,0,4}));
    }
    //相当于是dfs进行搜索
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

}
