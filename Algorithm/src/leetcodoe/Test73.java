package leetcodoe;

/**
 * 矩阵置0
 */
public class Test73 {
    public static void main(String[] args) {
        setZeroes(new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,1}
        });
    }

    public static  void setZeroes(int[][] matrix) {
        int hanhg = matrix.length;
        int lie = matrix[0].length;
        int h0=0;
        int l0=0;
        for(int i=0;i<hanhg;i++){
            if(matrix[i][0]==0){
                h0=1;
            }
        }
        for(int i=0;i<lie;i++){
            if(matrix[0][i]==0){
                l0=1;
            }
        }

        for (int i = 1; i < hanhg; i++) {
            for (int j = 1; j < lie; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

       for(int i=1;i<lie;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<hanhg;j++){
                    matrix[j][i]=0;
                }
            }
       }
       for(int i=0;i<hanhg;i++){
           if(matrix[i][0]==0){
               for(int j=0;j<lie;j++){
                   matrix[i][j]=0;
               }
           }
       }

       if(h0==1){
           for(int i=0;i<hanhg;i++){
               matrix[i][0]=0;
           }
       }
       if(l0==1){
           for(int i=0;i<lie;i++){
               matrix[0][i]=0;
           }
       }

        for(int i=0;i<hanhg;i++){
            for(int j=0;j<lie;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
