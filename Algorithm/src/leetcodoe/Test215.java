package leetcodoe;

/**
 * 找出第k个最大元素
 */
public class Test215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1,2,3,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int max=nums[i];
            int j=i;
            int index=0;
            int flag=0;
            for(j=i;j<nums.length;j++){
                   if(nums[j]>max){
                       flag=1;
                       max=nums[j];
                       index=j;
                   }
            }
            if(flag==1){
            int temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;}
        }

        return nums[k-1];
    }
}
