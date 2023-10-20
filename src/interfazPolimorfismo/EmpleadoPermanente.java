package interfazPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPermanente extends EmpleadoPorPiezas {

    private double sueldoBase;

    // constructor
    public EmpleadoPermanente(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, int piezas, double pagoPorPieza, double sueldoBase) {
        super(nombre, apellido, fecNac, nss, categoria, departamento, "Permanente", piezas, pagoPorPieza);
        establecerSueldoBase(sueldoBase);
    }

    public EmpleadoPermanente(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, int piezas, double pagoPorPieza, double sueldoBase, LocalDate fecAlta) {
        super(nombre, apellido, fecNac, nss, categoria, departamento, "Permanente", piezas, pagoPorPieza, fecAlta);
        establecerSueldoBase(sueldoBase);
    }

    private void establecerSueldoBase(double sueldoBase) {
        if(sueldoBase >= 0.0){
            this.sueldoBase = sueldoBase;
        }else{
            throw new IllegalArgumentException("El sueldo base debe ser >= 0");
        }
    }

    public double obtenerSueldoBase(){
        return sueldoBase;
    }

    //sobreescribo calcularSueldo() para que calcule el sueldo base
    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + obtenerSueldoBase();
    }
    //al calcular el sueldo de esta manera, no necesito sobreescribir ingresos()

    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Sueldo base: " + obtenerSueldoBase();
    }
}
