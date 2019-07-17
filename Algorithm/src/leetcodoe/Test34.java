package leetcodoe;


public class Test34 {
    public static void main(String[] args) {
        new Test34().searchRange(new int[]{5,7,7,8,8,10},8);
    }
    public int[] searchRange(int[] nums, int target) {

        int[] re=new int[2];
        int left=0;
        int right=nums.length-1;
        int flag=0;
        int mid=0;
        while (left<=right){
            mid=(right+left)/2;
            if(nums[mid]==target){
                flag=1;
                break;
            }
            else  if(nums[mid]>target){

                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }

        System.out.println(mid+"flag="+flag);
        if(flag==0){
            return new int[]{-1,-1};
        }
        else {
            int start=0;
            int end=0;
            for(int i=mid;i>=0;i--){
                if(nums[i]==target)
                    start=i;
            }
            for(int i=mid;i<nums.length;i++){
                if(nums[i]==target){
                    end=i;
                }
            }
            re[0]=start;
            re[1]=end;
        }
        return re;
    }
}
