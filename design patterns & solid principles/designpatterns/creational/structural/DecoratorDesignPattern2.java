package designpatterns.creational.structural;

abstract class Burger{
    private String description;
    private double cost;
    public abstract String getDescription();
    public  abstract double getCost();
}
class ZingerBurger extends Burger{

    @Override
    public String getDescription() {
        return "Zinger Burger";
    }

    @Override
    public double getCost() {
        return 180.0;
    }
}
class SmallBurger extends Burger{

    @Override
    public String getDescription() {
        return "Small Burger";
    }

    @Override
    public double getCost() {
        return 90.0;
    }
}
abstract class BurgerDecorator extends Burger{

}
class ExtraCheese extends BurgerDecorator{

    private Burger burger;
    public ExtraCheese(Burger burger){
        this.burger=burger;
    }
    @Override
    public String getDescription() {
        return burger.getDescription()+" with extra cheese";
    }

    @Override
    public double getCost() {
        return burger.getCost()+10.0;
    }
}
class ExtraMayo extends BurgerDecorator{

    private Burger burger;
    public ExtraMayo(Burger burger){
        this.burger=burger;
    }
    @Override
    public String getDescription() {
        return burger.getDescription()+" with extra Mayo";
    }

    @Override
    public double getCost() {
        return burger.getCost()+30.0;
    }
}
public class DecoratorDesignPattern2 {
    public static void main(String[] args) {
    Burger burger=new ZingerBurger();
        System.out.println(burger.getDescription()+", "+burger.getCost());
        burger=new ExtraCheese(burger);
        System.out.println(burger.getDescription()+", "+burger.getCost());
        burger=new ExtraMayo(burger);
        System.out.println(burger.getDescription()+", "+burger.getCost());

Burger burger1=new ExtraCheese(new ExtraMayo(new SmallBurger()));
        System.out.println(burger1.getDescription()+", "+burger1.getCost());
    }
}
