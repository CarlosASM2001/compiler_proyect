package ve.edu.unet;

import ve.edu.unet.nodosAST.*;

import java.util.*;



public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	private String ambitoActual; // Current scope: "global" or function name
	private HashMap<String, Integer> direccionesPorAmbito; // Memory addresses per scope
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
		ambitoActual = "global";
		direccionesPorAmbito = new HashMap<String, Integer>();
		direccionesPorAmbito.put("global", 0);
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
			if (raiz instanceof NodoDeclaracion){
				InsertarSimbolo(((NodoDeclaracion)raiz).getIdentificador(), ((NodoDeclaracion) raiz).getLongitud(), ((NodoDeclaracion) raiz).getTipoVariable());
			} else if (raiz instanceof NodoFuncion) {
				NodoFuncion funcion = (NodoFuncion) raiz;
				// Enter function scope
				String nombreFuncion = funcion.getNombre();
				entrarAmbito(nombreFuncion);
				
				// Process function parameters
				NodoBase parametros = funcion.getParametros();
				while (parametros != null) {
					if (parametros instanceof NodoDeclaracion) {
						InsertarSimbolo(((NodoDeclaracion)parametros).getIdentificador(), 
								((NodoDeclaracion) parametros).getLongitud(), 
								((NodoDeclaracion) parametros).getTipoVariable());
					}
					parametros = parametros.getHermanoDerecha();
				}
				
				// Process function body declarations
				cargarTabla(funcion.getCuerpo());
				
				// Exit function scope
				salirAmbito();
			}
	    	raiz = raiz.getHermanoDerecha();
	  }
	}
	
	public void entrarAmbito(String nombreAmbito) {
		ambitoActual = nombreAmbito;
		if (!direccionesPorAmbito.containsKey(nombreAmbito)) {
			direccionesPorAmbito.put(nombreAmbito, 0);
		}
	}
	
	public void salirAmbito() {
		ambitoActual = "global";
	}
	
	public String getAmbitoActual() {
		return ambitoActual;
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador, int longitud, tipoVar tipoVariable) {
		String claveCompleta = ambitoActual + ":" + identificador;
		RegistroSimbolo simbolo;
		if(tabla.containsKey(claveCompleta)){
			return false;
		}else{
			int direccionActual = direccionesPorAmbito.get(ambitoActual);
			simbolo= new RegistroSimbolo(identificador, longitud, direccionActual, tipoVariable, ambitoActual);
			direccionesPorAmbito.put(ambitoActual, direccionActual + longitud);
			tabla.put(claveCompleta, simbolo);
			return true;			
		}
	}
	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		// First look in current scope
		String claveActual = ambitoActual + ":" + identificador;
		RegistroSimbolo simbolo = (RegistroSimbolo)tabla.get(claveActual);
		
		// If not found and not in global scope, look in global scope
		if (simbolo == null && !ambitoActual.equals("global")) {
			String claveGlobal = "global:" + identificador;
			simbolo = (RegistroSimbolo)tabla.get(claveGlobal);
		}
		
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
            RegistroSimbolo reg = tabla.get(s);
	    System.out.println("Consegui Key: "+s+" con direccion: " + reg.getDireccionMemoria() + " en ambito: " + reg.getAmbito());
		}
	}

	public int getDireccion(String Clave){
		RegistroSimbolo simbolo = BuscarSimbolo(Clave);
		return simbolo != null ? simbolo.getDireccionMemoria() : -1;
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}
