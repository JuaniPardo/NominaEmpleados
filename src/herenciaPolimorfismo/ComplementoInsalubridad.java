package herenciaPolimorfismo;

public class ComplementoInsalubridad extends ComplementoSalarial {

    public ComplementoInsalubridad(){
        super("Insalubridad", "Complemento por insalubridad");
    }

    @Override
    public double obtenerMonto() {
        return 0.25;
    }
}