import java.util.Arrays;
import java.util.Scanner;

public class Wang {
    public static void main(String[] args) {
        Scanner re=new Scanner(System.in);
        int n=re.nextInt();
        for(int i=0;i<n;i++){
            int m=re.nextInt();
            int flag=0;
            int score[]=new int[m];
            for(int j=0;j<m;j++){
                score[j]=re.nextInt();
            }
            Arrays.sort(score);
            if(m==0){
                continue;
            }
            if(m==1){
                System.out.println("YES");
                continue;
            }

            if(score[0]>=score[m-1]+score[1]){
                flag=1;
            }
            if(score[m-1]>=score[m-2]+score[0]){
                flag=1;
            }
            for(int l=1;l<m-1;l++){
                if(score[l]>=score[l-1]+score[l+1]){
                    flag=1;
                }
            }

            if(flag==1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
