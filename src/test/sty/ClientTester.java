package sty;

import java.util.ArrayList;
import java.util.List;

public class ClientTester {
	public static void main (String [] inargs) {
		List<String> args = null;
		
		//Producer
		args = new ArrayList<String>();
		args.add("qTest");
		args.add("localhost:2181");
		args.add("2");
		args.add("p");
		SyncPrimitive.main(args.toArray(new String[0]));
		
		//Consumer
//		args = new ArrayList<String>();
//		args.add("qTest");
//		args.add("localhost:2181");
//		args.add("2");
//		args.add("c");
//		SyncPrimitive.main(args.toArray(new String[0]));
	}
	
}
