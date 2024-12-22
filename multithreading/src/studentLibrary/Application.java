package studentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args)throws InterruptedException  {
        Student[] students=null;
        Book[] books=null;
        ExecutorService service=Executors.newFixedThreadPool(Constants.NUM_OF_STUDENTS);
        try{
        books=new Book[Constants.NUM_OF_BOOKS];
        students= new Student[Constants.NUM_OF_STUDENTS];
        for(int i=0;i<Constants.NUM_OF_BOOKS;i++){
            books[i]=new Book(i+1);
        }
        for(int i=0;i<Constants.NUM_OF_STUDENTS;i++){
            students[i]=new Student(i+1,books);
            service.execute(students[i]);
        }
            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
        }finally {
service.shutdownNow();
            System.out.println("Simulation ended.");
        }

    }
}
