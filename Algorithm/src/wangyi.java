import java.util.Scanner;

public class wangyi {
    public static void main(String[] args) {

        Scanner re=new Scanner(System.in);
        int n=re.nextInt();
        int score[]=new int[n];
        for(int i=0;i<n;i++){
            score[i]=re.nextInt();
        }
        double[] result=new double[n];
        int times=re.nextInt();
        int ques[]=new int[times];
        for(int i=0;i<times;i++){
            ques[i]=re.nextInt();
        }

        re.close();
        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(j!=i&&score[j]<score[i]){
                    flag++;
                }
            }
            result[i]=flag;
        }
        for(int i=0;i<n;i++){
           result[i]=(result[i]/n)*100;
        }
        for(int i=0;i<times;i++){
            if(ques[i]>n){
                System.out.printf("%4f",0.0);
                System.out.println();
            }
            else {
            System.out.printf("%4f",result[ques[i]-1]);
            System.out.println();}
        }

    }
}
