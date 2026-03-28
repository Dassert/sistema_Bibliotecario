package modelo;

//Clase abstracta que hereda de persona
public abstract class Usuario extends Persona{

    private String nombreUsuario;
    private String contrasenia;
    private int diaRegistro;
    private int mesRegistro;
    private int anioRegistro;

    //Metodos para asignar y obtener valores a atributos privados

    public void setNombreUsuario(String nuevoNombreUsuario){this.nombreUsuario = nuevoNombreUsuario;}
    public String getNombreUsuario(){return this.nombreUsuario;}

    public void setContrasenia(String nuevaContrasenia) { this.contrasenia = nuevaContrasenia; }
    public String getContrasenia() { return this.contrasenia; }

    public void setDiaRegistro(int nuevoDiaRegistro){this.diaRegistro = nuevoDiaRegistro;}
    public int getDiaRegistro(){return this.diaRegistro;}

    public void setMesRegistro(int nuevoMesRegistro){this.mesRegistro = nuevoMesRegistro;}
    public int getMesRegistro(){return this.mesRegistro;}

    public void setAnioRegistro(int nuevoanioRegistro){this.anioRegistro = nuevoanioRegistro;}
    public int getAnioRegistro(){return this.anioRegistro;}
}

