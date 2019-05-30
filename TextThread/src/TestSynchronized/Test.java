package TestSynchronized;

class SafeCalc{
    static long value = 0L;
    synchronized long get(){
        return value;
    }
    synchronized static void addOne(){
        value += 1;
    }
}
public class Test {
    public static void main(String[] args) {
        SafeCalc safeCalc = new SafeCalc();
        SafeCalc safeCalc1 = new SafeCalc();
        //并没有锁住对象
        safeCalc.addOne();
        safeCalc1.addOne();
        System.out.println(safeCalc.get());
        System.out.println(safeCalc1.get());
    }
}
