package herenciaPolimorfismo;

public class Departamento {

        private String nombre;
        private String descripcion;

        public Departamento(String nombre, String descripcion){
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public String obtenerNombre() {
            return nombre;
        }

        @Override
        public String toString(){
            return "Departamento: " + nombre;
        }
}
