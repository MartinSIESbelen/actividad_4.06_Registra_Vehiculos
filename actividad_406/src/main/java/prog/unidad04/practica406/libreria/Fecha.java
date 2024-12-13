package prog.unidad04.practica406.libreria;

import java.time.LocalDate;

public class Fecha {

    private static final int ANYO_ACTUAL = LocalDate.now().getYear();
    private static final int ANYO_MINIMO = 1900;
  
    private int dia;
    private int mes;
    private int anyo;
  
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
  
    public int getDia() {
      return dia;
    }
  
    public int getMes() {
      return mes;
    }
  
    public int getAnyo() {
      return anyo;
    }
  
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
  
    public boolean esBisiesto() {
  
      return ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0));
  
    }

    private boolean esBisiesto(int anyo) {
        return ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0));
    }
  
    public long diasEntre(Fecha fecha) {
      // Si la fecha a comparar es anterior a la actual lanza una FechaException
      if (fecha.compara(this) < 0) {
        throw new FechaException();
      }
      int diferenciaDias = 0;

      diferenciaDias += diferenciaDeAnyosEnDias(anyo, fecha.anyo);
      diferenciaDias += diasTranscurridosEnAnyo(fecha.dia, fecha.mes, fecha.anyo) -(diasTranscurridosEnAnyo(dia, mes, anyo));

      return Math.abs(diferenciaDias);
    }

    private int diasPorMes(int mes, int anyo){
        switch(mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anyo) ? 29 : 28;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int diferenciaDeAnyosEnDias(int anyo1, int anyo2){
        int dias = 0;
        for(int i = anyo1; i < anyo2; i++){
            dias += esBisiesto(i) ? 366 : 365;
        }
        return dias;
    }

    private int diasTranscurridosEnAnyo(int dia, int mes, int anyo){
        int dias = 0;
        for(int i = 1; i < mes; i++){
            dias += diasPorMes(i, anyo);
        }
        return dias + dia;
    }
  
  
    public long diasTranscurridos() {
      // Calcular la diferencia de días entre la fecha actual y el 1 de enero del 1900
      return new Fecha(1, 1, 1900).diasEntre(this);
    }

  // 2 de febrero de 1904
    @Override
    public String toString(){
        return dia + " de " + getMes(mes) + " de " + anyo;
    }

    private String getMes(int mes){
        switch(mes){
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
                throw new IllegalArgumentException();
        }
    }
  
  }

 