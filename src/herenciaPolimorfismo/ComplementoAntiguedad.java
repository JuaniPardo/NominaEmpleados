package herenciaPolimorfismo;

import java.time.LocalDate;
import java.time.Period;

public class ComplementoAntiguedad extends ComplementoSalarial {
        private LocalDate fecAlta;
        public ComplementoAntiguedad(LocalDate fecAlta){
            super("Antigüedad", "Complemento por antigüedad");
            establecerfecAlta(fecAlta);

        }

        public void establecerfecAlta(LocalDate fecAlta){
            this.fecAlta = fecAlta;
        }

        @Override
        public double obtenerMonto() {
            int antiguedad = Period.between(fecAlta, LocalDate.now()).getYears();
            return antiguedad * 0.1;
        }

        public String toString(){
            return super.toString() + " - Monto: " + obtenerMonto() + "\n";
        }
}