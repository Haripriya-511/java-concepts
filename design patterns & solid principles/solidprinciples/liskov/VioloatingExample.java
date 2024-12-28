package solidprinciples.liskov;
class Bird{
    public void fly(){
        System.out.println("I can fly!!!");
    }

}
class Sparrow extends Bird{

}
class Penguin extends Bird{
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");}
}
public class VioloatingExample {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        // Expected behavior
        sparrow.fly();  // Works fine

        // Unexpected behavior
        penguin.fly();  // Throws an exception
    }
}
/*
The Penguin class violates LSP because it cannot honor the fly behavior defined in the Bird class.
This leads to unexpected behavior (exceptions) when Penguin is substituted for Bird.

 */
