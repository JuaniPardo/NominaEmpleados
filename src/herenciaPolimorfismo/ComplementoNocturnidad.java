package herenciaPolimorfismo;

public class ComplementoNocturnidad extends ComplementoSalarial {

    public ComplementoNocturnidad(){
        super("Nocturnidad", "Complemento por nocturnidad");
    }

    @Override
    public double obtenerMonto() {
        return 0.1;
    }

    @Override
    public String toString(){
        return super.toString() + " - Monto (%): " + obtenerMonto()*100;
    }
}