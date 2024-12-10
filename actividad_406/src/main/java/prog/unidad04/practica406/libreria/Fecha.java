package prog.unidad04.practica406.libreria;

public class Fecha {
    protected int dia;
    protected int mes;
    protected int anyo;

    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAnyo(){
        return anyo;
    }

}