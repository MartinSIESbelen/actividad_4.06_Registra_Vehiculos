package prog.unidad04.practica406.libreria;

/**
 * La clase que permite generar un automóvil, deriva de la clase Vehículo.
 */
public class Automovil extends Vehiculo implements MaquinaConDistintivoAmbiental {

    /**
     * Atributos estáticos que representan los colores disponibles para nuestro
     * automóvil.
     */
    public static final String COLOR_BLANCO = "blanco";
    public static final String COLOR_NEGRO = "negro";
    public static final String COLOR_AZUL = "azul";
  
    /** El color del automóvil */
    private String color;
    /** Número de plazas que dispone el automóvil */
    private int plazas;
  
    /**
     * Constructor para crear un automóvil con matrícula, fecha de matriculación,
     * color y número de plazas.
     *
     * @param matricula      Matrícula del automóvil.
     * @param fechaMatricula Fecha de matriculación.
     * @param color          Color del automóvil (Blanco, Negro o Azul).
     * @param plazas         Número de plazas (debe ser mayor que 0).
     * @throws IllegalArgumentException Si el color no es válido.
     */
    public Automovil(String matricula, Fecha fechaMatricula, String color, int plazas) {
      super(matricula, fechaMatricula);
      // Controlo que el número de plazas no sea 0 o menos.
      if (plazas <= 0) {
        throw new IllegalArgumentException("Valor introducido erróneo, el automóvil tiene que tener mínimo una plaza.");
      }
  
      // Controlo que el color sea uno de los 3 deseados según el enunciado
      if (!esColorValido(color)) {
        throw new IllegalArgumentException("Valor introducido erróneo, el color debe de ser uno de los 3 indicados.");
      }
  
      this.color = color;
      this.plazas = plazas;
    }
  
    /**
     * Método get que obtiene el color del automóvil.
     * 
     * @return Devuelve el color del automóvil.
     */
    public String getColor() {
      return color;
    }
  
    /**
     * Método get que obtiene el número de plazas del automóvil.
     * 
     * @return devuelve el número de plazas.
     */
    public int getPlazas() {
      return plazas;
    }
  
    /**
     * Método get que obtiene el distintivo ambiental según el número de plazas.
     * 
     * @return Devuelve el distintivo ambiental (0, ECO, A o B).
     */
    @Override
    public String getDistintivo() {
      if (plazas == 1) {
        return "0";
      }
  
      if (plazas <= 3) {
        return "ECO";
      }
  
      if (plazas <= 5) {
        return "A";
      }
  
      return "B";
    }
  
    private boolean esColorValido(String color) {
  
      return color.equals(COLOR_AZUL) || color.equals(COLOR_NEGRO) || color.equals(COLOR_BLANCO);
    }
  
    /**
     * Devuelve una representación en texto del automóvil.
     * 
     * @return Una cadena que incluye información del automóvil.
     */
    @Override
    public String toString() {
      return "Matrícula: " + matricula + ", fechaMatricula: " + fechaMatricula.toString() + "%n, Color=" + color
          + ", Plazas: " + plazas;
    }
}
  