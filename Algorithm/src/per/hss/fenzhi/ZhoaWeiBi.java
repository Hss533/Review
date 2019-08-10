package per.hss.fenzhi;

/**
 * 分治法 找伪币
 */
public class ZhoaWeiBi {
    public ZhoaWeiBi() {
    }

    public int[] randomArray() {
        return null;
    }

    public int totalWeight(int[] array, int left, int right) {
        int sumWeight = 0;

        for(int i = left; i <= right; ++i) {
            sumWeight += array[i];
        }

        return sumWeight;
    }

    public int findFakeCoin(int[] array, int left, int right) {
        int leftWeight = this.totalWeight(array, left, left + (right - left) / 2);
        int rightWeight = this.totalWeight(array, left + (right - left) / 2 + 1, right);
        if (leftWeight < rightWeight) {
            return left + 1 == right ? left : this.findFakeCoin(array, left, left + (right - left) / 2);
        } else {
            return left + 1 == right ? right : this.findFakeCoin(array, left + (right - left) / 2 + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 5, 5, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        ZhoaWeiBi test = new ZhoaWeiBi();
        int result = test.findFakeCoin(array, 0, 15);
        System.out.println(result);
    }
}
