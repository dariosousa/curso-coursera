package co.com.s4n.entregaralmuerzo;

import java.io.File;

import co.com.s4n.entregaralmuerzo.file.ArchivoEntrada;

public class EntregaSimultanea {

	public int entregarSimultaneamente(String dirEntrada,String dirSalida,int maximo){
		EntregaDomicilio entregaDomicilio = null;

		String directorio = dirEntrada;
		if(directorio == null || "".equals(directorio))
			directorio = "IN";

		ArchivoEntrada entrada = new ArchivoEntrada();
		File[] archivos = entrada.getArchivos(directorio);

		for(int i=0;i<archivos.length;i++){
			Thread t = new Thread(entregaDomicilio,"EntregaDomicilio"+archivos[i].getName().substring(2, 4));
			t.start();
		}

		return 0;
	}

	public static void main(String[] args) {
		EntregaSimultanea simultanea = new EntregaSimultanea();
		System.out.println(simultanea.entregarSimultaneamente(args[0], args[1],Integer.valueOf(args[2])));
	}

}
