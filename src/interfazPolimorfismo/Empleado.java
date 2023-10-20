package interfazPolimorfismo;

import interfazPolimorfismo.complementosSalariales.ComplementoAntiguedad;
import interfazPolimorfismo.complementosSalariales.ComplementoSalarial;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Empleado implements PorPagar {

    protected String primerNombre;
    protected String apellidoPaterno;
    protected String NSS; // número de seguro social no usado para calculos
    protected LocalDate fecNac;
    protected LocalDate fecAlta;
    protected Categoria categoria;  //asociacion
    protected Departamento departamento;    //asociacion
    protected int horasTrabajadas;

    protected ArrayList<ComplementoSalarial> complementos;  //composicion

    // constructor
    public Empleado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        NSS = nss;
        establecerFecAlta(LocalDate.now()); //si no recibe el parametro de fecAlta, se establece la fecha actual
        establecerFecNac(fecNac);
        establecerHorasTrabajadas(0);//por defecto al crear un empleado no tiene horas trabajadas
        establecerCategoria(categoria);
        establecerDepartamento(departamento);
        this.complementos = new ArrayList<>();
        agregarComplemento(new ComplementoAntiguedad(fecAlta));
    }

    public Empleado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, LocalDate fecAlta) {
        primerNombre = nombre;
        apellidoPaterno = apellido;
        NSS = nss;
        establecerFecAlta(fecAlta); //establece la fecha de alta
        establecerFecNac(fecNac);
        establecerHorasTrabajadas(0);//por defecto al crear un empleado no tiene horas trabajadas
        establecerCategoria(categoria);
        establecerDepartamento(departamento);
        this.complementos = new ArrayList<>();
        agregarComplemento(new ComplementoAntiguedad(fecAlta));
    }

    public void establecerHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas >= 0 && horasTrabajadas <= 168) {
            this.horasTrabajadas = horasTrabajadas;
        } else {
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0 y <= 168");
            //jornada de 8 horas diarias
            //no voy a contemplar horas extras para este ejercicio
        }
    }

    public int obtenerHorasTrabajadas() {
        return horasTrabajadas;
    }

    private void establecerCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String obtenerCategoria() {
        return categoria.obtenerNombre();
    }

    public void establecerDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String obtenerDepartamento() {
        return departamento.obtenerNombre();
    }

    //agrego complementos

    public void agregarComplemento(ComplementoSalarial complemento) {
        complementos.add(complemento);
    }
    //elimino complementos

    public void eliminarComplemento(ComplementoSalarial complemento) {
        complementos.remove(complemento);
    }
    //establecer fecha de alta

    public void establecerFecAlta(LocalDate fecAlta) {
        this.fecAlta = fecAlta;
    }
    //obtener fecha de alta

    public LocalDate obtenerFecAlta() {
        return fecAlta;
    }

    //establecer mayoria de edad

    public boolean esMayorDeEdad(LocalDate fecNac) {
        //verificar que sea mayor de 18 ańos
        LocalDate hoy = obtenerFecAlta();
        Period edad = Period.between(fecNac, hoy);
        return edad.getYears() >= 18;
    }
    //obtener la edad

    public String obtenerEdad() {
        LocalDate fechaIngreso = LocalDate.now();
        Period edad = Period.between(fecNac, fechaIngreso);
        return edad.getYears() + " años, ";
    }
    //establecer la fecha de nacimiento

    public void establecerFecNac(LocalDate fecNac) {
        if (esMayorDeEdad(fecNac)) {
            this.fecNac = fecNac;
        } else {
            throw new IllegalArgumentException("El empleado debe ser mayor de edad a la fecha de contratación");
        }
    }
    //devuelve la fecha de nacimiento

    public LocalDate obtenerFecNac() {
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

    public double ingresosComplementos() {
        double comps = 0;
        for (ComplementoSalarial complemento : complementos) {
            comps += complemento.obtenerMonto();
        }
        return comps + 1; //los complementos se suman al 100% del sueldo
    }

    public static double calcularSueldoPromedio(ArrayList<PorPagar> porPagar) {
        double sueldoPromedio = 0;
        for (PorPagar empleado : porPagar) {
            if (empleado instanceof Empleado) {
                sueldoPromedio += ((Empleado) empleado).obtenerMontoPago();
            }
        }
        return sueldoPromedio / porPagar.size();
    }

    public static double calcularHorasPromedio(ArrayList<PorPagar> empleados) {
        double horasPromedio = 0;
        for (PorPagar empleado : empleados) {
            if (empleado instanceof Empleado) {
                horasPromedio += ((Empleado) empleado).obtenerHorasTrabajadas();
            }
        }
        return horasPromedio / empleados.size();
    }

    public String obtenerNombreCompleto() {
        return primerNombre + " " + apellidoPaterno;
    }


    //justo este fin de semana estuve leyendo sobre la inmutabilidad de los Strings y el String Pool
    public String imprimirComplementos() {
        StringBuilder complementos = new StringBuilder("Complementos Salariales:");
        for (ComplementoSalarial complemento : this.complementos) {
            complementos.append("\n\t").append(complemento.toString());
        }
        return complementos.toString();
    }

    // devuelve representación String de un objeto Empleado
    @Override
    public String toString() {
        return "Categoria: " + categoria.obtenerNombre() + "\n" +
                "Departamento: " + departamento.obtenerNombre() + "\n" +
                obtenerNombreCompleto() + "\n" +
                "Edad: " + obtenerEdad() + "\n" +
                "Fecha de nacimiento: " + fecNac + "\n" +
                "Número de seguro social: " + NSS + "\n" +
                "Fecha de alta: " + fecAlta + "\n" +
                "Horas trabajadas: " + horasTrabajadas + " hs\n" +
                imprimirComplementos()
                ;
    }
}