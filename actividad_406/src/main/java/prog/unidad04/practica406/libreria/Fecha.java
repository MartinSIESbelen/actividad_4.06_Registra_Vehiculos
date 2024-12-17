package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una fecha con dia, mes y año, validando su valor.
 */
public class Fecha {

  /**
   * Atributo estatico que registra el año actual
   */
  private static final int ANYO_ACTUAL = LocalDate.now().getYear();
  /**
   * Atributo estatico que registra el año minimo segun la fecha de inicio del
   * calendario (1/1/1900) indicada en la documentacion
   */
  private static final int ANYO_MINIMO = 1900;

  /**
   * Dia del mes
   */
  private int dia;
  /**
   * Mes del año
   */
  private int mes;
  /**
   * año
   */
  private int anyo;

  /**
   * Constructor para crear una fecha valida.
   *
   * @param dia  Dia del mes (31-30-29-28) en funcion del mes y dependiendo de si
   *             el año es bisiesto o no.
   * @param mes  Mes del año entre (1-12).
   * @param anyo Año (entre 1900 y el actual).
   * @throws IllegalArgumentException Si los valores no forman una fecha valida.
   */
  public Fecha(int dia, int mes, int anyo) {
    if (anyo < ANYO_MINIMO || anyo > ANYO_ACTUAL) {
      throw new IllegalArgumentException();
    }

    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException();
    }

    if (dia < 1 || dia > 31) {
      throw new IllegalArgumentException();
    } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
      throw new IllegalArgumentException();
    } else if (mes == 2 && ((dia > 29) || (dia == 29 && !esBisiesto(anyo)))) {
      throw new IllegalArgumentException();
    }

    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;
  }

  /**
   * Metodo get que obtiene el dia
   *
   * @return Devuelve el dia
   */
  public int getDia() {
    return dia;
  }

  /**
   * Metodo get que obtiene el mes
   *
   * @return Devuelve el mes
   */
  public int getMes() {
    return mes;
  }

  /**
   * Metodo get que obtiene el año
   *
   * @return Devuelve el año
   */
  public int getAnyo() {
    return anyo;
  }

  /**
   * Compara dos fechas y determina la diferencia entre ellas.
   *
   * @param fecha La fecha a comparar con la actual.
   * @return Un numero entero positivo si la fecha actual es posterior, negativo
   *         si es anterior, y 0 si ambas fechas son iguales.
   */
  public int compara(Fecha fecha) {

    if (this.anyo != fecha.anyo) {
      return this.anyo - fecha.anyo;
    } else if (this.mes != fecha.mes) {
      return this.mes - fecha.mes;
    } else if (this.dia != fecha.dia) {
      return this.dia - fecha.dia;
    } else {
      return 0;
    }
  }

  /**
   * Verifica si el año actual es bisiesto.
   *
   * @return true si el año es bisiesto, false en caso contrario.
   */
  public boolean esBisiesto() {

    return ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0));

  }

  /**
   * Verifica si un año especifico es bisiesto.
   *
   * @param anyo El año a verificar.
   * @return true si el año es bisiesto, false en caso contrario.
   */
  private boolean esBisiesto(int anyo) {
    return ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0));
  }

  /**
   * Calcula la cantidad de dias entre la fecha actual y otra fecha dada.
   *
   * @param fecha La fecha con la que se calculara la diferencia.
   * @return La cantidad de dias entre ambas fechas.
   * @throws FechaException si la fecha proporcionada es anterior a la actual.
   */
  public long diasEntre(Fecha fecha) {
    if (fecha.compara(this) < 0) {
      throw new FechaException("Las fechas introducidas no son validas.");
    }
    int diferenciaDias = 0;

    diferenciaDias += diferenciaDeAnyosEnDias(anyo, fecha.anyo);
    diferenciaDias += diasTranscurridosEnAnyo(fecha.dia, fecha.mes, fecha.anyo)
        - (diasTranscurridosEnAnyo(dia, mes, anyo));

    return Math.abs(diferenciaDias);
  }

  /**
   * Calcula la cantidad de dias en un mes especifico de un año dado.
   *
   * @param mes  El mes para calcular los dias.
   * @param anyo El año en el que se encuentra el mes.
   * @return La cantidad de dias del mes.
   * @throws FechaException si los dias no corresponde correctamente al mes
   */
  private int diasPorMes(int mes, int anyo) {
    switch (mes) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      return 31;
    case 4:
    case 6:
    case 9:
    case 11:
      return 30;
    case 2:
      return esBisiesto(anyo) ? 29 : 28;
    default:
      throw new FechaException("Valor introducido erroneo, los meses del año van del 1 al 12");
    }
  }

  private int diferenciaDeAnyosEnDias(int anyo1, int anyo2) {
    int dias = 0;
    for (int i = anyo1; i < anyo2; i++) {
      dias += esBisiesto(i) ? 366 : 365;
    }
    return dias;
  }

  private int diasTranscurridosEnAnyo(int dia, int mes, int anyo) {
    int dias = 0;
    for (int i = 1; i < mes; i++) {
      dias += diasPorMes(i, anyo);
    }
    return dias + dia;
  }

  public long diasTranscurridos() {
    return new Fecha(1, 1, 1900).diasEntre(this);
  }

  @Override
  public String toString() {
    return dia + " de " + getMes(mes) + " de " + anyo;
  }

  private String getMes(int mes) {
    switch (mes) {
    case 1:
      return "enero";
    case 2:
      return "febrero";
    case 3:
      return "marzo";
    case 4:
      return "abril";
    case 5:
      return "mayo";
    case 6:
      return "junio";
    case 7:
      return "julio";
    case 8:
      return "agosto";
    case 9:
      return "septiembre";
    case 10:
      return "octubre";
    case 11:
      return "noviembre";
    case 12:
      return "diciembre";
    default:
      throw new FechaException("Valor introducido erroneo, los meses del año van del 1 al 12");
    }
  }
}