package executorthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{
    private final int id;
    public Processor(int id){
        this.id=id;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Id: "+id;
    }
}
public class CallableExample {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        List<Future<String>> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            Future<String> future = service.submit(new Processor(i + 1));
            list.add(future);
        }
        for(Future<String> f:list){
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }

        }
    }
}
