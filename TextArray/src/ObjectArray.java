class Person{
    private String name;
    private int age;
    private int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }
}
public class ObjectArray {
    public static void main(String[] args) {
        Person[] per = new Person[3];
        per[0] = new Person("张三",20);
        per[1] = new Person("王五",21);
        per[2] = new Person("马六",23);
        for (int i =0;i< 3;i++){
            System.out.println(per[i].getName());
        }
    }
}
