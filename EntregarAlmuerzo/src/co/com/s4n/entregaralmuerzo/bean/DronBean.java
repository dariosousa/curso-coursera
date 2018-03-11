package co.com.s4n.entregaralmuerzo.bean;

public class DronBean {

	private int x;

	private int y;

	private String direccion;

	public DronBean(){
		this.x=0;
		this.y=0;
		this.direccion="N";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
