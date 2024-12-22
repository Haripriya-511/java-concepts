package diningphilosopher;

import java.util.Random;

public class Philosopher implements Runnable{
    private int id;
    private volatile boolean full;
    private ChopStick leftChoStick;
    private ChopStick rightChopStick;
    private Random random;
    private int eatingCounter;
    public Philosopher(int id,ChopStick leftChoStick,ChopStick rightChopStick){
        this.id=id;
        this.leftChoStick=leftChoStick;
        this.rightChopStick=rightChopStick;
        this.random=new Random();

    }
    public void think() throws InterruptedException{
        System.out.println(this+" is thinking...");
        Thread.sleep(random.nextInt(1000));

    }
    public void eat() throws InterruptedException{
        System.out.println(this+" is eating...");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }
    public void setFull(boolean full){
        this.full=full;
    }

    @Override
    public void run() {
        try {
            while (!full) {
                think();
        if(leftChoStick.pickUp(this,State.LEFT))
        {
            //able to acquire left chopstick
            if(rightChopStick.pickUp(this,State.RIGHT)){
                eat();
                rightChopStick.putDown(this,State.RIGHT);
            }
            leftChoStick.putDown(this,State.LEFT);
        }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
public int getEatingCounter(){
        return eatingCounter;
}
    @Override
    public String toString() {
        return "Philosopher" + id ;
    }
}
