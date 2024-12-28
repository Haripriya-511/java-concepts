package designpatterns.creational;
class Burger {
    private String bun;
    private String patty;
    private boolean hasCheese;
    private boolean hasLettuce;
    private boolean hasTomatoes;

    // Setters
    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setPatty(String patty) {
        this.patty = patty;
    }

    public void setCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    public void setLettuce(boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
    }

    public void setTomatoes(boolean hasTomatoes) {
        this.hasTomatoes = hasTomatoes;
    }

    @Override
    public String toString() {
        return "Burger [bun=" + bun +
                ", patty=" + patty +
                ", hasCheese=" + hasCheese +
                ", hasLettuce=" + hasLettuce +
                ", hasTomatoes=" + hasTomatoes + "]";
    }
}
interface BurgerBuilder {
    void chooseBun(String bun);
    void addPatty(String patty);
    void addCheese(boolean hasCheese);
    void addLettuce(boolean hasLettuce);
    void addTomatoes(boolean hasTomatoes);
    Burger getBurger();
}
 class VegBurgerBuilder implements BurgerBuilder {
    private Burger burger;
     private String bun;
     private String patty;
     private boolean hasCheese;
     private boolean hasLettuce;
     private boolean hasTomatoes;

    public VegBurgerBuilder() {
        this.burger = new Burger();
    }

    @Override
    public void chooseBun(String bun) {
        burger.setBun(bun);
    }

    @Override
    public void addPatty(String patty) {
        burger.setPatty(patty);
    }

    @Override
    public void addCheese(boolean hasCheese) {
        burger.setCheese(hasCheese);
    }

    @Override
    public void addLettuce(boolean hasLettuce) {
        burger.setLettuce(hasLettuce);
    }

    @Override
    public void addTomatoes(boolean hasTomatoes) {
        burger.setTomatoes(hasTomatoes);
    }

    @Override
    public Burger getBurger() {
        return burger;
    }
}
class Chef {
    private BurgerBuilder builder;

    public Chef(BurgerBuilder builder) {
        this.builder = builder;
    }

    public void makeBurger(String bun, String patty, boolean hasCheese, boolean hasLettuce, boolean hasTomatoes) {
        builder.chooseBun(bun);
        builder.addPatty(patty);
        builder.addCheese(hasCheese);
        builder.addLettuce(hasLettuce);
        builder.addTomatoes(hasTomatoes);
    }
    public Burger getBurger() {
        return builder.getBurger();
    }
}

public class BuilderPattern1 {
    public static void main(String[] args) {
        // Create a VegBurgerBuilder
        BurgerBuilder vegBurgerBuilder = new VegBurgerBuilder();

        // Pass the builder to the Chef
        Chef chef = new Chef(vegBurgerBuilder);

        // Chef makes the burger
        chef.makeBurger("Sesame bun","Chicken patty",true,false,true);

        // Get the completed burger
        Burger burger = chef.getBurger();

        // Print the burger details
        System.out.println(burger);
    }
}
