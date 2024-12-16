package prog.unidad04.practica406.libreria;
/**
 * Clase para generar Vehiculos con matricula y fecha matricula
 */
public class Vehiculo {
    /**Matricula del vehiculo */
    public String matricula;
    /**Fecha de matriculación del vehículo */
    public Fecha fechaMatricula;
    /**Contador del número de vhículos matriculados*/
    public int vehiculosMatriculados;

    /**
     * Constructor para crear un vehículo con su matrícula y fecha de matriculación.
     * Valida que la matrícula tenga el formato correcto.
     *
     * @param matricula Matrícula del vehículo (debe tener 7 caracteres: 4 dígitos y 3 letras mayúsculas).
     * @param fechaMatricula Fecha de matriculación del vehículo.
     * @throws IllegalArgumentException Si la matrícula no es válida.
     */
    protected Vehiculo(String matricula, Fecha fechaMatricula){

        String matriculaSinEspacios = "";

        for (int i = 0; i < matricula.length(); i++) {
            char c = matricula.charAt(i);
            if (c != ' ') {
                matriculaSinEspacios = matriculaSinEspacios + c;
            }
        }
    
          if(matriculaSinEspacios.length() != 7){
              throw new IllegalArgumentException();
          }
    
          for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matriculaSinEspacios.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    
        for (int i = 4; i < 7; i++) {
            char c = matriculaSinEspacios.charAt(i);
            if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                throw new IllegalArgumentException();
            }
        }

        this.matricula = matricula;
        this.fechaMatricula = fechaMatricula;
    }

     /**
     * Metodo get que obtiene la matrícula del vehículo.
     * @return Devuelve la matrícula del vehículo.
     */
    public String getMatricula(){
        return matricula;
    }

     /**
     * Metodo get que obtiene la fecha de matriculación del vehículo.
     * @return Devuelve la fecha de matriculación.
     */
    public Fecha getFechaMatriculacion(){
        return fechaMatricula;
    }

    /**
     * @return Devuelve una cadena que incluye la matrícula y la fecha de matriculación.
     * FechaMatricula usa el metodo toString de la clase Fecha para salir con el formato correcto.
     */
    @Override
    public String toString(){
        return "Matricula: " + this.matricula + ", Fecha Matriculación: " + this.fechaMatricula.toString();
    }

    


}
