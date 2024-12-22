package studentLibrary;

import java.util.Random;

public class Student implements Runnable{
  private int id;
  private Book[] books;
  private Random random;
  public Student(int id,Book[] books){
      this.id=id;
      this.books=books;
      this.random=new Random();
  }

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
          int bookId = random.nextInt(Constants.NUM_OF_BOOKS);
          try{
              books[bookId].read(this);
              Thread.sleep(500);
          }catch (InterruptedException ex){
              System.out.println(this + " was interrupted.");
              Thread.currentThread().interrupt(); // Preserve interrupt status
          }
      }

    }

    @Override
    public String toString() {
        return "Student"+this.id;
    }
}
