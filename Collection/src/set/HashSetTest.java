package set;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {

        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);

        System.out.println(set);
    }
}
