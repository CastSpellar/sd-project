package aula3;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

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
			
			Naming.rebind( "/myFileServer", new FileServerImpl());
			System.out.println( "FileServer bound in registry");
		} catch( Throwable th) {
			th.printStackTrace();
		}
	}

}
