package aula3;

import java.rmi.* ;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.net.*;

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
    		
    		 InetAddress group = InetAddress.getByName("228.5.6.7");
    		 MulticastSocket MCSocket = new MulticastSocket();

    		 String msg = "H";

    		 DatagramPacket dpmsg = new DatagramPacket(msg.getBytes(), msg.length(), group, 6789);
    		 MCSocket.send(dpmsg);

    		 byte[] buf = new byte[5000];
    		 
    		 DatagramPacket rcv = new DatagramPacket(buf, buf.length);
    		 MCSocket.receive(rcv);
    	

    		 ByteArrayInputStream bais = new ByteArrayInputStream(rcv.getData(),0,rcv.getLength()) ;
    		 ObjectInputStream ois = new ObjectInputStream(bais);

    		/*IFileServer server = (IFileServer) Naming.lookup("//" + serverHost + "/myFileServer") ;
        	

    		server.getFile( new FileTransferImpl(), filename );*/
        
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
