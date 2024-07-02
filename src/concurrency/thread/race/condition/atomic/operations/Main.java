package concurrency.thread.race.condition.atomic.operations;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	static class Account{
		
		public static int balance = 1000;
		public synchronized void deposit(int amount) {
			
			try {
				Thread.sleep(1000);
				this.balance += amount;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public synchronized void withdraw(int amount) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Account account1 = new Account();
		
		Account account2 = new Account();
		
		Thread thread1 = new Thread(() -> {
			
			account1.deposit(1000);
			
		});
		
		Thread thread2 = new Thread(() -> {
			
		});
		thread1.setName("thread 1");
		thread2.setName("thread 2");
		thread1.start();
		thread2.start();
	}

}
