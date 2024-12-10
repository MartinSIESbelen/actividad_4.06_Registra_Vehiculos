package prog.unidad04.practica406.libreria;


public class Automovil extends Vehiculo implements MaquinaConDistintivoAmbiental {

    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_NEGRO = "Negro";
    public static final String COLOR_AZUL = "Azul";

    protected String matricula;
    protected Fecha fechaMatricula;
    protected String color;
    protected int numeroPlazas;
    
    /**
     * @param matricula La matricula del coche
     * @param fechaMatricula
     * @param color 
     * @param numeroPlazas El numero de plazas del coche
     */
    public Automovil(String matricula, Fecha fechaMatricula, String color, int numeroPlazas) {
        String matriculaSinEspacios = matricula.replaceAll("\\s+", "");
        if(matriculaSinEspacios.length() != 7){
            throw new IllegalArgumentException();
        }

        // if (color != COLOR_BLANCO && color != COLOR_AZUL && color != COLOR_NEGRO)

        this.matricula = matricula;
        this.fechaMatricula = fechaMatricula;
        this.color = color;
        this.numeroPlazas = numeroPlazas;
    }

    public String getMatricula() {
        return matricula;
    } 

    public Fecha getFechaMatriculacion() {
        return fechaMatricula;
    }

    public String getColor() {
        return color;
    }

    public int getPlazas() {
        return numeroPlazas;
    }

    @Override
    public String getDistintivo() {
        if(numeroPlazas == 1) return "0";

        if(numeroPlazas <= 3) return "ECO";

        if(numeroPlazas <= 5) return "A";

        return "B";
    }
}
