package TestSynchronized;

public class ProtectSameObject {
    static class Account1 {
        private int balance;
        //内建锁
        synchronized void transfer(Account1 target, int amt) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
    public static void TestAccount1() throws InterruptedException {
        Account1 a = new Account1();
        Account1 b = new Account1();
        Account1 c = new Account1();
        a.balance =100;
        b.balance =0;
        c.balance = 200;
        a.transfer(b,10);
        Thread.sleep(2000);
        b.transfer(c,10);
        //无法实现
        System.out.println(a.balance);//90
        System.out.println(b.balance);//0
        System.out.println(c.balance);//210
    }
    static class Account2{
        private Integer balance;
        void transfer(Account2 target,int amt){
            synchronized (Account2.class){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
    public static void TestAccount2() {
        Account2 a = new Account2();
        Account2 b = new Account2();
        Account2 c = new Account2();
        a.balance =100;
        b.balance =100;
        c.balance = 200;
        a.transfer(b,100);
        b.transfer(c,100);
        //无法实现
        System.out.println(a.balance);//0
        System.out.println(b.balance);//100
        System.out.println(c.balance);//400
    }
    static class Account3{
        private Integer balance;
        void transfer(Account3 target,int amt){
            synchronized (this){//锁住当前账户
                synchronized (target){//锁定对方账户
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        }
    }
    public static void TestAccount3(){
        Account3 a = new Account3();
        Account3 b = new Account3();
        Account3 c = new Account3();
        a.balance = 100;
        b.balance = 0;
        c.balance = 90;
        a.transfer(b,10);
        b.transfer(c,5);
        //完成相同对象的锁定问题
        System.out.println(a.balance);//90
        System.out.println(b.balance);//5
        System.out.println(c.balance);//95
    }
    public static void main(String[] args) throws InterruptedException {
        TestAccount3();
    }

}
