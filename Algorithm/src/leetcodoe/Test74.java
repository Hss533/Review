package leetcodoe;

/**
 *
 */
public class Test74 {
    public static void main(String[] args) {

        System.out.println(new Test74().searchMatrix(new int[][]{{1},{2},{3}
        },1));
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int row=matrix.length;
        int lie=0;
        if(matrix.length!=0)
        {
            lie =matrix[0].length;
        }
        else {
            return false;
        }
        if(lie==0)
            return false;
        int left=0;
        int right=row-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]<target){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }

        int newleft=left-1;
        if(newleft==-1){
            return false;
        }
        int lefth=0;
        int righth=lie-1;
        int midh=0;
        while (lefth<=righth){
            midh=(lefth+righth)/2;
            if(matrix[newleft][midh]==target){
                return true;
            }
            else if(matrix[newleft][midh]<target){
                lefth=midh+1;
            }
            else {
                righth=midh-1;
            }
        }
        return false;
    }
}
