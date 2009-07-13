package sty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import junit.framework.TestCase;

public class TestBasicClient extends TestCase {

	public void testSyncPrimitve_Queue() {
		List<String> args = null;
		
		//Producer
		args = new ArrayList<String>();
		args.add("qTest");
		args.add("localhost:2181");
		args.add("2");
		args.add("p");
		SyncPrimitive.main(args.toArray(new String[0]));
		
		//Consumer
		args = new ArrayList<String>();
		args.add("qTest");
		args.add("localhost:2181");
		args.add("2");
		args.add("c");
		SyncPrimitive.main(args.toArray(new String[0]));
		
	}

	public void testSyncPrimitve_Barrier() {
		List<String> args = null;
		
		args = new ArrayList<String>();
		args.add("bTest");
		args.add("localhost:2181");
		args.add("5");
		SyncPrimitive.main(args.toArray(new String[0]));
		
	}
	
	public void testExceutor() {
		List<String> args = null;
		
		args = new ArrayList<String>();
		args.add("localhost:2181");
		args.add("/exec");
		args.add("test");
		args.add("client1");
		args.add("client2");
		
		Executor.main(args.toArray(new String[0]));
		
	}
	
	public void testMultiClient() {
		//Setting up args
		List<String> args = null;
		args = new ArrayList<String>();
		args.add("localhost:2181");
		args.add("/b");
		args.add("test");
		args.add("client1");
		args.add("client2");
		
		int nrWorkers = 5;
		Worker [] workers = new Worker[nrWorkers];
		//Creating workers
		for(int i=0; i<nrWorkers; i++) {
			workers[i] = new Worker(i, args.toArray(new String[0]));
			workers[i].start();
//			workers[i].run();
			System.out.println("Started worker " + i);
		}
	}
	
	private class Worker extends Thread {
		private Random rand = new Random();
		private int worker = 0;
		private String [] args  = null;
		public Worker(int worker, String [] args) {
			this.worker = worker;
			this.args = args;
		}
		
		public void run() {
			//Sleep
			int sleep = this.rand.nextInt(100);
			try {
				Thread.sleep(sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Executing worker " + worker);
			Executor.main(args);
//			System.out.println("Executed worker " + worker);
			//Loop
			while (true) {
				
			}
		}
	}

}
