package zijieTest;

import java.util.Scanner;

/**
 * 佛洛依德
 *
 */
public class Test {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] input=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                input[i][j]=scanner.nextInt();
            }
        }

        System.out.println(test(input,n));

    }
    public static int test(int[][] input,int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(input[i][j]>input[i][k]+input[k][j]){
                        input[i][j]=input[i][k]+input[k][j];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=input[0][i];
        }

        return sum;
    }
}
/**

 4
 0 2 6 4
 100 0 3 100
 7 100 0 1
 5 100 12 0


 */