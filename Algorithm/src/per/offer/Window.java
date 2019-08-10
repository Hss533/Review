package per.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Window {
    public static void main(String[] args) {
//       int a[]=
        System.out.println(     new Window().maxInWindows(new int[]{1,3,-1,-3,5,3,6,7},3));
        /*for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }*/
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k)
                res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
    public int[] myWindow(int[] nums,int k)
    {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
        {
             if(!deque.isEmpty()&&deque.peekFirst()==i-k)deque.poll();

             while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i])deque.removeLast();

             deque.offerLast(i);


        }
        for(int i=0;i<deque.size();i++)
            System.out.println(deque.getFirst());
        return null;
    }
    public int[] slide(int[] arr, int n, int w) {
        //result数组中保存每个窗口状态下的最大值
        int[] result = new int[n-w+1];
        //记录双端队列队头的下标 ，队尾下标
        int[] qmax = new int[n];
        int front = 0, back = 0;
        //j 标记是否达到窗口大小,同时记录result中下一个应该放入的元素的下标
        int j = 0;
        for(int i=0; i<n; i++){
            while(front < back && arr[qmax[back-1]] < arr[i])//back为当前要往qmax中放入的值
                back--;
            qmax[back++] = i;
            if(j+w-1 == i){
                //达到窗口长度
                result[j] = arr[qmax[front]];
                j++;
            }
            if(qmax[front]+w-1 == i){
                //队头过期
                front++;
            }
        }
        return result;
    }


    public ArrayList<Integer> maxInWindows(int [] num, int size)

    {  if(size==0)
        return new ArrayList<>();

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
                arrayDeque.pollFirst();
            }
            System.out.println(arrayDeque);
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
}
