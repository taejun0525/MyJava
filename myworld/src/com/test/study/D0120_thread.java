package com.test.study;

public class D0120_thread {
	public static void main (String args[]) {
		Thread thread1 = new Thread ( new Runnable(){ //메인 스레드 생성
			@Override
				public void run(){
				for (int i=0; i<100000; i++) {
					System.out.println(i+"*****");
					try{
						Thread.sleep(1000);
			 		} catch ( Exception e){}
				}
			}
		}); // 메인 스레드 정의
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run(){
				while(true) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					break;
				}
				System.out.println("save---");
		
			}
			System.out.println("quit---");
		}
	});
		thread3.setDaemon(true);
		thread1.start(); //work thread
			
		for (int i=0; i<100000; i++){
			System.out.println(i);;
			try{
				Thread.sleep(500);;
			} catch(Exception e) {}
		}
	}
}
