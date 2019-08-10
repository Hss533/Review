package leetcodoe;

//TODO
public class Test33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},4));
    }
    public  static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int left=0;
        int right=nums.length-1;
        int midle=0;
        while (left<right){
            midle=left+(right-left)/2+1;
            if(midle>nums.length-1)
                midle=nums.length-1;
            if(midle<0)
                midle=0;
            if(nums[midle]==target){
                return midle;
            }
            if((nums[0]<=target&&target<=nums[midle])||(target<=nums[midle]&&nums[midle]<=nums[0])||(nums[midle]<nums[0]&&nums[0]<=target))
            {
                right=midle;

            }
            else {
                left=midle+1;
            }

        }
        midle=left+(right-left)/2;
        if(midle>nums.length-1)
            midle=nums.length-1;
        if(midle<0)
            midle=0;
        if(nums[midle]!=target)
            return -1;
        else
            return  midle;
    }
}
