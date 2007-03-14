package aula3;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class FileServerImpl extends UnicastRemoteObject implements IFileServer
{
	protected FileServerImpl() throws RemoteException {
		super();
	}

	public void getFile( IFileTransfer t, String filename ) throws RemoteException, IOException {
		System.out.println("Sending file " + filename + " to client.") ;
		t.putFile( new FileToTransfer( filename ) ) ;
		System.out.println("Done.") ;
	}
	
	public static void MultiCast() { 
		
		try {
		 InetAddress group = InetAddress.getByName("228.5.6.7");
		 MulticastSocket MCSocket = new MulticastSocket(6789);
		 MCSocket.joinGroup(group);
		 byte[] buf = new byte[5000];
		 DatagramPacket receive = new DatagramPacket(buf, buf.length);
		 MCSocket.receive(receive);
		 FileServerImpl server = new FileServerImpl();
		 ByteArrayOutputStream baos = new   ByteArrayOutputStream() ;
		 ObjectOutputStream oos = new ObjectOutputStream(baos);
		 oos.writeObject(UnicastRemoteObject.toStub(server));
		 oos.flush();	 
	         oos.close();	
			byte[] arr=baos.toByteArray();

		 receive.setData(arr);
		receive.setLength(arr.length);
		System.out.println(arr.length);
                 MCSocket.send(receive); 
		 MCSocket.leaveGroup(group);
		} catch( Exception e) {

		}

	}
	
	
	
	public static void main( String args[]) throws Exception {
		try {
			System.getProperties().put( "java.security.policy", "aula3/policy.all");

			if( System.getSecurityManager() == null) {
				System.setSecurityManager( new RMISecurityManager());
			}
			
			if( args.length != 0) {
				System.err.println( "Use: java aula3.FileServerImpl");
				System.exit( 0);
			}
			
			MultiCast();
			
			//Naming.rebind( "/myFileServer", new FileServerImpl());
			//System.out.println( "FileServer bound in registry");
			
		} catch( Throwable th) {
			th.printStackTrace();
		}
	}

}
