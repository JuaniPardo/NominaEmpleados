package interfazPolimorfismo;

import java.time.LocalDate;

public class EmpleadoContratado extends EmpleadoPorPiezas {

        // constructor
        public EmpleadoContratado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, int piezas, double pagoPorPieza) {
            super(nombre, apellido, fecNac, nss, categoria, departamento, "Contratado", piezas, pagoPorPieza);
        }

        public EmpleadoContratado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, int piezas, double pagoPorPieza, LocalDate fecAlta) {
            super(nombre, apellido, fecNac, nss, categoria, departamento, "Contratado", piezas, pagoPorPieza, fecAlta);
        }


        //Como la clase no agrega nada nuevo, no es necesario sobreescribir el metodo toString()

}
