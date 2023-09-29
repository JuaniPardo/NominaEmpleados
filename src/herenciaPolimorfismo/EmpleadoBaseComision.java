package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoBaseComision extends EmpleadoPorComision{

    private double salarioBase;

    // constructor
    public EmpleadoBaseComision(String nombre, String apellido, LocalDate fecNac, String nss, double ventas, double tarifa, double salario) {
        super(nombre, apellido, fecNac, nss, ventas, tarifa);
        establecerSalarioBase(salario);
    }

    // establece el salario base
public void establecerSalarioBase(double salario) {
        if (salario >= 0.0) {
            salarioBase = salario;
        } else {
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        }
    }

    // devuelve el salario base
    public double obtenerSalarioBase() {
        return salarioBase;
    }

    // calcula los ingresos
    @Override
    public double ingresos() {
        return obtenerSalarioBase() + (obtenerVentasBrutas() * obtenerTarifaComision());
    }

    // devuelve representación String de un objeto EmpleadoBaseComision
    @Override
    public String toString() {
        return super.toString() + "\n" +
        "Salario base: " + obtenerSalarioBase();
    }
}