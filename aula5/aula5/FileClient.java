package aula5;

import java.rmi.* ;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class FileClient {
    
    public static void main(String[] args) throws Exception {
        if( args.length != 2) {
        	System.out.println( "Use: java FileClient server_host filename");
        	System.exit(0);
        }

        String filename = args[1];
        String serverHost = args[0];
       
        try {
    		System.getProperties().put( "java.security.policy", "aula3/policy.all");
    		
    		if( System.getSecurityManager() == null) {
    			System.setSecurityManager( new RMISecurityManager());
    		}

    		IFileServer server = (IFileServer) Naming.lookup("//" + serverHost + "/myFileServer") ;

    		for (int i = 0; i < 10; i++)
    			server.getFile( new FileTransferImpl(), filename );
        
    		// Alternativamente...
        	//server.getFile( (IFileTransfer)UnicastRemoteObject.toStub( new FileTransferImpl() ), filename ) ;
        	
        } catch( Exception e) {
        	e.printStackTrace();
        }
    }
}

class FileTransferImpl extends UnicastRemoteObject implements IFileTransfer
{
	protected FileTransferImpl() throws RemoteException {
		super();
	}

	public void putFile( FileToTransfer f ) throws RemoteException, IOException {
		f.printFile( System.out );
		System.out.println("Transfer complete.") ;
	}
}
