package Model;

public class SingleTon {
    /*//饿汉单例
    private static final SingleTon instance1 = new SingleTon();
    private SingleTon(){}
    public static SingleTon getInstance1(){
        return instance1;
    }*/

    /*//懒汉单例
    private static SingleTon instance2 = null;
    private SingleTon(){}
    public static SingleTon getInstance2(){
        if (instance2 == null){
            instance2 = new SingleTon();
        }
        return instance2;
    }*/

    //线程安全的懒汉单例
    private static volatile SingleTon instance3 = null;
    private SingleTon(){}
    public static SingleTon getInstance3(){
        if (instance3 == null){
            synchronized (SingleTon.class){
                if (instance3 == null){
                    instance3 = new SingleTon();
                }
            }
        }
        return instance3;
    }
}
