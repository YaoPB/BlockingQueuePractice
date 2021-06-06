package com.yaopb.producermodel;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable  {
	 protected BlockingQueue<Object> queue;

	    Producer(BlockingQueue<Object> theQueue) {
	        this.queue = theQueue;
	    }

	    public void run() {
	        try {
	            while (true) {
	                Object justProduced = getResource();
	                queue.put(justProduced);
	                System.out.println("生产者资源队列大小= " + queue.size());
	            }
	        } catch (InterruptedException ex) {
	            System.out.println("生产者 中断");
	        }
	    }
	    Object getResource() {
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException ex) {
	            System.out.println("生产者 读 中断");
	        }
	        return new Object();
	    }
}
