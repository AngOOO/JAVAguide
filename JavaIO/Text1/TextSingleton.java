package Text1;
class Singleton{
    private static volatile Singleton singleton;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){//保证原子性，可见性
                if (singleton == null){
                    singleton = new Singleton();//保证有序
                }
            }
        }
        return singleton;
    }
}
public class TextSingleton {
}
