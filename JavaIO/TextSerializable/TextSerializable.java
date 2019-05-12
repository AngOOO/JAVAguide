package TextSerializable;

import java.io.*;

class Student implements Serializable {
    private String name;
    private transient int age;//使用transient修饰的对象序列化时不被保留
    private int number;
    private float grade;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public float getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", grade=" + grade +
                '}';
    }
}
public class TextSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setName("张三");
        student.setAge(20);
        student.setNumber(20190101);
        student.setGrade(60.5f);

        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt");
        //序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(student);
        out.close();
        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object object = in.readObject();
        Student student1 = (Student) object;
        System.out.println(object);
        in.close();
    }
}
