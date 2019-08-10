package leetcodoe;

public class Test11 {
    public static void main(String[] args) {
        System.out.println(new Test11().maxArea(new int[]{1}));
    }
    public int maxArea(int[] height) {
        if(height.length==0||height.length==1)
            return 0;
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int dis=r-l;
            int quare=(height[l]>height[r]?height[r]:height[l]);
           max=Math.max(max,
                   quare*dis);

            if(height[l]<height[r]){
                l=l+1;
            }
            else{
                r=r-1;

            }
        }
        return max;
    }
}
