package aula5;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class FileServerImpl extends UnicastRemoteObject implements IFileServer
{
	private RequestQueue queue ;
	
	protected FileServerImpl() throws RemoteException {
		super();
		queue = new RequestQueue() ;
	}
	
	public void getFile( IFileTransfer t, String filename ) throws RemoteException, IOException {
		System.out.println("Adding request to the queue...") ;
		queue.addRequest( filename, t ) ;
	}
	
	public static void main( String args[]) throws Exception {
		try {
			System.getProperties().put( "java.security.policy", "aula5/policy.all");

			if( System.getSecurityManager() == null) {
				System.setSecurityManager( new RMISecurityManager());
			}
			
			if( args.length != 0) {
				System.err.println( "Use: java aula5.FileServerImpl");
				System.exit( 0);
			}
			
			Naming.rebind( "/myFileServer", new FileServerImpl());
			System.out.println( "FileServer bound in registry");
			
		} catch( Throwable th) {
			th.printStackTrace();
		}
	}

}
