package leetcodoe;

public class Test35 {
    public static void main(String[] args) {

        System.out.println(new Test35().searchInsert(new int[]{1,3,5,6},2));
    }
    public int searchInsert(int[] nums, int target) {


        int left=0;
        int right=nums.length-1;
        int mid=0;

        while (left<=right)
        {

            mid=(right+left)/2;

            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]) {

                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
}
