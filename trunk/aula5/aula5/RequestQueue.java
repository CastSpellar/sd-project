package aula5;

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

	public void run() {
		for (;;) {
			// TODO: Retirar o pedido da fila e processa-lo
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
