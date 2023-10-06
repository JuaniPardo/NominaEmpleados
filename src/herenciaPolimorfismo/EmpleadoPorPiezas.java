package herenciaPolimorfismo;

import java.time.LocalDate;

public class EmpleadoPorPiezas extends Empleado{

    private int piezas;
    private double pagoPorPieza;

    // constructor sin fecha de alta
    public EmpleadoPorPiezas(String nombre, String apellido, LocalDate fecNac, String nss, int piezas, double pagoPorPieza){
        super(nombre, apellido, fecNac, nss);
        establecerPiezas(piezas);
        establecerPagoPorPieza(pagoPorPieza);
    }

    // constructor con fecha de alta
    public EmpleadoPorPiezas(String nombre, String apellido, LocalDate fecNac, String nss, int piezas, double pagoPorPieza, LocalDate fecAlta){
        super(nombre, apellido, fecNac, nss, fecAlta);
        establecerPiezas(piezas);
        establecerPagoPorPieza(pagoPorPieza);
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

    // calcula los ingresos
    @Override
    public double ingresos(){
        return (obtenerPagoPorPieza() * obtenerPiezas()) * ingresosComplementos();
    }

    // devuelve representación String de un objeto EmpleadoPorPiezas
    @Override
    public String toString(){
        return "Empleado por piezas: \n" +
                super.toString() + "\n" +
                "Piezas: " + obtenerPiezas() + "\n" +
                "Pago por pieza: " + obtenerPagoPorPieza();
    }
}
