package prog.unidad04.practica406.libreria;

/**
 * Clase para generar Vehículos con matrícula y fecha de matrícula.
 */
public class Vehiculo {
  /** Matrícula del vehículo */
  public String matricula;
  /** Fecha de matriculación del vehículo */
  public Fecha fechaMatricula;

  /**
   * Constructor para crear un vehículo con su matrícula y fecha de matriculación.
   * Valida que la matrícula tenga el formato correcto.
   *
   * @param matricula      Matrícula del vehículo (debe tener 7 caracteres: 4
   *                       dígitos y 3 letras mayúsculas).
   * @param fechaMatricula Fecha de matriculación del vehículo.
   * @throws IllegalArgumentException Si la matrícula no es válida.
   */
  protected Vehiculo(String matricula, Fecha fechaMatricula) {
    // Inicializo la variable
    String matriculaSinEspacios = "";

    // Recorro matrícula carácter por carácter con un tipo char para quitar los
    // espacios.
    for (int i = 0; i < matricula.length(); i++) {
      char c = matricula.charAt(i);
      if (c != ' ') {
        matriculaSinEspacios = matriculaSinEspacios + c;
      }
    }

    // Compruebo que la matrícula (sin espacios) no tenga menos o más de 7
    // caracteres
    if (matriculaSinEspacios.length() != 7) {
      throw new IllegalArgumentException(
          "Valor introducido erróneo, la matrícula debe de estar compuesta por 7 caracteres (sin espacios incluidos).");
    }

    // Recorro los 4 primeros caracteres de matrícula (sin espacios) para controlar
    // que sean números
    for (int i = 0; i < 4; i++) {
      if (!Character.isDigit(matriculaSinEspacios.charAt(i))) {
        throw new IllegalArgumentException(
            "Valor introducido erróneo, los 4 primeros caracteres deben de ser numéricos");
      }
    }

    // Recorro los 3 últimos caracteres de matrícula (sin espacios) para controlar
    // que sean letras del abecedario
    for (int i = 4; i < 7; i++) {
      char c = matriculaSinEspacios.charAt(i);
      if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
        throw new IllegalArgumentException(
            "Valor introducido erróneo, los 3 últimos caracteres deben de ser letras del abecedario");
      }
    }

    this.matricula = matricula;
    this.fechaMatricula = fechaMatricula;
  }

  /**
   * Método get que obtiene la matrícula del vehículo.
   * 
   * @return Devuelve la matrícula del vehículo.
   */
  public String getMatricula() {
    return matricula;
  }

  /**
   * Método get que obtiene la fecha de matriculación del vehículo.
   * 
   * @return Devuelve la fecha de matriculación.
   */
  public Fecha getFechaMatriculacion() {
    return fechaMatricula;
  }

  /**
   * @return Devuelve una cadena que incluye la matrícula y la fecha de
   *         matriculación. FechaMatricula usa el método toString de la clase
   *         Fecha para salir con el formato correcto.
   */
  public String toString() {
    return "Matrícula: " + this.matricula + ", Fecha Matriculación: " + this.fechaMatricula.toString();
  }
}