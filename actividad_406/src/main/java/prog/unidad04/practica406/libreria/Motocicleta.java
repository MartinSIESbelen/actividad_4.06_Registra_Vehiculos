package prog.unidad04.practica406.libreria;

public class Motocicleta extends Vehiculo implements MaquinaConDistintivoAmbiental {

    private String matricula;
    private Fecha fechaMatricula;
    private int cilindrada;

    protected Motocicleta(String matricula, Fecha fechaMatricula) {
        super(matricula, fechaMatricula);
        this.cilindrada = cilindrada;

    }

    @Override
    public String getDistintivo() {
        if (cilindrada == 75) {
            return "0";
        }

        if (cilindrada <= 125) {
            return "ECO";
        }

        if (cilindrada <= 500) {
            return "A";
        }
        return "B";
    }  
  }
