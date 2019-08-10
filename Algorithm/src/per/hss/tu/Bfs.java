package per.hss.tu;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * 使用bfs 求出最短路径的长度 和最短路径
 */
public class Bfs {
    public static void main(String[] args) {

        int a[][] = new int[][]
                {
                        {0, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 0, 0},
                };
        // System.out.println(minPathLength(a, 2, 3));
        int row = a.length;
        int col = a[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        int dic[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};//四个方向 右  下  上  左
        queue.offer(0);
        HashMap<Integer, Integer> path = new HashMap<>();
        int length=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            length++;
            while (size-->0) {
                Integer num = queue.poll();
                int h = num / col;
                int l = num % col;
                a[h][l] = 1;//表示已经走过了
                for (int i = 0; i < dic.length; i++) {
                    h = num / col + dic[i][0];//行
                    l = num % col + dic[i][1];//列
                    if (l <= col - 1 && l >= 0 && h <= row - 1 && h >= 0) {
                        if (h == row - 1 && l == col - 1) {
                            System.out.println("到了终点");

                        }
                        if (a[h][l] != 1) {
                            queue.offer(h * col + l);
                            path.put(h * col + l, num);
                        }
                    }
                }
            }

        }
        System.out.println(path);
        System.out.println(length);
        //使用一个hashmap记录下来路径
        int flag=col*row-1;
        while (true)
        {
            //获取其key和value
            if(path.get(flag)!=null)
            {
                System.out.println(flag);
                flag=path.get(flag);
            }
            if(flag==0)
            {
                break;
            }
        }
    }
}
