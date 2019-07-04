package leetcodoe;

/**
 * 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class Test977 {
        public static void main(String[] args) {
            int[] a=new Test977().sortedSquares(new int[]{-4,-3,-2,3,3});
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
            }
        }
    public int[] sortedSquares(int[] A) {
        int i=0;
        int j=0;
        int[] fushu=new int[A.length];
        int[] zhengshu=new int[A.length];
        for(int k=0;k<A.length;k++){
            if(A[k]<0){
                fushu[i]=(-A[k])*(-A[k]);
                i++;
            }
            else {
                zhengshu[j]=A[k]*A[k];
                j++;
            }
        }
        int p=zhengshu.length-1;
        int p1=0;
        int p2=j-1;
        //合并两个数组
        while (p1<=i&&p2>=0){
            if(fushu[p1]>zhengshu[p2]){
                zhengshu[p]=fushu[p1];
                p1++;
                p--;
            }
            else {
                zhengshu[p]=zhengshu[p2];
                p2--;
                p--;
            }
        }
        /*if(p2!=i){
            for(int k=0;k<i;k++){
                zhengshu[k]=fushu[i-k-1];
            }
        }*/
        if(p1!=i){
            int l=0;
            for(int k=i-1;k>=p1;k--){
                zhengshu[l]=fushu[k];
                l++;
            }
        }
        System.out.println(2);
        return zhengshu;
    }
}
