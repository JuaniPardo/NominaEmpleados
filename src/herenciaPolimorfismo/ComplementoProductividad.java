package herenciaPolimorfismo;

public class ComplementoProductividad extends ComplementoSalarial {

    public ComplementoProductividad(){
        super("Productividad", "Complemento por productividad");
    }

    @Override
    public double obtenerMonto() {
        return 0.15;
    }
}
