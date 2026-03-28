package datos;

import modelo.Asociados;
import modelo.Libro;

public class RepositorioLibros extends Repositorios {
    //Inicializacion de los libros en un arreglo
    private Libro[] catalogo = new Libro[20];

    //Constructor para los objetos
    public RepositorioLibros(){
        catalogo[0] = new Libro();
        catalogo[0].setId(1);
        catalogo[0].setNombre("Las piedras mágicas astrales");
        catalogo[0].setGenero("Fantasía");
        catalogo[0].setAutor("Tazzer Don Jose");
        catalogo[0].setCantidad(5);
        catalogo[0].setIdioma("Español");
        catalogo[0].setSinopsis("Un libro que trata sobre unas piedras mágicas");
        catalogo[0].setEditorial("Editorial");
        catalogo[0].setAnioPubli(2001);

        catalogo[1] = new Libro();
        catalogo[1].setId(2);
        catalogo[1].setNombre("El elefante parlante");
        catalogo[1].setGenero("Comedia");
        catalogo[1].setAutor("Martinez Tlatelolco");
        catalogo[1].setCantidad(6);
        catalogo[1].setIdioma("Español");
        catalogo[1].setSinopsis("Un elefante con un sentido del humor muy diferente");
        catalogo[1].setEditorial("Editorial");
        catalogo[1].setAnioPubli(1975);

        catalogo[2] = new Libro();
        catalogo[2].setId(3);
        catalogo[2].setNombre("Cañitas");
        catalogo[2].setGenero("Terror");
        catalogo[2].setAutor("Carlos Trejo");
        catalogo[2].setCantidad(1);
        catalogo[2].setIdioma("Español");
        catalogo[2].setSinopsis("El terror como nunca lo esperaste");
        catalogo[2].setEditorial("Editorial");
        catalogo[2].setAnioPubli(1980);

        catalogo[3] = new Libro();
        catalogo[3].setId(4);
        catalogo[3].setNombre("Jujutsu Kaisen");
        catalogo[3].setGenero("Acción");
        catalogo[3].setAutor("Gege");
        catalogo[3].setCantidad(3);
        catalogo[3].setIdioma("Japones");
        catalogo[3].setSinopsis("Estudiantes peleando contra maldiciones");
        catalogo[3].setEditorial("Konami");
        catalogo[3].setAnioPubli(2019);

        catalogo[4] = new Libro();
        catalogo[4].setId(5);
        catalogo[4].setNombre("El principito");
        catalogo[4].setGenero("Fantasía");
        catalogo[4].setAutor("Antoine");
        catalogo[4].setCantidad(2);
        catalogo[4].setIdioma("Español");
        catalogo[4].setSinopsis("Las aventuras del principito");
        catalogo[4].setEditorial("Editorial");
        catalogo[4].setAnioPubli(1998);

        catalogo[5] = new Libro();
        catalogo[5].setId(6);
        catalogo[5].setNombre("IT");
        catalogo[5].setGenero("Terror");
        catalogo[5].setAutor("Stephen King");
        catalogo[5].setCantidad(1);
        catalogo[5].setIdioma("Español");
        catalogo[5].setSinopsis("Niños se enfrentan a un monstruo con forma de payaso");
        catalogo[5].setEditorial("Cesun Librería");
        catalogo[5].setAnioPubli(1986);
    }

    //Metodos para retornar el arreglo completo o individual
    public Libro[] obtenerLibros(){
        return catalogo;
    }
    public Libro obtener1Libro(int i) {
        return catalogo[i];
    }

    //Metodos para agregar, modificar y eliminar libro
    public void agregarLibro(int id, String nombre, String genero, String autor, int cantidad, String idioma, String sinopsis, String editorial, int anioPubli, int i){
        this.catalogo[i] = new Libro();
        this.catalogo[i].setId(id);
        this.catalogo[i].setNombre(nombre);
        this.catalogo[i].setGenero(genero);
        this.catalogo[i].setAutor(autor);
        this.catalogo[i].setCantidad(cantidad);
        this.catalogo[i].setIdioma(idioma);
        this.catalogo[i].setSinopsis(sinopsis);
        this.catalogo[i].setEditorial(editorial);
        this.catalogo[i].setAnioPubli(anioPubli);
    }

    public void modificarLibro(String datoIngresado, int valorIngresado, int i, int opcion)
    {
        switch (opcion){
            case 1:
                catalogo[i].setNombre(datoIngresado);
                break;

            case 2:
                catalogo[i].setGenero(datoIngresado);
                break;

            case 3:
                catalogo[i].setAutor(datoIngresado);
                break;

            case 4:
                catalogo[i].setCantidad(valorIngresado);
                break;

            case 5:
                catalogo[i].setIdioma(datoIngresado);
                break;

            case 6:
                catalogo[i].setSinopsis(datoIngresado);
                break;

            case 7:
                catalogo[i].setEditorial(datoIngresado);
                break;

            case 8:
                catalogo[i].setAnioPubli(valorIngresado);
                break;

            default: System.out.println(t.ANSI_RED + "Opción ingresada no valida" + t.ANSI_RESET);
        }
    }

    public void eliminarLibro(int i){ this.catalogo[i] = null;}

    //METODO PARA TOMAR LIBRO Y RESTAR DEL INVENTARIO
    public void tomarLibro(int librosSolic, int i){
        if (catalogo[i].getCantidad() < librosSolic){

            System.out.println(t.ANSI_RESET + "No hay suficientes libros" + t.ANSI_RESET);

        }else if (librosSolic == 1) {

            catalogo[i].setCantidad(catalogo[i].getCantidad() - librosSolic);
            catalogo[i].setPrestados(catalogo[i].getPrestados() + librosSolic);

        }
    }
    //METODO PARA DEVOLVER LIBRO Y SUMAR AL INVENTARIO
    public void devolverLibro(int cantidadDev, int i){
        if (catalogo[i].getPrestados() < cantidadDev){

            System.out.println(t.ANSI_RED + "Cantidad devuelta no coincide" + t.ANSI_RESET);

        } else if (cantidadDev == 1){

            catalogo[i].setCantidad(catalogo[i].getCantidad() + cantidadDev);
            catalogo[i].setPrestados(catalogo[i].getPrestados() - cantidadDev);

        }
    }

}
