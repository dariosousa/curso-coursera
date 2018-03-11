package co.com.s4n.entregaralmuerzo.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoSalida {

	private File archivo = null;
	private BufferedWriter bufferEscritura = null;


	public ArchivoSalida(String destino) throws IOException {
		this.archivo = new File(destino);
		bufferEscritura= new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(), false));
	}


	public void escribir(String respuesta) throws IOException {
		this.bufferEscritura.write(respuesta);
	}


	public void commit() throws IOException {
		this.bufferEscritura.flush();

	}

	public void close() throws IOException {
		this.bufferEscritura.close();
	}




}
