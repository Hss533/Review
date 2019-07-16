package zijieTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
    static  class Route{
        Route(int from ,int to){
            this.from=from;
            this.to=to;
        }
        int from;
        int to;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int buildingCount=scanner.nextInt();
        int rouCount=scanner.nextInt();
        String BuilString=scanner.next();
        Route[] routes=new Route[rouCount];

        for(int i=0;i<rouCount;i++){
            int form =scanner.nextInt();
            int to=scanner.nextInt();
            routes[i]=new Route(form,to);
        }
        float m=Float.MAX_VALUE;
        float c[][]=new float[buildingCount+1][buildingCount+1];

        for(int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                c[i][j]=m;
            }
        }
        for(Route r:routes){
            if(BuilString.charAt(r.to-1)!=BuilString.charAt(r.from-1)){
                c[r.to][r.from]=1;
                c[r.from][r.to]=1;
            }
        }
        prim(c[0].length,c,routes);
    }
    public static void prim(int n,float[][] c,Route[] routes){
        List<Integer> ans=new ArrayList<>();

        float[] low=new float[n+1];
        low[n]=Float.MAX_VALUE;
        int[] closeest=new int[n+1];
        closeest[n]=(int)low[n];
        boolean[] s=new boolean[n+1];
        s[1]=true;

        for(int i=2;i<n-1;i++){
            low[i]=c[1][i];
            closeest[i]=1;
            s[i]=false;
        }
        for(int i=1;i<n-1;i++){
            float min=Float.MAX_VALUE;
            int j=1;
            for(int k=2;k<n-1;k++){
                if((low[k]<min)&&(!s[k])){
                    min=low[k];
                    j=k;
                }
            }
            int from=j;
            int to=closeest[j];
            for(int index=0;index<routes.length;index++){
                if((routes[index].to==to&&routes[index].from==from)||(routes[index].from==to&&routes[index].to==from)){
                    ans.add(index);
                }
            }
            s[j]=true;
            for(int k=2;k<=n-1;k++){
                if((c[j][k]<low[k])&&(!s[k])){
                    low[k]=c[j][k];
                    closeest[k]=j;
                }
            }
        }
        System.out.println(ans.size());
        for(int rr:ans){
            System.out.println(rr+" ");
        }


    }
}
