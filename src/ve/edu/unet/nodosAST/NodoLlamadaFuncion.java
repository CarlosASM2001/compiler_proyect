package ve.edu.unet.nodosAST;

public class NodoLlamadaFuncion extends NodoBase {
    private String nombre;
    private NodoBase argumentos;

    public NodoLlamadaFuncion(String nombre, NodoBase argumentos) {
        super();
        this.nombre = nombre;
        this.argumentos = argumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoBase getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(NodoBase argumentos) {
        this.argumentos = argumentos;
    }

    @Override
    public String toString() {
        return "NodoLlamadaFuncion: " + nombre;
    }
}