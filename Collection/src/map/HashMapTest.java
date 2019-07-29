package map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class HashMapTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /*HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(1,2);
        Iterator iterator=hashMap.entrySet().iterator();
        Iterator iterator1=hashMap.keySet().iterator();
        Collection c =hashMap.values();
        Iterator iterator2=c.iterator();

        Hashtable<Integer,Integer> hashtable=new Hashtable();
        hashtable.put(1,1);*/

        /*List<List> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("3");
        lists.add(list);
        lists.add(linkedList);
        System.out.println(lists);
        */
       /* String c=new String("123");
        final String a=c;

        c=new String("123123");
        System.out.println(a);



        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        //	strList.add(100);
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法
        Method m = listClass.getMethod("add", Object.class);
        //调用add()方法

        m.invoke(strList, 100);

        //遍历集合
        for(Object obj : strList){
            System.out.println(obj);
        }*/
       HashMap<Integer,Integer> a=new HashMap<>();
       a.put(1,2);
       a.put(1,3);
        System.out.println(a);
    }
}
