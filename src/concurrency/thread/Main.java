package concurrency.thread;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main thread is running");
		try {
			System.out.println("Main thread pause 2 second");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread thread = new Thread(() -> {
			String name = Thread.currentThread().getName();
			System.out.printf("%1$s take 500ms to run %n",name);
			for(int i = 0; i < 10; i++) {
				System.out.print(".");
				try {
					Thread.sleep(500);
					System.out.println("A. current thread state "+ Thread.currentThread().getState());
				} catch (Exception e) {
					System.out.printf("%1$s has interrupted",name);
					System.out.println("B. current thread state " + Thread.currentThread().getState());
					// TODO: handle exception
					return;
				}
			}
			System.out.printf("%n %1$s completed execution %n",name);
		});
		thread.start();
		
		long now = System.currentTimeMillis();
		while(thread.isAlive()) {
			
			try {
				Thread.sleep(1000);
				if(System.currentTimeMillis() - now > 2000) {
					if(thread.isAlive()) {
						
						thread.interrupt();
						System.out.println("C. thread state " + thread.getState());
					}
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}

}
