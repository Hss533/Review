package leetcodoe;

public class Test45 {
    public static void main(String[] args)
    {
        System.out.println( jump(new int[]{2,3,1,1,4,2,4}));
    }
    public static int jump(int[] nums) {
        int end=0;
        int step=0;
        int position=0;
        for(int i=0;i<nums.length-1;i++){
            position=Math.max(position,nums[i]+i);
            if(i==end){
               end=position;
               step++;
            }
        }
        return step;
    }
}
