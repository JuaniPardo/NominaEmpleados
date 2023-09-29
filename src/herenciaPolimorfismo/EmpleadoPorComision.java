package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPorComision extends Empleado{

    protected double ventasBrutas;
    protected double tarifaComision;

    // constructor
    public EmpleadoPorComision(String nombre, String apellido, LocalDate fecNac, String nss, double ventas, double tarifa) {
        super(nombre, apellido, fecNac, nss);
        establecerVentasBrutas(ventas);
        establecerTarifaComision(tarifa);
    }

    // establece la tarifa de comisión
    public  double establecerTarifaComision(double tarifa) {
        if (tarifa > 0.0 && tarifa < 1.0) {
            tarifaComision = tarifa;
        } else {
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        }
        return tarifaComision;
    }

    // devuelve la tarifa de comisión
    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    // establece las ventas brutas
    public void establecerVentasBrutas(double ventas) {
        if (ventas >= 0.0) {
            ventasBrutas = ventas;
        } else {
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        }
    }

    // devuelve las ventas brutas
    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    // calcula los ingresos
    @Override
    public double ingresos() {
        return obtenerVentasBrutas() * obtenerTarifaComision();
    }

    // devuelve representación String de un objeto EmpleadoPorComision
    @Override
    public String toString() {
        return "Empleado por comisión: \n" +
                super.toString() + "\n" +
                "Ventas brutas: " + obtenerVentasBrutas() + "\n" +
                "Tarifa de comisión: " + obtenerTarifaComision();
    }
}