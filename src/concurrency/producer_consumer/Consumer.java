package concurrency.producer_consumer;

import java.util.List;

public class Consumer implements Runnable {
	
	private List<String> buffer;
	
	public Consumer(List<String> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			synchronized(this.buffer) {
				
			
	            if (buffer.isEmpty()){
	                continue;
	            }
	            else {
	            	
	            	System.out.printf("%1$s %2$s %n",Thread.currentThread().getName(),buffer);
	            }
	            if (buffer.get(0).equals(Main.EOF)){
	                System.out.println(Thread.currentThread().getName()+" exiting.");
	                break;
	            } else {
	                System.out.println(Thread.currentThread().getName()+ " removed " +buffer.remove(0));
	            }
			}
        }
	}

}
