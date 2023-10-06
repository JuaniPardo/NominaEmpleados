package herenciaPolimorfismo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Empleado {

    protected String primerNombre;
    protected String apellidoPaterno;
    protected String NSS; // número de seguro social no usado para calculos
    protected LocalDate fecNac;
    protected LocalDate fecAlta;

    protected ArrayList<ComplementoSalarial> complementos;

    // constructor sin fecha de alta
    public Empleado(String nombre, String apellido, LocalDate fecNac,String nss) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        NSS = nss;
        establecerFecNac(fecNac);
        establecerFecAlta(LocalDate.now());
        this.complementos = new ArrayList<>();
        agregarComplemento(new ComplementoAntiguedad(fecAlta));
    }

    // constructor con fecha de alta
    public Empleado(String nombre, String apellido, LocalDate fecNac,String nss, LocalDate fecAlta) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        NSS = nss;
        establecerFecNac(fecNac);
        establecerFecAlta(fecAlta);
        this.complementos = new ArrayList<>();
        agregarComplemento(new ComplementoAntiguedad(fecAlta));
    }

    public void agregarComplemento(ComplementoSalarial complemento){
        complementos.add(complemento);
    }

    public void eliminarComplemento(ComplementoSalarial complemento){
        complementos.remove(complemento);
    }

    //establecer fecha de alta
    public void establecerFecAlta(LocalDate fecAlta){
        this.fecAlta = fecAlta;
    }

    //obtener fecha de alta
    public LocalDate obtenerFecAlta(){
        return fecAlta;
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

    public double ingresosComplementos(){
        double comps = 0;
        for (ComplementoSalarial complemento : complementos) {
            comps += complemento.obtenerMonto();
        }
        return comps + 1; //se calcula sobre el 100% del salario (+1)
    }

    public String imprimirComplementos(){
        String comps = "Complementos Salariales:";
        for (ComplementoSalarial complemento : complementos) {
            comps += "\n\t" + complemento.toString();
        }
        return comps;
    }

    @Override
    public String toString() {
        return primerNombre + " " + apellidoPaterno + "\n" +
                "Edad: " + obtenerEdad() + "\n" +
                "Fecha de nacimiento: " + fecNac + "\n" +
                "Número de seguro social: " + NSS + "\n" +
                "Fecha de alta: " + fecAlta + "\n" +
                imprimirComplementos()
                ;
    }
}
