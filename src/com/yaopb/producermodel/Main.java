package com.yaopb.producermodel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static void main(String[] args) {
		  int numProducers = 4;
	        int numConsumers = 3;

	        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(5);

	        for (int i = 0; i < numProducers; i++) {
	            new Thread(new Producer(myQueue)).start();
	        }

	        for (int i = 0; i < numConsumers; i++) {
	            new Thread(new Consumer(myQueue)).start();
	        }

	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        System.exit(0);
	}
}
