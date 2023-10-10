package herenciaPolimorfismo.complementosSalariales;

public abstract class ComplementoSalarial {
    protected final String nombre;
    protected final String descripcion;

    public ComplementoSalarial(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract double obtenerMonto();


    public String toString(){
        return "Nombre: " + nombre;

    }
}