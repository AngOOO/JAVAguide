package Model;

interface Computer{
    void computer();
}
class MacComputer implements Computer{

    @Override
    public void computer() {
        System.out.println("mac");
    }
}
class AliveComputer implements Computer{

    @Override
    public void computer() {
        System.out.println("alive");
    }
}
interface ComputerFactory{
    void makeComputer();
}
class MacFactory implements ComputerFactory{

    @Override
    public void makeComputer() {
        System.out.println("make mac");
    }
}
class AliveFactory implements ComputerFactory{

    @Override
    public void makeComputer() {
        System.out.println("make alive");
    }
}
public class FactoryModel {
}
