package herenciaPolimorfismo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {

    protected String primerNombre;
    protected String apellidoPaterno;
    protected String NSS; // número de seguro social no usado para calculos
    protected LocalDate fecNac;

    // constructor
    public Empleado(String nombre, String apellido, LocalDate fecNac,String nss) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        NSS = nss;
        establecerFecNac(fecNac);
    }

    //establecer mayoria de edad
    public boolean esMayorDeEdad(LocalDate fecNac){
        //verificar que sea mayor de 18 ańos
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fecNac, hoy);
        return edad.getYears() >= 18;
    }

    //obtener la edad
    public String obtenerEdad(){
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fecNac, hoy);
        return edad.getYears() + " años, ";
    }

    //establecer la fecha de nacimiento
    public void establecerFecNac(LocalDate fecNac){
        if (esMayorDeEdad(fecNac)) {
            this.fecNac = fecNac;
        } else {
            throw new IllegalArgumentException("El empleado debe ser mayor de edad");
        }
    }

    //devuelve la fecha de nacimiento
    public LocalDate obtenerFecNac(){
        return fecNac;
    }

    // establece el primer nombre
    public void establecerPrimerNombre(String nombre) {
        primerNombre = nombre;
    }

    // devuelve el primer nombre
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    // establece el apellido
    public void establecerApellidoPaterno(String apellido) {
        apellidoPaterno = apellido;
    }

    // devuelve el apellido
    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    //establece los ingresos
    public abstract double ingresos();


    // devuelve representación String de un objeto Empleado
    public String toString() {
        return primerNombre + " " + apellidoPaterno + "\n" +
                "Edad: " + obtenerEdad() + "\n" +
                "Fecha de nacimiento: " + fecNac + "\n" +
                "Número de seguro social: " + NSS;
    }
}