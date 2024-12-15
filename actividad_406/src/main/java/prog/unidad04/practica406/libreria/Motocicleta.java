package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una motocicleta, derivada de la clase Vehículo.
 */
public class Motocicleta extends Vehiculo implements MaquinaConDistintivoAmbiental {

    /** Atributo que representa la cilindrada de la motocicleta */
    private int cilindrada;

    /**
     * Constructor para crear una motocicleta con matrícula, fecha de matriculación (heredadas de la superClase Vehiculo) y cilindrada.
     *
     * @param matricula Matrícula de la motocicleta.
     * @param fechaMatricula Fecha de matriculación.
     * @param cilindrada Cilindrada en centímetros cúbicos (debe ser mayor o igual a 50).
     * @throws IllegalArgumentException Si la cilindrada es menor a 50.
     */
    protected Motocicleta(String matricula, Fecha fechaMatricula, int cilindrada) {
        super(matricula, fechaMatricula);

        if(cilindrada < 50){
            throw new IllegalArgumentException();
                }

        this.cilindrada = cilindrada;

    }

    /**
     * Metodo get que obtiene el distintivo ambiental según la cilindrada.
     * @return Devuelve el distintivo ambiental (0, ECO, A o B).
     */
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

    /**
     * Devuelve una representación en texto de la motocicleta.
     * @return Una cadena que incluye información de la motocicleta.
     */
    public String toString(){
        return super.toString() + ", Cilindrada:" + this.cilindrada;
    }
  }
