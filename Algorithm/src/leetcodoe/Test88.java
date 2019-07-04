package leetcodoe;

/**
 * 88题
 * 合并两个有序数组
 */

/**
 * 我的思路：nums1和nums2从前到后，进行比较，然后第一个数组与第二个数组不断进行合并
 *
 * 但是从后往前的思路比较好
 *
 */
public class Test88 {
    public static void main(String[] args) {

        new Test88().merge(new int[]{0},0,new int[]{1},1);

    }
    public  void merge(int[] nums1, int m, int[] nums2, int n) {

        // 1,2,3,0,0,0
        // 2,5,6

        int p=nums1.length-1;
        int p1=m-1;
        int p2=n-1;
        while (p1>=0&&p2>=0){
            if(nums1[p1]>nums2[p2]){
                System.out.println(nums1[p1]+"--"+nums2[p2]);
                nums1[p]=nums1[p1];
                p1--;
                p--;
            }
            else {
                nums1[p]=nums2[p2];
                p2--;
                p--;
            }
        }
        //把剩下的还要放回去
        if(p2!=-1){
            for(int i=0;i<=p2;i++){
                nums1[i]=nums2[i];
            }
        }
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
