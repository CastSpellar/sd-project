package aula5;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

public class RequestQueue implements Runnable {

	private LinkedList<Request> queue;

	public RequestQueue() {
		queue = new LinkedList<Request>();
		new Thread( this ).start() ;
	}

	public void addRequest(String filename, IFileTransfer callback) {
		synchronized (queue) {
			queue.addLast(new Request(filename, callback));
			System.out.println("Number of pending requests:" + queue.size() ) ;
			queue.notify();
		}
	}
	
	public Request remove() {
		synchronized( queue ) {
			while( queue.isEmpty())
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 return queue.removeFirst();
		}
	}

	public void run() {
		Request r;
		for (;;) {
			
			r = remove();
		
				try {
					r.callback.putFile(new FileToTransfer(r.filename));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
	}
}

class Request {
	String filename;
	IFileTransfer callback;

	public Request(String filename, IFileTransfer callback) {
		this.filename = filename;
		this.callback = callback;
	}
}
