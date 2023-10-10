package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPorHoras extends Empleado {
    private double sueldo;

    // constructor
    public EmpleadoPorHoras(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, double sueldo) {
        super(nombre, apellido, fecNac, nss, categoria, departamento);
        establecerSueldo(sueldo);
    }

    public EmpleadoPorHoras(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, double sueldo, LocalDate fecAlta) {
        super(nombre, apellido, fecNac, nss, categoria, departamento, fecAlta);
        establecerSueldo(sueldo);
    }

    // establece el sueldo
    public void establecerSueldo(double sueldo) {
        if (sueldo >= 0.0) {
            this.sueldo = sueldo;
        } else {
            throw new IllegalArgumentException("El sueldo debe ser >= 0.0");
        }
    }

    // devuelve el sueldo
    public double obtenerSueldo() {
        return sueldo;
    }


    // calcula los ingresos
    @Override
    public double ingresos() {
        if (horasTrabajadas <= 40) {
            return (obtenerHorasTrabajadas() * obtenerSueldo()) * ingresosComplementos();
        }
        return (40 * obtenerSueldo() + (obtenerHorasTrabajadas() - 40) * obtenerSueldo() * 1.5) * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Sueldo por hora: " + obtenerSueldo();
    }
}