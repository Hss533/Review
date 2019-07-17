package leetcodoe;

/*
    寻找旋转数组中最小的
 */
public class Test153 {
    public static void main(String[] args) {

        System.out.println(new Test153().findMin(new int[]{3,2}));
    }
    public int findMin(int[] nums) {

        int left=0;
        int right=nums.length-1;
        int mid=0;
        while (left<=right){
            if(left+1==right)
                return nums[left]<nums[right]?nums[left]:nums[right];
            mid=(right+left)/2;
            if(nums[mid]>=nums[left]&&nums[mid]<=nums[right]){

                return nums[left];
            }
            if(nums[mid]<=nums[right])
            {
                right=mid;
            }
            else {
                left=mid;
            }
        }


        return 0;

    }
}
