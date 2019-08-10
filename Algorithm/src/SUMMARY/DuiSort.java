package SUMMARY;

public class DuiSort {


    //构建大顶堆
    public void create(int[] array,int n) {

        int last_node=n-1;
        int pareant=(last_node-1)/2;
        for(int i=pareant;i>=0;i--)
        {
            heapFfiy(array,n,i);
        }
    }

    //交换
    public void swap(int[] a, int i, int max) {
        int temp = a[i];
        a[i] = a[max];
        a[max] = temp;
    }

    public void heapFfiy(int[] a, int n, int i) {
        if (i >= n)
            return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && a[c1] > a[max]) {
            max = c1;
        }
        if (c2 < n && a[c2] > a[max]) {
            max = c2;
        }
        //交换 要保证的是 父节点要大于所有的子节点
        if (max != i) {
            swap(a, i, max);
            heapFfiy(a, n, max);
        }
    }
    public void heap_sort(int tree[],int n)
    {
        create(tree,n);
        int i;
        for(i=n-1;i>=0;i--)
        {
            swap(tree,i,0);
            heapFfiy(tree,i,0);
        }

    }
    //3, 2, 5, 1, 7, 4, 9, 6
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 7, 4, 9, 6,8};
        int length=a.length;
        /*new DuiSort().heapFfiy(a, 6, 0);
        */
        new DuiSort().heap_sort(a,3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
