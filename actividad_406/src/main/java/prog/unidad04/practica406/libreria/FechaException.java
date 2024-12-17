package prog.unidad04.practica406.libreria;

/**
 * Clase que personaliza las excepciones para los errores de la clase Fecha.
 */
public class FechaException extends RuntimeException {

    public FechaException(String mensaje) {
      super(mensaje);
    }
  
  }