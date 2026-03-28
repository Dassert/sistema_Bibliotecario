package servicio;

import datos.RepositorioLibros;
import modelo.Libro;

public class ServicioLibros extends Servicio{

    //Inyeccion de dependencias
    RepositorioLibros repoL;
    public ServicioLibros(RepositorioLibros nRepoL){ this.repoL = nRepoL; }

    public Libro[] obtenerLibros(){ return repoL.obtenerLibros(); }
    public Libro obtener1Libro(int i){ return repoL.obtener1Libro(i); }

    //Metodo para agregar un nuevo libro
    public void registrarLibro(){
        for (i = 0; i < obtenerLibros().length; i++) {
            if (obtener1Libro(i) == null) {
                System.out.println("\n=== Agregar libro ===");
                System.out.println(">Ingrese 0 para salir");
                System.out.println("Para un correcto registro de libro ingrese los siguientes datos: ");
                System.out.print("Titulo: ");
                String nNombre = t.scanner.nextLine();

                if (nNombre.equals("0")){System.out.println("Saliendo...");return;}

                System.out.print("Editorial: ");
                String nEditorial = t.scanner.nextLine();
                System.out.print("Genero: ");
                String nGenero = t.scanner.nextLine();
                System.out.print("Autor: ");
                String nAutor = t.scanner.nextLine();
                System.out.print("Año: ");
                int nAnioPubli = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Cantidad: ");
                int nCantidad = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Idioma");
                String nIdioma = t.scanner.nextLine();
                System.out.print("Sinopsis");
                String nSinopsis = t.scanner.nextLine();
                int nId = i + 1;

                repoL.agregarLibro(nId, nNombre, nGenero, nAutor, nCantidad, nIdioma, nSinopsis, nEditorial, nAnioPubli, i);

                System.out.println(t.ANSI_GREEN + "Registro exitoso!!" + t.ANSI_RESET);

                i = obtenerLibros().length;

            } else if (i == obtenerLibros().length - 1) {

                System.out.println(t.ANSI_RED + "Catalogo lleno..." + t.ANSI_RESET);

            }
        }
    }

    //Metodo para editar el libro
    public void editarLibro(){
        do{
            System.out.println("\n=== Editar libro ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID para editar el libro: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (i = 0; i < obtenerLibros().length; i++) {
                if (obtener1Libro(i) != null && obtener1Libro(i).getId() == idIngresado) {
                    do{
                        System.out.println("\n=== Editar libro ===");
                        System.out.println("1.- Nombre: " + obtener1Libro(i).getNombre());
                        System.out.println("2.- Genero: " + obtener1Libro(i).getGenero());
                        System.out.println("3.- Autor: " + obtener1Libro(i).getAutor());
                        System.out.println("4.- Cantidad: " + obtener1Libro(i).getCantidad());
                        System.out.println("5.- Idioma: " + obtener1Libro(i).getIdioma());
                        System.out.println("6.- Sinopsis: " + obtener1Libro(i).getSinopsis());
                        System.out.println("7.- Editorial: " + obtener1Libro(i).getEditorial());
                        System.out.println("8.- Año de publicación: " + obtener1Libro(i).getAnioPubli());
                        do {
                            System.out.println("\n>Ingrese 0 para salir");
                            System.out.print(">Ingrese opción a editar: ");

                            opcionIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();

                            if (opcionIng == 0) {System.out.println("Saliendo...");return;

                            } else if (opcionIng < 0 || opcionIng > 9) {System.out.println(t.ANSI_RED + "Opción invalida, vuelva a intentar" + t.ANSI_RESET);}

                        }while(opcionIng < 0 || opcionIng > 9);

                        System.out.println("\n>Ingrese 0 para salir");
                        System.out.print(">Ingrese la correción: ");

                        if(opcionIng == 4 || opcionIng == 8)
                        {

                            valorIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();
                            datoIng = "0";

                        }else{datoIng = t.scanner.nextLine(); valorIng = 0;}

                        if (datoIng.equals("0") && valorIng == 0) { System.out.println("Saliendo..."); return; }

                        repoL.modificarLibro(datoIng,valorIng,i,opcionIng);

                    }while (opcionIng != 0);

                } else if (i == obtenerLibros().length - 1){System.out.println(t.ANSI_RED + "ID ingresado no encontrado" + t.ANSI_RESET);}

            }
        }while(idIngresado != 0);
    }

    //Metodo para eliminar un libro
    public void eliminarLibro() {
        do {
            System.out.println("\n=== Eliminar libro ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID para eliminar el libro: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (int i = 0; i < obtenerLibros().length; i++) {
                //verifica que el id a eliminar existe en el catalogo
                if (obtener1Libro(i) != null && idIngresado == obtener1Libro(i).getId()) {

                    System.out.println(t.ANSI_GREEN + "Eliminado correctamente..." + t.ANSI_RESET);
                    repoL.eliminarLibro(i);
                    i = obtenerLibros().length;

                } else if (i == obtenerLibros().length - 1) {

                    System.out.println(t.ANSI_RED + "Numero de ID no valido." +  t.ANSI_RESET);

                }
            }

        }while (idIngresado == 0);
    }

    //Metodo abstracto para mostrar datos
    @Override
    public void mostrarDatos(){
        for (i = 0; i < obtenerLibros().length; i++){
            if (obtener1Libro(i) != null) {
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Nombre: "+ obtener1Libro(i).getNombre());
                System.out.println("Genero: "+ obtener1Libro(i).getGenero());
                System.out.println("Autor: "+ obtener1Libro(i).getAutor());
                System.out.println("Cantidad: "+ obtener1Libro(i).getCantidad());
                System.out.println("Idioma: "+ obtener1Libro(i).getIdioma());
                System.out.println("Sinopsis: "+ obtener1Libro(i).getSinopsis());
                System.out.println("Editorial: "+ obtener1Libro(i).getEditorial());
                System.out.println("Año de publicación: "+ obtener1Libro(i).getAnioPubli());
                System.out.println("ID: "+ obtener1Libro(i).getId());
            }
        }
    }

    //Muestra los datos de todos los libros
    public void mostrarDatosLib(){
        for (i = 0; i < obtenerLibros().length; i++){
            if (obtener1Libro(i) != null) {
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Nombre: "+ obtener1Libro(i).getNombre());
                System.out.println("Genero: "+ obtener1Libro(i).getGenero());
                System.out.println("Autor: "+ obtener1Libro(i).getAutor());
                System.out.println(t.ANSI_GREEN + "Cantidad: " + t.ANSI_RESET + obtener1Libro(i).getCantidad());
                System.out.println(t.ANSI_YELLOW + "Cantidad prestada: " + t.ANSI_RESET + obtener1Libro(i).getPrestados());
                System.out.println("Idioma: "+ obtener1Libro(i).getIdioma());
                System.out.println("Sinopsis: "+ obtener1Libro(i).getSinopsis());
                System.out.println("Editorial: "+ obtener1Libro(i).getEditorial());
                System.out.println("Año de publicación: "+ obtener1Libro(i).getAnioPubli());
                System.out.println("ID: "+ obtener1Libro(i).getId());
            }
        }
    }


}
