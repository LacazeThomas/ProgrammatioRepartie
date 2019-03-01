import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.lang.Boolean;

public  class BAL2 {


    private BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(2) ;

    public boolean write(String parlettre) {
		try {
			queue.put(parlettre);
		}  catch (InterruptedException e) {
			return false;
		}
		return true;
   }

    public String read() throws InterruptedException {
		if(queue.take().equals("*")){
			System.exit(1);
		}
	   return queue.take();
   }

}