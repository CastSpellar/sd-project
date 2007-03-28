package aula5;

import java.rmi.*;
import java.io.*;

public interface IFileServer extends Remote
{
	public void getFile( IFileTransfer c, String filename ) throws RemoteException, IOException ;
}
