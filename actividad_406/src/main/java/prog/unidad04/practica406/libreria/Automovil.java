package prog.unidad04.practica406.libreria;

/**
 * La clase que permite generar un automovil, deriva de la clase Vehículo.
 */
public class Automovil extends Vehiculo implements MaquinaConDistintivoAmbiental {

    /**
     * Atributos staticos que representan los colores disponible para nuestro automovil
     */
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_NEGRO = "Negro";
    public static final String COLOR_AZUL = "Azul";

    /** El color del automovil */
    private String color;
    /** Número de plazas que dispone el automovil */
    private int plazas;

    /**
     * Constructor para crear un automóvil con matrícula, fecha de matriculación, color y número de plazas.
     *
     * @param matricula Matrícula del automóvil.
     * @param fechaMatricula Fecha de matriculación.
     * @param color Color del automóvil (Blanco, Negro o Azul).
     * @param plazas Número de plazas (debe ser mayor que 0).
     * @throws IllegalArgumentException Si el color no es válido.
     */
    public Automovil(String matricula, Fecha fechaMatricula, String color, int plazas) {
        super(matricula, fechaMatricula);

        if(plazas <= 0){
            throw new IllegalArgumentException();
        }

        if (color != COLOR_BLANCO && color != COLOR_AZUL && color != COLOR_NEGRO) {
            throw new IllegalArgumentException();
        }

        this.color = color;
        this.plazas = plazas;
    }

    /**
     * Metodo get que obtiene el color del automóvil.
     * @return Devuelve el color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo get que obtiene el número de plazas del automóvil.
     * @return devuelve el número de plazas.
     */
    public int getPlazas() {
        return plazas;
    }

    /**
     * Metodo get que obtiene el distintivo ambiental según el número de plazas.
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

    /**
     * Devuelve una representación en texto del automóvil.
     * @return Una cadena que incluye información del automóvil.
     */
    public String toString() {
        return super.toString() + ", Color: " + this.color + ", Num. Plazas: " + this.plazas;
    }
}
