package sort;

public class QuickSort {

    public static void main(String[] args) {
        int k = 2;
        int[] a = new int[]{72, 6, 57, 88, 60, 42, 73, 48, 85};
        quick(a, 0, 8, 5);
        System.out.println(a[k - 1]);

        /*
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        */
    }

    public static int sort(int[] quick, int left, int right) {
        int position = quick[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (quick[j] < position && j > i) {
                j--;
            }
            quick[i] = quick[j];
            while (quick[i] > position && j > i) {
                i++;
            }
            quick[j] = quick[i];
            j--;

        }
        quick[i] = position;
        return i;
    }
    public static int quick(int[] array, int left, int right, int k) {
        if (left < right) {
            int i = sort(array, left, right);
            if (i == k - 1) {
                return i;
            }
            if (i > k - 1) {
                quick(array, left, i - 1, k);
            }
            if (i < k - 1) {
                quick(array, i + 1, right, k);
            }
        }
        return 0;
    }
}
