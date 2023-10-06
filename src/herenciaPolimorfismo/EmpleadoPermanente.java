package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPermanente extends EmpleadoPorPiezas {

    private double sueldoBase;

    // constructor
    public EmpleadoPermanente(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, int piezas, double pagoPorPieza, double sueldoBase) {
        super(nombre, apellido, fecNac, nss, categoria, piezas, pagoPorPieza);
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

    @Override
    public double ingresos(){
        return super.ingresos() + obtenerSueldoBase();
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Sueldo base: " + obtenerSueldoBase();
    }
}
