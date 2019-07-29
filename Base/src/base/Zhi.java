package base;

/**
 * 引用传递和值传递
 */
class Student{
    private  int age;
    private String name;
    public  Student(){

    }
    public Student(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Zhi {
    private static Student user= null;
    private  static Student student=null;
    public static void change(Student a,Student b){
        Student temp=a;
        a=b;
        b=temp;
    }
    public  static void modify(Student s){
        s.setAge(1);
        s.setName("ahhh");
    }
    public static void main(String[] args) {
            user=new Student("hss",19);
        student=new Student("hss1",20);
           change(user,student);
        System.out.println(user);
        System.out.println(student);
        modify(student);
        System.out.println(student);
    }
}
