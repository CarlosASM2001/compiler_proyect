package ve.edu.unet;

import ve.edu.unet.nodosAST.tipoVar;

public class RegistroSimbolo {
	private String identificador;
	private int longitud;
	private int DireccionMemoria;
	private tipoVar tipoVariable;
	private String ambito; // "global" or function name
	
	public RegistroSimbolo(String identificador, int longitud,
			int direccionMemoria, tipoVar tipoVariable) {
		super();
		this.identificador = identificador;
		this.longitud = longitud;
		DireccionMemoria = direccionMemoria;
		this.tipoVariable = tipoVariable;
		this.ambito = "global"; // default scope
	}

	public RegistroSimbolo(String identificador, int longitud,
			int direccionMemoria, tipoVar tipoVariable, String ambito) {
		super();
		this.identificador = identificador;
		this.longitud = longitud;
		DireccionMemoria = direccionMemoria;
		this.tipoVariable = tipoVariable;
		this.ambito = ambito;
	}

	public String getIdentificador() {
		return identificador;
	}

	public int getLongitud() {
		return longitud;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}

	public tipoVar getTipoVariable() {
		return tipoVariable;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}
}
