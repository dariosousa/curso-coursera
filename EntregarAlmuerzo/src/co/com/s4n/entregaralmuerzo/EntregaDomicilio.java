package co.com.s4n.entregaralmuerzo;

import co.com.s4n.entregaralmuerzo.bean.DronBean;
import co.com.s4n.entregaralmuerzo.calculator.CalculadorPosicion;
import co.com.s4n.entregaralmuerzo.file.ArchivoEntrada;
import co.com.s4n.entregaralmuerzo.file.ArchivoSalida;

public class EntregaDomicilio implements Runnable {

	private CalculadorPosicion calculador;
	private String origen;
	private String destino;
	private int maxAlmuerzo;

	public EntregaDomicilio(){
		DronBean d = new DronBean();
		this.calculador = new CalculadorPosicion(d);
	}

	public EntregaDomicilio(String origen, String destino, int max) {
		this();
		this.origen = origen;
		this.destino = destino;
		this.maxAlmuerzo = max;
	}

	public int entregarDomicilio(String rutaOrigen, String rutaDestino, int maximoAlmuerzo){
		String origen = rutaOrigen;
		String destino = rutaDestino;
		try{
			if(origen == null || "".equals(origen))
				origen="IN/in.txt";

			if(destino == null || "".equals(destino))
				destino = "OUT/out.txt";

			ArchivoEntrada archivoEntrada = new ArchivoEntrada(origen);
			ArchivoSalida archivoSalida = new ArchivoSalida(destino);
			archivoSalida.escribir("== Reporte de entregas ==\n");
			String registro;
			int cantAlmuerzo = 0;
			while ((registro =  archivoEntrada.getLectorBuffer().readLine()) != null && cantAlmuerzo<maximoAlmuerzo) {
				String respuesta = this.calculador.calcularPosicion(registro);
				archivoSalida.escribir(respuesta+"\n");
				cantAlmuerzo++;
			}
			archivoSalida.commit();
			archivoSalida.close();
			archivoEntrada.cerrarBuffer();
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			return 1;
		}
	}

	public static void main(String[] args) throws Exception {

		EntregaDomicilio entregaDomicilio = new EntregaDomicilio();
		System.out.println(entregaDomicilio.entregarDomicilio(args[0], args[1],Integer.valueOf(args[2])));
	}

	@Override
	public void run() {
		this.entregarDomicilio();

	}

	private int entregarDomicilio() {
		this.entregarDomicilio(this.origen, this.destino, this.maxAlmuerzo);
		return 0;
	}

}
