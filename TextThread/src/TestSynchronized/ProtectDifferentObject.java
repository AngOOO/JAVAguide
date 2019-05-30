package TestSynchronized;

public class ProtectDifferentObject {
    //保护多个没有关联关系的对象
    //余额与密码不需要同时被上锁，分别上锁提高效率
    class Account{
        //账户余额
        private Integer balance;
        //账户密码
        private String password;
        //余额锁，保护余额
        private final Object balanceLock = new Object();
        //密码锁，保护密码
        private final Object passwordLock = new Object();

        //取款、只有余额变更
        void withDraw(Integer amt){
            synchronized (balanceLock){
                if (this.balance > amt){
                    this.balance -= amt;
                }
            }
        }
        //查看余额
        Integer getBalance(){
            synchronized (balanceLock){
                return balance;
            }
        }
        //更改密码，只有密码更改
        void updatePassword(String pw){
            synchronized (passwordLock){
                this.password = pw;
            }
        }
        //查看密码
        String getPassword(){
            synchronized (passwordLock){
                return password;
            }
        }
    }
}
