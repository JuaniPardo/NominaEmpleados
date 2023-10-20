package interfazPolimorfismo;

public class Categoria {

    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String toString(){
        return "Categoría: " + nombre;
    }
}
