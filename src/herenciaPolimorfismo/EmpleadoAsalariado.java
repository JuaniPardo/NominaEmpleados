package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    // constructor
    public EmpleadoAsalariado(String nombre, String apellido, LocalDate fecNac, String nss, double salario, LocalDate localDate) {
        super(nombre, apellido, fecNac, nss);
        establecerSalarioSemanal(salario);
    }

    // establece el salario
    public void establecerSalarioSemanal(double salario) {
        if (salario >= 0.0) {
            salarioSemanal = salario;
        } else {
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");
        }
    }

    // devuelve el salario
    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }

    // calcula los ingresos
    @Override
    public double ingresos() {
        return obtenerSalarioSemanal() * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString() {
        return "Empleado asalariado: \n" +
                super.toString() + "\n" +
                "Salario semanal: " + obtenerSalarioSemanal();
    }

}