import java.util.HashMap;

public class yuansuchazhao {
    public static void main(String[] args) {

        int a=new yuansuchazhao().findElement(new int[]{6,1,2,3,4,5},6,4);
        System.out.println(a);
//        HashMap
    }
    public int findElement(int[] A, int n, int x) {

        // write code here
        //二分查找
        //注意：利用题意中的 这是一个排过序的数组
        int left=0;
        int right=n-1;
        int mid=0;
        //由于移位了，但移位之后，中间元素的左右两边必定有一边是升序的

        while(left<=right) {
            mid=(left+right)/2;
            if(A[mid]==x)
                return mid;
            if(A[mid]<x) {
                //A[mid]<A[left] 说明右边是有序的，且x>A[right]说明x在mid左边
                if(A[mid]<A[left]&&x>A[right]) right=mid-1;
                else left=mid+1;
            }
            else {
                //A[mid]>A[left]说明左边是有序的，且x<A[left]，说明x在mid右边
                if(A[mid]>A[left]&&x<A[left]) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}
