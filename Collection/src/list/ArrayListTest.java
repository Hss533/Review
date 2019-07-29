package list;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
       /* ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.add(4);

        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

       LinkedList linkedList=new LinkedList();
        List<String> list = new ArrayList<String>();
//        Collections.binarySearch(list,"a");
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(Collections.binarySearch(list,""));
        /*Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            String str = (String) iterator.next();
            if(str.equals("d")){
                list.remove(str);
            }else{
                System.out.println(str);
            }
        }*/
        for(String str:list){
            if(str.equals("d")){
                list.remove(str);
            }else{
                System.out.println(str);
            }

        }
       /* ArrayList<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("v");
        //remove(list);
        for(int i=0;i<list.size();i++)
        {
            String s=list.get(i);
            System.out.println(s);
            if(s.equals("c"))
            {
                list.remove(s);
            }
        }*/
//        System.out.println(list);
       /* CopyOnWriteArrayList<Integer> integers=new CopyOnWriteArrayList<>();
        integers.add(1);
        int i=0;
        for(Integer integer:integers){
            integers.add(2);
            System.out.println(integer);
        }
        System.out.println(integers);*/
    }
    public static void remove(ArrayList<String> list)
    {
        for(int i=0;i<list.size();i++)
        {
            String s=list.get(i);
            if(s.equals("b"))
            {
                list.remove(s);
            }
        }
    }
}
