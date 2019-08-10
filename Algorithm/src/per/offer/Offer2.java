package per.offer;

import java.util.*;


public class Offer2 {
    public static void main(String[] args) {
        Offer2 te=new Offer2();
        System.out.println( te.maxInWindows(new int[]{2,3,4,2,6,2,5,1},0));

    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(size==0)
            return new ArrayList<Integer>();
        ArrayDeque<Integer> arrayDeque=new ArrayDeque();//这个队列中添加的是数组
        int begin=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<num.length;i++)
        {
            begin=i-size+1;
            if(arrayDeque.isEmpty())
            {
                arrayDeque.add(i);
            }
            else if(begin > arrayDeque.peekFirst())
            {
                arrayDeque.pollFirst();//往后移的时候
            }
            while ((!arrayDeque.isEmpty()) &&  num[arrayDeque.peekLast()]<=num[i])
            {
                arrayDeque.pollLast();
            }
            arrayDeque.add(i);
            if(begin>=0)
            {
                arrayList.add(num[arrayDeque.peekFirst()]);
            }
        }
        return arrayList;
    }


    private int count = 0;
    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num) {
        if(count%2==0)
        {
            maxHeap.offer(num);
            int filteredMaxNum=maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        }
        else {


            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
    }

    public Double GetMedian() {



        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

}
