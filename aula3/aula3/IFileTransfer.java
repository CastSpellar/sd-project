package aula3;

import java.io.* ;
import java.rmi.* ;

public interface IFileTransfer extends Remote {
	public void putFile( FileToTransfer f ) throws RemoteException, IOException ;
}
