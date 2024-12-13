package prog.unidad04.practica406.libreria;

public class Vehiculo {

    public String matricula;
    public Fecha fechaMatricula;
    public int vehiculosMatriculados;

    protected Vehiculo(String matricula, Fecha fechaMatricula){
        this.matricula = matricula;
        this.fechaMatricula = fechaMatricula;
    }

    public String getMatricula(){
        return matricula;
    }

    public Fecha getFechaMatriculacion(){

    }



}
