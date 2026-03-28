package modelo;

//Clase abstracta padre
public abstract class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int diaNac;
    private int mesNac;
    private int anioNac;
    private String sexo;
    private String curp;
    private String direccion;

    //Metodos set y get para cada atributo
    public void setNombre(String nNombre){ this.nombre = nNombre; }
    public String getNombre() { return nombre; }

    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoPaterno() { return this.apellidoPaterno; }

    public void setApellidoMaterno(String nApellidoMaterno) { this.apellidoMaterno = nApellidoMaterno; }
    public String getApellidoMaterno() { return this.apellidoMaterno; }

    public void setDiaNac(int nDiaNac) { this.diaNac = nDiaNac; }
    public int getDiaNac() { return this.diaNac; }

    public void setMesNac(int nMesNac) { this.mesNac = nMesNac; }
    public int getMesNac(){ return this.mesNac; }

    public void setAnioNac(int nAnioNac) { this.anioNac = nAnioNac; }
    public int getAnioNac(){ return this.anioNac; }

    public void setSexo(String nuevoSexo){this.sexo = nuevoSexo;}
    public String getSexo () {return this.sexo;}

    public void setCurp(String nuevaCurp){ this.curp = nuevaCurp; }
    public String getCurp() { return this.curp; }

    public void setDireccion(String nuevaDireccion) {this.direccion = nuevaDireccion;}
    public String getDireccion() { return this.direccion; }
}
