package base;

/**
 * Java反射练习
 */
public class Reflect {
    public static void main(String[] args) {
        try {
            Class clazz=Class.forName("base.Student");
//            Class test=Student.class;//不会自动初始化 该类
            //获取字面常量的Class引用是，触发的应该是加载阶段，在这个阶段Class对象已创建完成
            //classNotFound 异常
            System.out.println(clazz.getName());
            Student student=(Student) clazz.newInstance();//必须有无参的构造方法
            student.setAge(1);
            student.setName("asdasd");
            System.out.println(student);
            System.out.println("---------------------------------");
            System.out.println("instanceOf和inInstance产生的结果是相同的");

            // alter table a add index index_name (column_list)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
