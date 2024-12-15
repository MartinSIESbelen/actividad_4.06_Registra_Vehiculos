package prog.unidad04.practica406.libreria;

import java.time.LocalDate;

/**
 * Clase que representa una fecha con día, mes y año, validando su valor.
 */
public class Fecha {

    /**
     * Atributo estatico que registra el año actual
     */
    private static final int ANYO_ACTUAL = LocalDate.now().getYear();
    /**
     * Atributo estatico que registra el año minino segun la fecha de inicio del
     * calendario (1/1/1900) indicada en la documentación
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
     * Constructor para crear una fecha válida.
     *
     * @param dia Día del mes (31-30-29-28) en función del mes y dependiendo de
     * si el año es bisiesto o no.
     * @param mes Mes del año entre (1-12).
     * @param anyo Año (entre 1900 y el actual).
     * @throws IllegalArgumentException Si los valores no forman una fecha
     * válida.
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
     * @return Un número entero positivo si la fecha actual es posterior,
     * negativo si es anterior, y 0 si ambas fechas son iguales.
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
     * Verifica si un año específico es bisiesto.
     *
     * @param anyo El año a verificar.
     * @return true si el año es bisiesto, false en caso contrario.
     */
    private boolean esBisiesto(int anyo) {
        return ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0));
    }

    /**
     * Calcula la cantidad de días entre la fecha actual y otra fecha dada.
     *
     * @param fecha La fecha con la que se calculará la diferencia.
     * @return La cantidad de días entre ambas fechas.
     * @throws FechaException si la fecha proporcionada es anterior a la actual.
     */
    public long diasEntre(Fecha fecha) {
        // Si la fecha a comparar es anterior a la actual lanza una FechaException
        if (fecha.compara(this) < 0) {
            throw new FechaException();
        }
        int diferenciaDias = 0;

        diferenciaDias += diferenciaDeAnyosEnDias(anyo, fecha.anyo);
        diferenciaDias += diasTranscurridosEnAnyo(fecha.dia, fecha.mes, fecha.anyo) - (diasTranscurridosEnAnyo(dia, mes, anyo));

        return Math.abs(diferenciaDias);
    }

    /**
     * Calcula la cantidad de días en un mes específico de un año dado.
     *
     * @param mes El mes para calcular los días.
     * @param anyo El año en el que se encuentra el mes.
     * @return La cantidad de días del mes.
     * @throws FechaException si los dias no corresponde correctamente al mes
     */
    private int diasPorMes(int mes, int anyo) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anyo) ? 29 : 28;
            default:
                throw new FechaException();
        }
    }

    /**
     * Calcula la diferencia en días entre dos años.
     *
     * @param anyo1 El año inicial.
     * @param anyo2 El año final.
     * @return La cantidad de días entre los dos años.
     */
    private int diferenciaDeAnyosEnDias(int anyo1, int anyo2) {
        int dias = 0;
        for (int i = anyo1; i < anyo2; i++) {
            dias += esBisiesto(i) ? 366 : 365;
        }
        return dias;
    }

    /**
     * Calcula la cantidad de días transcurridos en un año desde el inicio hasta
     * una fecha específica.
     *
     * @param dia El día de la fecha.
     * @param mes El mes de la fecha.
     * @param anyo El año de la fecha.
     * @return La cantidad de días transcurridos en el año.
     */
    private int diasTranscurridosEnAnyo(int dia, int mes, int anyo) {
        int dias = 0;
        for (int i = 1; i < mes; i++) {
            dias += diasPorMes(i, anyo);
        }
        return dias + dia;
    }

    /**
     * Calcula la cantidad de días transcurridos desde el 1 de enero de 1900
     * hasta la fecha actual.
     *
     * @return La cantidad total de días transcurridos.
     */
    public long diasTranscurridos() {
        // Calcular la diferencia de días entre la fecha actual y el 1 de enero del 1900
        return new Fecha(1, 1, 1900).diasEntre(this);
    }

    /**
     * Representa la fecha como una cadena legible en formato "día de mes de
     * año".
     *
     * @return Una representación en cadena de la fecha.
     */
    @Override
    public String toString() {
        return dia + " de " + getMes(mes) + " de " + anyo;
    }

    /**
     * Devuelve el nombre del mes según su número.
     *
     * @param mes El número del mes (1 a 12).
     * @return El nombre del mes.
     * @throws FechaException si no es uno de los 12 case (si el mes no es un numero del 1 al 12)
     */
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
                throw new FechaException();
        }
    }

}
