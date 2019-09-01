public class Test {
    public static void main(String[] args) {
        Per per = new Stu();//向上转型
        Stu stu = (Stu) per;//向下转型
    }
}
class Per{}
class Stu extends Per{}