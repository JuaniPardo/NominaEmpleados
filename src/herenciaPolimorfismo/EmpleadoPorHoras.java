package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPorHoras extends Empleado {
    private int horas;
    private double sueldo;

    // constructor sin fecha de alta
    public EmpleadoPorHoras(String nombre, String apellido, LocalDate fecNac, String nss, int horas, double sueldo) {
        super(nombre, apellido, fecNac, nss);
        establecerHoras(horas);
        establecerSueldo(sueldo);
    }

    // constructor con fecha de alta
    public EmpleadoPorHoras(String nombre, String apellido, LocalDate fecNac, String nss, int horas, double sueldo, LocalDate fecAlta) {
        super(nombre, apellido, fecNac, nss, fecAlta);
        establecerHoras(horas);
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

    // establece las horas trabajadas
    public void establecerHoras(int horas) {
        if (horas >= 0 && horas <= 168) {
            this.horas = horas;
        } else {
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0 y <= 168");
        }
    }

    // devuelve las horas trabajadas
    public int obtenerHoras() {
        return horas;
    }

    // calcula los ingresos
    @Override
    public double ingresos() {
        if (horas <= 40) {
            return (obtenerHoras() * obtenerSueldo()) * ingresosComplementos();
        }
        return (40 * obtenerSueldo() + (obtenerHoras() - 40) * obtenerSueldo() * 1.5) * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString() {
        return "Empleado por horas: \n" +
                super.toString() + "\n" +
                "Horas trabajadas: " + obtenerHoras() + "\n" +
                "Sueldo por hora: " + obtenerSueldo();
    }
}