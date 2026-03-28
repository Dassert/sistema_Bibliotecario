package modelo;
import java.time.LocalDate;

//Clase asociado hereda de usuario
public class Asociados extends Usuario{
    private int numAsoc;
    public int[] prestamos = {0,0,0,0,0};
    public LocalDate[] fechaPrestamo = new LocalDate[5];
    public LocalDate[] fechaEntrega = new LocalDate[5];

    public Asociados(){}

    //Metodos para asignar y obtener valores a atributos privados
    public void setNumAso(int nNumAso) { this.numAsoc = nNumAso; }
    public int getNumAso() { return this.numAsoc; }
}
