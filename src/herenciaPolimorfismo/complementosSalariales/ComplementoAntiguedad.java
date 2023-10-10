package herenciaPolimorfismo.complementosSalariales;

import java.time.LocalDate;
import java.time.Period;

public class ComplementoAntiguedad extends ComplementoSalarial {
    private LocalDate fecAlta;

    public ComplementoAntiguedad(LocalDate fecAlta) {
        super("Antigüedad", "Complemento por antigüedad");
        establecerfecAlta(fecAlta);

    }

    public void establecerfecAlta(LocalDate fecAlta) {
        this.fecAlta = fecAlta;
    }

    public int obtenerAntiguedad() {
        return Period.between(fecAlta, LocalDate.now()).getYears();
    }

    @Override
    public double obtenerMonto() {
        int antiguedad = obtenerAntiguedad();
        return antiguedad * 0.01;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + obtenerAntiguedad() + " años - Monto (%): " + obtenerMonto() * 100;
    }
}