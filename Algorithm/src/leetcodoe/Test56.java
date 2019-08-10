package leetcodoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Test56 {
    public static void main(String[] args) {
        int[][] re = new Test56().merge(new int[][]{
                {1, 9}, {0, 6}, {8, 16}, {15, 18}
        });
        for (int i = 0; i < re.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(re[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ints = new ArrayList<>();
        if (intervals.length == 1 || intervals.length == 0)
            return intervals;
        for (int i = 0; i < intervals.length; i++) {
            ints.add(intervals[i]);
        }
        ints.sort((o1, o2) -> {
            if (o1[0] > o2[0])
                return 1;
            else if (o1[0] == o2[0])
                return 0;
            else
                return -1;
        });
        for (int i = 0; i < ints.size(); i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ints.get(i)[j] + " ");
            }
            System.out.println();
        }
        int start = ints.get(0)[0];
        int end = ints.get(0)[1];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < ints.size(); ) {
            int[] a = new int[2];
            a[0] = start;
            a[1] = end;

            while (i < ints.size() && ints.get(i)[0] <= end) {
                if (ints.get(i)[1] > end) {
                    end = ints.get(i)[1];
                    a[1]=end;
                }
                i++;
            }
            result.add(a);
            if (i < ints.size()) {
                start = ints.get(i)[0];
                end = ints.get(i)[1];
            }
        }
        int[][] re = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}
