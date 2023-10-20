package interfazPolimorfismo;

public class Factura implements PorPagar {
    @Override
    public double obtenerMontoPago() {
        return 100; //hardcodeado
    }

    @Override
    public String toString() {
        return "Esto es una Factura";
    }
}
