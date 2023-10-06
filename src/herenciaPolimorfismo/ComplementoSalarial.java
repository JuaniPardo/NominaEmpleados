package herenciaPolimorfismo;

public abstract class ComplementoSalarial {
    protected String nombre;
    protected String descripcion;

    public ComplementoSalarial(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract double obtenerMonto();


    @Override
    public String toString(){
        return "Nombre: " + nombre;

    }
}