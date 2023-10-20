package interfazPolimorfismo.complementosSalariales;

public class ComplementoProductividad extends ComplementoSalarial {

    public ComplementoProductividad(){
        super("Productividad", "Complemento por productividad");
    }

    @Override
    public double obtenerMonto() {
        return 0.15;
    }

    @Override
    public String toString(){
        return super.toString() + " - Monto (%): " + obtenerMonto()*100;
    }
}
