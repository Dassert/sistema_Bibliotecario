package modelo;

//Clase empleado hereda de Usuario
public class Empleado extends Usuario{

    //Atributos de la clase empleado
    private int numEmp;
    private String rfc;
    private int sueldo;

    //Contructor de la clase hija empleado
    public Empleado(){}

    //Metodos para asignar y obtener valores a atributos privados
    public void setNumEmp(int nuevoNum){ this.numEmp = nuevoNum; };
    public int getNumEmp(){ return this.numEmp; };

    public void setRfc(String nuevoRfc){ this.rfc = nuevoRfc; };
    public String getRfc(){ return this.rfc; };

    public void setSueldo(int nuevoSueldo){ this.sueldo = nuevoSueldo; };
    public int getSueldo(){ return this.sueldo; };

}