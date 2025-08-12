package ve.edu.unet.nodosAST;

public class NodoFuncion extends NodoBase {
    private String nombre;
    private NodoBase parametros;
    private NodoBase cuerpo;

    public NodoFuncion(String nombre, NodoBase parametros, NodoBase cuerpo) {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
        this.cuerpo = cuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoBase getParametros() {
        return parametros;
    }

    public void setParametros(NodoBase parametros) {
        this.parametros = parametros;
    }

    public NodoBase getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(NodoBase cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public String toString() {
        return "NodoFuncion: " + nombre;
    }
}