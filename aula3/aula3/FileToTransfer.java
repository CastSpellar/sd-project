package aula3;

import java.io.* ;

/**
 * Representa o ficheiro a ser transferido por serialziacao, usando o metodo
 * não automático de definir o formato da serialização, redefinindo os
 * métodos ("escondidos") do interface Serializable.
 * O ficheiro ao ser recebido vai ser guardado com o nome original concatenado
 * com a constante ".backup"
 */
public class FileToTransfer implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7147804475243955070L;
	
	private String filename;
    
    
    public FileToTransfer( String filename ) throws IOException {
        this.filename = filename ;
        if( ! new File( filename).exists())
        	throw new FileNotFoundException( filename);
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
    	oos.writeUTF( filename ) ; //serializa o nome do ficheiro
    	oos.writeLong( new File( filename).length() ) ; //serializa o tamanho do ficheiro
    	
    	//copia o conteúdo do ficheiro do disco para o canal de saída
    	int n;
    	byte[] buffer = new byte[1024] ;
    	FileInputStream fis = new FileInputStream(filename);        

    	while( (n = fis.read( buffer)) > 0 ){
    		oos.write( buffer, 0, n ) ;
    	}
        fis.close();
    }    
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    	filename = ois.readUTF() ; // des-serializa o nome do ficheiro
    	long remaining = ois.readLong() ; // des-serializa o tamanho do ficheiro
    
    	// copia o conteúdo do ficheiro do canal de entrada para o disco
    	byte[] buffer = new byte[1024] ;
    	FileOutputStream fos = new FileOutputStream(filename + ".backup");        

    	while( remaining > 0 ) {
    		int n = ois.read( buffer, 0, (int) Math.min( buffer.length, remaining )) ;
    		fos.write( buffer, 0, n ) ;
    		remaining -= n ;
    	}
    	fos.close() ;
    }

    /**
     * Imprime ficheiro
     */
    public void printFile( PrintStream os) throws IOException {
    	os.println( "---------------------------------------------------------");
    	os.println( "Ficheiro : " + filename);
    	os.println( "---------------------------------------------------------");
    	
    	int n;
    	byte[] buffer = new byte[1024] ;
    	FileInputStream fis = new FileInputStream(filename);        

    	while( (n = fis.read( buffer)) > 0 ){
    		os.write( buffer, 0, n ) ;
    	}
        fis.close();
    	os.println( "---------------------------------------------------------");
    	os.println();
    }    
    
}
