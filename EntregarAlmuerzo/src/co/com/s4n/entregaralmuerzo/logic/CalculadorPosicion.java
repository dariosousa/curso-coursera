package co.com.s4n.entregaralmuerzo.logic;

import co.com.s4n.entregaralmuerzo.bean.DronBean;
import co.com.s4n.entregaralmuerzo.enumeration.Cardinalidad;
import co.com.s4n.entregaralmuerzo.enumeration.Direccion;
import co.com.s4n.entregaralmuerzo.enumeration.Orden;

public class CalculadorPosicion {

	private DronBean dron;

	public CalculadorPosicion(DronBean d){
		this.dron=d;
	}

	public DronBean getDron() {
		return dron;
	}

	public void setDron(DronBean dron) {
		this.dron = dron;
	}

	public String calcularPosicion(String linea) throws Exception {
		String resultado = null;

		for(int i=0;i<linea.length();i++){
			try{
				Orden letra = Orden.valueOf(String.valueOf(linea.charAt(i)));
				Direccion.valueOf(this.dron.getDireccion()+letra.name()).calcular(this.getDron());
			}
			catch(Exception e){
				return resultado = "(" + this.dron.getX() + "," + this.dron.getY() + ") dirección " + Cardinalidad.valueOf(this.dron.getDireccion()).getNombre() +". Valor " +String.valueOf(linea.charAt(i))+" no válido" ;
			}

		}

		resultado = "(" + this.dron.getX() + "," + this.dron.getY() + ") dirección " + Cardinalidad.valueOf(this.dron.getDireccion()).getNombre();

		return resultado;
	}

}
