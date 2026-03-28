package servicio;

import datos.RepositorioAdmin;
import modelo.Administrador;

public class ServicioAdmin extends Servicio{
    //Inyeccion de dependencias
    RepositorioAdmin repoAdmin;
    public ServicioAdmin(RepositorioAdmin repoAdmin){this.repoAdmin = repoAdmin;}

    public Administrador obtenerAdmin(){return repoAdmin.obtenerAdmin();}

    //Metodo para que el admin pueda editar los datos de cualquier empleado
    public void editarAdmin(){
        do{
            System.out.println("\n=== Editar perfil ===");
            System.out.println("1.- Nombre de usuario: " + obtenerAdmin().getNombreUsuario());
            System.out.println("2.- Contraseña: ********");
            System.out.println("3.- Dirección: " + obtenerAdmin().getDireccion());
            System.out.println("4.- Nombre: " + obtenerAdmin().getNombre());
            System.out.println("5.- Apellido Paterno: " + obtenerAdmin().getApellidoPaterno());
            System.out.println("6.- Apellido Materno: " + obtenerAdmin().getApellidoMaterno());
            System.out.println("7.- Día de nacimiento: " + obtenerAdmin().getDiaNac());
            System.out.println("8.- Mes de nacimiento: " + obtenerAdmin().getMesNac());
            System.out.println("9.- Año de nacimiento: " + obtenerAdmin().getAnioNac());
            System.out.println("10.- Sexo: " + obtenerAdmin().getSexo());
            System.out.println("11.- CURP: " + obtenerAdmin().getCurp());
            System.out.println("12.- RFC: " + obtenerAdmin().getRfc());
            System.out.println("13.- Sueldo: " + obtenerAdmin().getSueldo());

            do {
                System.out.println("\n>Ingrese 0 para salir");
                System.out.print(">Ingrese opción a editar: ");

                opcionIng = t.leerEntero(t.scanner);
                t.scanner.nextLine();

                if (opcionIng == 0) {System.out.println("Saliendo...");return;

                } else if (opcionIng < 0 || opcionIng > 13) {System.out.println(t.ANSI_RED + "Opción invalida, vuelva a intentar" + t.ANSI_RESET);}

            }while(opcionIng < 0 || opcionIng > 13);

            System.out.println("\n>Ingrese 0 para salir");
            System.out.print(">Ingrese la correción: ");

            if(opcionIng >= 7 && opcionIng <= 9 || opcionIng == 13)
            {
                valorIng = t.leerEntero(t.scanner);
                t.scanner.nextLine();

            }else{datoIng = t.scanner.nextLine();}

            if (datoIng.equals("0") && valorIng == 0) { System.out.println("Saliendo..."); return; }

            repoAdmin.modificarAdmin(datoIng,valorIng,opcionIng);

        }while (opcionIng != 0);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Nombre de usuario: " + obtenerAdmin().getNombreUsuario());
        System.out.println("Nombre: "+ obtenerAdmin().getNombre());
        System.out.println("Apellido paterno: "+ obtenerAdmin().getApellidoPaterno());
        System.out.println("Apellido materno: "+ obtenerAdmin().getApellidoMaterno());
        System.out.println("Dia de nacimiento: "+ obtenerAdmin().getDiaNac());
        System.out.println("Mes de nacimiento: "+ obtenerAdmin().getMesNac());
        System.out.println("Año de nacimiento: "+ obtenerAdmin().getAnioNac());
        System.out.println("Sexo: "+ obtenerAdmin().getSexo());
        System.out.println("CURP: "+ obtenerAdmin().getCurp());
        System.out.println("RFC: " + obtenerAdmin().getRfc());
        System.out.println("Dirección: "+ obtenerAdmin().getDireccion());
        System.out.println("Año de registro: "+ obtenerAdmin().getAnioRegistro());
        System.out.println("Numero de empleado: " + obtenerAdmin().getNumEmp());
    }
}
