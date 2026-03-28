package modelo;

//Clase unica
public class Libro {
    private int id;
    private String nombre;
    private String genero;
    private String autor;
    private int cantidad;
    private int prestados;
    private String idioma ;
    private String sinopsis;
    private String editorial;
    private int anioPubli;

    //Constructor de la clase libro
    public Libro(){}

    //Metodos set y get
    public void setId(int nuevoId){ this.id = nuevoId; }
    public int getId(){ return this.id; }

    public void setNombre(String nuevoNombre){this.nombre = nuevoNombre;}
    public String getNombre(){return this.nombre;}

    public void setGenero(String nuevoGenero){this.genero = nuevoGenero;}
    public String getGenero() {return this.genero;}

    public void setAutor(String nuevoAutor){this.autor = nuevoAutor;}
    public String getAutor(){return this.autor;}

    public void setCantidad(int nuevaCantidad){this.cantidad = nuevaCantidad;}
    public int getCantidad(){return this.cantidad;}

    public void setPrestados(int nuevosPrestados){this.prestados = nuevosPrestados;}
    public int getPrestados(){return this.prestados;}

    public void setIdioma(String nuevoIdioma){this.idioma = nuevoIdioma;}
    public String getIdioma(){return this.idioma;}

    public void setSinopsis(String nuevaSinopsis){this.sinopsis = nuevaSinopsis;}
    public String getSinopsis(){return this.sinopsis;}

    public void setEditorial(String nuevaEditorial){this.editorial = nuevaEditorial;}
    public String getEditorial(){return this.editorial;}

    public void setAnioPubli(int nuevoAnioPubli){this.anioPubli = nuevoAnioPubli;}
    public int getAnioPubli(){return this.anioPubli;}

}
