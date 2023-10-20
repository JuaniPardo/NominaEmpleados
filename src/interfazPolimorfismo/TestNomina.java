package interfazPolimorfismo;

import interfazPolimorfismo.complementosSalariales.ComplementoInsalubridad;
import interfazPolimorfismo.complementosSalariales.ComplementoNocturnidad;
import interfazPolimorfismo.complementosSalariales.ComplementoProductividad;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestNomina {
    public static void main(String[] args) {
        double montoTotal = 0;

        //array de Departamentos
        Departamento[] departamentos = new Departamento[3];
        departamentos[0] = new Departamento("Ventas", "Departamento de Ventas");
        departamentos[1] = new Departamento("Marketing", "Departamento de Marketing");
        departamentos[2] = new Departamento("Produccion", "Departamento de Produccion");

        //array de Categorias
        Categoria[] categorias = new Categoria[6];
        categorias[0] = new Categoria("Empleado Asalariado", "Empleado que recibe un salario fijo semanal");
        categorias[1] = new Categoria("Empleado por Horas", "Empleado que recibe un pago por hora trabajada");
        categorias[2] = new Categoria("Empleado por Comision", "Empleado que recibe un porcentaje de las ventas");
        categorias[3] = new Categoria("Empleado Base Comision", "Empleado que recibe un porcentaje de las ventas y un salario base");
        categorias[4] = new Categoria("Empleado Contratado", "Empleado que recibe un pago por cada pieza producida");
        categorias[5] = new Categoria("Empleado Permanente", "Empleado que recibe un pago por cada pieza producida y un salario base");

        // crea objetos Empleado
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", "Perez", LocalDate.of(1985, 5, 15), "111-11-1111", categorias[0], departamentos[1],800.00, LocalDate.of(2008, 1, 1));
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Jorge", "Gonzalez", LocalDate.of(1990, 3, 20), "222-22-2222", categorias[1], departamentos[1], 8, LocalDate.of(2010, 5, 5));
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Ana", "Lopez", LocalDate.of(1995, 7, 30), "333-33-3333", categorias[2], departamentos[0], 10000, .06, LocalDate.of(2017, 10, 10));
        EmpleadoBaseComision empleadoBaseComision = new EmpleadoBaseComision("Luis", "Garcia", LocalDate.of(2000, 2, 2), "444-44-4444", categorias[3], departamentos[0], 5000, .04, 300, LocalDate.of(2019, 3, 3));
        EmpleadoPorPiezas empleadoContratado = new EmpleadoContratado("Maria", "Martinez", LocalDate.of(2005, 1, 10), "555-55-5555", categorias[4], departamentos[2], 100, 2.5, LocalDate.of(2023, 4, 4));
        EmpleadoPermanente empleadoPermanente = new EmpleadoPermanente("Pedro", "Sanchez", LocalDate.of(2003, 12, 20), "666-66-6666", categorias[5], departamentos[2], 100, 2.5, 1000, LocalDate.of(2022, 6, 6));

        // imprime los objetos Empleado
        System.out.println("Empleados procesados por separado:\n");
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoAsalariado, "Ingresos", empleadoAsalariado.obtenerMontoPago());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPorHoras, "Ingresos", empleadoPorHoras.obtenerMontoPago());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPorComision, "Ingresos", empleadoPorComision.obtenerMontoPago());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoBaseComision, "Ingresos", empleadoBaseComision.obtenerMontoPago());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoContratado, "Ingresos", empleadoContratado.obtenerMontoPago());
        System.out.printf("%s\n%s: $%,.2f\n\n", empleadoPermanente, "Ingresos", empleadoPermanente.obtenerMontoPago());

        //establezco horas trabajadas en el mes
        empleadoAsalariado.establecerHorasTrabajadas(160);
        empleadoPorHoras.establecerHorasTrabajadas(150);
        empleadoPorComision.establecerHorasTrabajadas(140);
        empleadoBaseComision.establecerHorasTrabajadas(130);
        empleadoContratado.establecerHorasTrabajadas(120);
        empleadoPermanente.establecerHorasTrabajadas(110);

        //agrega complementos
        empleadoContratado.agregarComplemento(new ComplementoNocturnidad());
        empleadoPorHoras.agregarComplemento(new ComplementoProductividad());
        empleadoBaseComision.agregarComplemento(new ComplementoInsalubridad());

        //creo facturas
        Factura[] facturas = new Factura[3];
        facturas[0] = new Factura();
        facturas[1] = new Factura();
        facturas[2] = new Factura();

        // crea un arrayList Empleado
        ArrayList<PorPagar> porPagar = new ArrayList<>();

        // inicializa el arreglo con objetos Empleado
        porPagar.add(empleadoAsalariado);
        porPagar.add(empleadoPorHoras);
        porPagar.add(empleadoPorComision);
        porPagar.add(empleadoBaseComision);
        porPagar.add(empleadoContratado);
        porPagar.add(empleadoPermanente);
        porPagar.add(facturas[0]);
        porPagar.add(facturas[1]);

        System.out.println("------------------------------------------");
        System.out.println("PorPagar procesados en forma polimórfica:");
        System.out.println("------------------------------------------");

        // procesa en forma genérica a cada elemento en el array empleados
        // este codigo lo habia puesto en el ejercicio original pra probar el polimorfismo
        //con la variable local montoTotal
        for (PorPagar objetoPagable : porPagar) {
            System.out.println(objetoPagable); // invoca a toString
            System.out.printf("Ingreso: $%,.2f\n",objetoPagable.obtenerMontoPago());
            System.out.println("------------------------------------------");
            montoTotal += objetoPagable.obtenerMontoPago();
        }
        System.out.printf("El monto total a pagar es: $%,.2f\n", montoTotal);
        System.out.println("------------------------------------------");
        System.out.printf("El sueldo promedio es: $%,.2f\n", Empleado.calcularSueldoPromedio(porPagar));
        System.out.println("------------------------------------------");
        System.out.printf("Las horas promedio trabajadas son: %,.1f horas\n" , Empleado.calcularHorasPromedio(porPagar));
        System.out.println("------------------------------------------");

        //testeo de excepciones
        System.out.println("\n::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Testeo de excepciones:");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::");
        try {
            EmpleadoAsalariado empleadoAsalariadoError = new EmpleadoAsalariado("Juan", "Perez", LocalDate.of(1985, 5, 15), "111-11-1111", categorias[0], departamentos[1],-800.00, LocalDate.of(2008, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            EmpleadoPorHoras empleadoPorHorasError = new EmpleadoPorHoras("Jorge", "Gonzalez", LocalDate.of(1990, 3, 20), "222-22-2222", categorias[1], departamentos[1], -8);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            EmpleadoPorComision empleadoPorComisionError = new EmpleadoPorComision("Ana", "Lopez", LocalDate.of(1995, 7, 30), "333-33-3333", categorias[2], departamentos[0], -10000, .06);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmpleadoPorPiezas empleadoContratadoError = new EmpleadoContratado("Maria", "Martinez", LocalDate.of(2005, 1, 10), "555-55-5555", categorias[4], departamentos[2], -100, 2.5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            EmpleadoPermanente empleadoPermanenteError = new EmpleadoPermanente("Pedro", "Sanchez", LocalDate.of(2013, 12, 20), "666-66-6666", categorias[5], departamentos[2], 100, 2.5, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::");

        System.out.println("\n No era parte de la consigna, pero me pareció más saludable refactorizar los complementos en su propio paquete, porque tantas clases sueltas se estaba tornando un poco caótico.");
    }

}