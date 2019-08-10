package SUMMARY;

/**
 * 排序
 * 快排
 * 冒泡排序
 *
 */
//八大排序
// （插入排序）直接插入排序 希尔排序
// （选择排序）简单选择排序 堆排序
// （交换排序）冒泡排序 快速排序
// 归并排序
// 基数排序
//TODO 基数排序  归并排序
public class sort {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 1, 5, 7, 2, 6, 9, 3};
        new sort().bubble(a, a.length);
    }
    //冒泡排序
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void test(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
            }
        }
    }

    public void bubble(int a[], int n) {
        for (int i = n; i >= 0; i--) {
            test(a, i);
        }
    }

    //插入排序
    public int [] insert(int[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            int temp=array[i];
            int j=i;

            while (j>0&&array[j-1]>temp)
            {
                array[j] = array[j-1];
                j--;
            }
            array[j]=temp;

        }
        return array;
    }
    //简单选择排序
    public int[] selectSort(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {

            int min=array[i];
            int k = i;
            for(int j=i;j<array.length;j++)
            {
                if(array[j]<min)
                {
                    min=array[j];
                    k=j;
                }
            }
            int temp=array[i];
            array[i]=array[k];
            array[k]=temp;
        }
        return array;
    }

    //快速排序
    public int sort(int[] arry,int left,int right)
    {
        int x=arry[left];
        int i=left;
        int j=right;
        //i                         j
        //72,6,57,88,60,42,83,73,48,85
        while(i<j)
        {
            while(i<j&&arry[j]>=x)
            {
                j--;
            }
            arry[i]=arry[j];
            while(i<j&&arry[i]<=x)
            {
                i++;
            }
            arry[j]=arry[i];
            j--;
        }
        arry[i]=x;
        return i;
    }
    public void quick_Sort(int array[],int left,int right)
    {
        if(left<right)
        {
            int i = sort(array, left, right);
            quick_Sort(array, left, i - 1);
            quick_Sort(array, i + 1, right);
        }
    }

    //====================================================
    //插入排序
    public static void inert(int a[],int n)
    {
        int key=a[n];
        int i=n;
        while (i>=1&&a[i-1]>key)
        {
            a[i]=a[i-1];
            i--;
        }
        a[i]=key;
    }
    public static void insertSort() {
        int a[]=new int[]{3,1,5,2,6,8};
        for(int i=1;i<a.length;i++)
        {
            inert(a,i);
        }
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    //=========================================================

    //希尔排序
    //array={13,27,49,55,4,49,38,65,97,26}
    /**
     * 希尔排序
     * 3间隔有序的序列
     * 还保留了5间隔的有序
     */
    public int[] shellPaixu(int array[], int n) {
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < n; i++)//这个是分成了多少组
            {
                int temp = array[i];
                int j = i;
                while (j - gap >= 0 && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
        return array;
    }
    //=========================选择排序================================================
    public void getMax(int a[], int n) {
        int min = a[0];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                j = i;
            }
        }
        if (n >= 1) {
            int temp = a[j];
            a[j] = a[n - 1];
            a[n - 1] = temp;

        }
    }

    public void selectetst(int a[], int n) {
        for (int i = n ; i >= 0; i--) {
            getMax(a, i);
        }
    }
    //=================================================================

}
