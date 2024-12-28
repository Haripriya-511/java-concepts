package solidprinciples.liskov;

abstract class Bird1{
    public abstract void describe();
}
abstract class FlyingBird extends Bird1{
    public void fly(){
        System.out.println("I can fly!");
    }
}
abstract class NonFlyingBird extends Bird1{
    @Override
    public void describe() {
        System.out.println("I cannot fly...");
    }
}
class Sparrow1 extends FlyingBird{

    @Override
    public void describe() {
        System.out.println("I am a sparrow, and I can fly!");
    }
}
class Penguin1 extends NonFlyingBird{
    @Override
    public void describe() {
        System.out.println("I am a penguin, and I cannot fly!");
    }
}
public class LiskovExample {
    public static void main(String[] args) {
        Bird1 sparrow=new Sparrow1();
        Bird1 penguin=new Penguin1();


        sparrow.describe();
        ( (FlyingBird)(sparrow)).fly();
        penguin.describe();

    }
}
/*
Do not force subclasses to inherit behaviors they cannot honor.
Use proper abstraction (like interfaces) to separate unrelated behaviors.
Subtypes should remain consistent with the expectations of their parent type.
 */
/*
Avoid creating subclasses that fundamentally change the behavior of the base class.
Use composition or interfaces when inheritance doesn’t make sense.
Ensure that derived classes can substitute base classes without breaking expected functionality.
 */