package leetcodoe;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 使用回溯法解决这个问题？？
 * 暴力求解
 */
public class Test55_2 {
    public static void main(String[] args) {
        int n=new Test55_2().bfs(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5});
        System.out.println(n);
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

    public int canJumpStep(int[] nums){
        return canJumpFromPositionStep(0,nums,0);
    }
    public int canJumpFromPositionStep(int position,int[] nums,int step){

        if (position == nums.length - 1) {
            return step;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
        {
             return  canJumpFromPositionStep(nextPosition, nums,step+1);
        }

        return step-1;
    }
    //如果使用bfs进行搜索的话？？会超时
    public int bfs(int[] nums){
        if(nums.length==1){
            return 0;
        }
        Queue<Integer> integers=new ArrayDeque<>();
        integers.offer(0);

        int step=0;
        while (true){
            step++;
            if(step==nums.length)
                return step;
            int szie=integers.size();
            while (integers.size()>0)
            {
                int temp=integers.poll();
                szie--;
                for(int j=0;j<nums[temp];j++)
                {
                    int now=j+temp+1;
//                  System.out.println(now);
                    if(now==nums.length-1)
                        return step;
                    if(j<nums.length)
                        integers.offer(now);
                }
            }
        }
    }
}

