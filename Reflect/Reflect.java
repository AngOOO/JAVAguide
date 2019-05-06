import java.util.Date;
/*interface Computer {
    void printComputer();
}
class MacComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("Mac");
    }
}
class appleComputer implements Computer{

    @Override
    public void printComputer() {
        System.out.println("Apple");
    }
}
class Factory {
    public static Computer getInstance(String className){
        Computer computer = null;
        try{
            computer = (Computer) Class.forName(className).newInstance();
        }catch (InstantiationException | IllegalAccessException |
                ClassNotFoundException e){
            e.printStackTrace();
        }
        return computer;
    }
}*/
/*interface Lipstick{
    void printComputer();
}
class MacLipstick implements Lipstick{

    @Override
    public void printComputer() {
        System.out.println("a mac lipstick");
    }
}
class YSLLipstick implements Lipstick{

    @Override
    public void printComputer() {
        System.out.println("a YSL lipstick");
    }
}
class LipstickFactory{
    public static Lipstick getInstance(String className){
        Lipstick lipstick = null;
        try {
            lipstick = (Lipstick) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lipstick;
    }
}*/
/*
interface buyBook{
    void printBuyBook();
}
class EnglishBook implements buyBook{

    @Override
    public void printBuyBook() {
        System.out.println("buy a English book");
    }
}
class ChineseBook implements buyBook{

    @Override
    public void printBuyBook() {
        System.out.println("buy a Chinese book");
    }
}
class MathBook implements buyBook{

    @Override
    public void printBuyBook() {
        System.out.println("buy a Math book");
    }
}
class BookFactory{
    public static buyBook getInstance(String className){
        buyBook buybook = null;
        try {
            buybook = (buyBook) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return buybook;
    }
}
public class Reflect {
    public static void main(String[] args)  {
        buyBook buybook = BookFactory.getInstance("ChineseBook");
        buybook.printBuyBook();
    }
}
*/
class Person{
    private void print(){
        System.out.println("Person的print方法");
    }
}
class Student extends Person{
    void print(){
        System.out.println("Student的print方法");
    }
}
public class Reflect{
    public static void main(String[] args) {
        new Student().print();
    }
}