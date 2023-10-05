package herenciaPolimorfismo;

public class ComplementoNocturnidad extends ComplementoSalarial {

    public ComplementoNocturnidad(){
        super("Nocturnidad", "Complemento por nocturnidad");
    }

    @Override
    public double obtenerMonto() {
        return 0.1;
    }
}