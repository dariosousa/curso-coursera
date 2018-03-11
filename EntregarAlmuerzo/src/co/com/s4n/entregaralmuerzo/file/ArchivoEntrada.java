package co.com.s4n.entregaralmuerzo.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoEntrada {

	private FileReader lectorArchivo = null;
	private BufferedReader lectorBuffer = null;

	public ArchivoEntrada(String archivo) throws FileNotFoundException{

		lectorArchivo = new FileReader(archivo);
		lectorBuffer = new BufferedReader(lectorArchivo);

	}

	public BufferedReader getLectorBuffer() {
		return lectorBuffer;
	}

	public void cerrarBuffer() throws IOException {
		lectorBuffer.close();		
	}

}
