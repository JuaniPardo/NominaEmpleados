package interfazPolimorfismo.complementosSalariales;

public class ComplementoInsalubridad extends ComplementoSalarial {

    public ComplementoInsalubridad(){
        super("Insalubridad", "Complemento por insalubridad");
    }

    @Override
    public double obtenerMonto() {
        return 0.25;
    }

    @Override
    public String toString(){
        return super.toString() + " - Monto (%): " + obtenerMonto()*100;
    }
}