package arrayList;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {
    public static void main(String[] args) {

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
        CopyOnWriteArrayList<Integer> integers=new CopyOnWriteArrayList<>();
        integers.add(1);
        int i=0;
        for(Integer integer:integers){
            integers.add(2);
            System.out.println(integer);
        }
        System.out.println(integers);
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
