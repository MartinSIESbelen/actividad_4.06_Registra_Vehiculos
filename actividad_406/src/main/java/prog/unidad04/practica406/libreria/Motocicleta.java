package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una motocicleta, derivada de la clase Vehiculo.
 */
public class Motocicleta extends Vehiculo implements MaquinaConDistintivoAmbiental {

  /** Atributo que representa la cilindrada de la motocicleta */
  private int cilindrada;

  /**
   * Constructor para crear una motocicleta con matricula, fecha de matriculacion
   * (heredadas de la superClase Vehiculo) y cilindrada.
   *
   * @param matricula      Matricula de la motocicleta.
   * @param fechaMatricula Fecha de matriculacion.
   * @param cilindrada     Cilindrada en centimetros cubicos (debe ser mayor o
   *                       igual a 50).
   * @throws IllegalArgumentException Si la cilindrada es menor a 50.
   */
  protected Motocicleta(String matricula, Fecha fechaMatricula, int cilindrada) {
    super(matricula, fechaMatricula);

    if (cilindrada < 50) {
      throw new IllegalArgumentException();
    }

    this.cilindrada = cilindrada;

  }

  public int getCilindrada() {
    return cilindrada;
  }

  /**
   * Metodo get que obtiene el distintivo ambiental segun la cilindrada.
   * 
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
   * @return Una cadena que devuelve la informacion de una Motocicleta.
   */
  @Override
  public String toString() {
    return "Matricula: " + matricula + " FechaMatricula: " + fechaMatricula.toString() + "%n, cilindrada: " + cilindrada;
  }

}