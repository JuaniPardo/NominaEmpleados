package interfazPolimorfismo;

import java.time.LocalDate;

//al incluir el tipo de contrato, se puede saber si es un empleado contratado o permanente
//por lo tanto, la clase EmpleadoPorPiezas es abstracta ya que no tiene sentido instanciarla por si sola
//El EmpleadoPorPiezas o es contratado o permanente
//Si surge un nuevo tipo de contrato, se puede agregar una nueva clase que herede de EmpleadoPorPiezas
public abstract class EmpleadoPorPiezas extends Empleado {

    private int piezas;
    private double pagoPorPieza;
    private String tipoContrato;

    // constructor
    public EmpleadoPorPiezas(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, String tipoContrato, int piezas, double pagoPorPieza){
        super(nombre, apellido, fecNac, nss, categoria, departamento);
        establecerTipoContrato(tipoContrato);
        establecerPiezas(piezas);
        establecerPagoPorPieza(pagoPorPieza);
    }

    public EmpleadoPorPiezas(String nombre, String apellido, LocalDate fecNac, String nss, Categoria categoria, Departamento departamento, String tipoContrato, int piezas, double pagoPorPieza, LocalDate fecAlta){
        super(nombre, apellido, fecNac, nss, categoria, departamento, fecAlta);
        establecerTipoContrato(tipoContrato);
        establecerPiezas(piezas);
        establecerPagoPorPieza(pagoPorPieza);
    }

    //establece el contrato
    public void establecerTipoContrato(String tipoContrato){
        this.tipoContrato = tipoContrato;
    }

    //devuelve el contrato
    public String obtenerTipoContrato(){
        return tipoContrato;
    }

    // establece las piezas
    public void establecerPiezas(int piezas){
        if(piezas >= 0){
            this.piezas = piezas;
        }else{
            throw new IllegalArgumentException("Las piezas deben ser >= 0");
        }
    }

    // devuelve las piezas
    public int obtenerPiezas(){
        return piezas;
    }

    // establece el pago por pieza
    public void establecerPagoPorPieza(double pagoPorPieza){
        if(pagoPorPieza >= 0){
            this.pagoPorPieza = pagoPorPieza;
        }else{
            throw new IllegalArgumentException("El pago por pieza debe ser >= 0");
        }
    }

    // devuelve el pago por pieza
    public double obtenerPagoPorPieza(){
        return pagoPorPieza;
    }

    //calcular sueldo
    public double calcularSueldo(){
        return obtenerPagoPorPieza() * obtenerPiezas();
    }

    // calcula los ingresos
    @Override
    public double obtenerMontoPago(){
        return calcularSueldo() * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoPorPiezas
    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Tipo de contrato: " + obtenerTipoContrato() + "\n" +
                "Piezas: " + obtenerPiezas() + "\n" +
                "Pago por pieza: " + obtenerPagoPorPieza();
    }
}
