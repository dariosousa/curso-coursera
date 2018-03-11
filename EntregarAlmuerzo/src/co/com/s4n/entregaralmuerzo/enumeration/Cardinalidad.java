package co.com.s4n.entregaralmuerzo.enumeration;

public enum Cardinalidad {
	N("Norte"),
	S("Sur"),
	E("Oriente"),
	O("Occidente");

	private final String nombre;

	private Cardinalidad(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
