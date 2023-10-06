package herenciaPolimorfismo;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestNomina {
    public static void main(String[] args) {
        double montoTotal = 0;
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", "Perez", LocalDate.of(1985,5,15), "111-11-1111", 800.00, LocalDate.of(2010, 1, 1));
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Jorge", "Gonzalez", LocalDate.of(1990,3,20), "222-22-2222", 16, 40);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Ana", "Lopez", LocalDate.of(1995,7,30), "333-33-3333", 10000, .06);
        EmpleadoBaseComision empleadoBaseComision = new EmpleadoBaseComision("Luis", "Garcia", LocalDate.of(2000,2,2), "444-44-4444", 5000, .04, 300);
        EmpleadoPorPiezas empleadoPorPiezas = new EmpleadoPorPiezas("Maria", "Martinez", LocalDate.of(1985,1,10), "555-55-5555", 100, 2.5, LocalDate.of(2015, 1, 1));

        System.out.println("Empleados procesados por separado:\n");

        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoAsalariado, "Ingresos", empleadoAsalariado.ingresos());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPorHoras, "Ingresos", empleadoPorHoras.ingresos());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPorComision, "Ingresos", empleadoPorComision.ingresos());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoBaseComision, "Ingresos", empleadoBaseComision.ingresos());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPorPiezas, "Ingresos", empleadoPorPiezas.ingresos());

        empleadoPorPiezas.agregarComplemento(new ComplementoNocturnidad());
        empleadoPorHoras.agregarComplemento(new ComplementoProductividad());
        empleadoBaseComision.agregarComplemento(new ComplementoInsalubridad());

        // crea un arrayList Empleado
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        // inicializa el arreglo con objetos Empleado
        empleados.add(empleadoAsalariado);
        empleados.add(empleadoPorHoras);
        empleados.add(empleadoPorComision);
        empleados.add(empleadoBaseComision);
        empleados.add(empleadoPorPiezas);

        System.out.println("------------------------------------------");
        System.out.println("Empleados procesados en forma polimórfica:");
        System.out.println("------------------------------------------");

        // procesa en forma genérica a cada elemento en el array empleados
        for (Empleado empleadoActual : empleados) {
            System.out.println(empleadoActual); // invoca a toString
            System.out.println("Ingreso: $" + empleadoActual.ingresos());
            System.out.println("------------------------------------------");
            montoTotal += empleadoActual.ingresos();

        }
        System.out.printf("El monto total de la nomina es: $%,.2f\n", montoTotal);
        System.out.println("------------------------------------------");

    }
}