package interfazPolimorfismo;

import java.time.LocalDate;

public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    // constructor
    public EmpleadoAsalariado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, double salario) {
        super(nombre, apellido, fecNac, nss, categoria, departamento);
        establecerSalarioSemanal(salario);
    }

    public EmpleadoAsalariado(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, double salario, LocalDate fecAlta) {
        super(nombre, apellido, fecNac, nss, categoria, departamento, fecAlta);
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
    public double obtenerMontoPago() {
        return obtenerSalarioSemanal() * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Salario semanal: " + obtenerSalarioSemanal();
    }

}