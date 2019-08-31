package Model;

interface BuyComputer{
    void buyCom();
}
class Real implements BuyComputer{
    @Override
    public void buyCom() {
        System.out.println("buy computer");
    }
}
class Proxy implements BuyComputer{
    private BuyComputer buyComputer;
    public Proxy(BuyComputer buyComputer){
        this.buyComputer = buyComputer;
    }
    public void produce(){
        System.out.println("1、生产电脑");
    }
    public void after(){
        System.out.println("3、售后");
    }
    @Override
    public void buyCom() {
        this.produce();
        this.buyComputer.buyCom();
        this.after();
    }
}
class Factory{
    public static BuyComputer getInstance(){
        return new Proxy(new Real());
    }
}
public class AgencyModel {
}
