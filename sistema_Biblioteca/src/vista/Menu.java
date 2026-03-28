package vista;

import vista.inicioDeSesion.InicioSesion;

public class Menu {
    //Inyeccion de dependencias
    InicioSesion menuCompleto;

    public Menu(InicioSesion in) {
        this.menuCompleto = in;
    }

    //Metodo donde de encuentra todos los menus para ser ejecutado en el Main
    public void ejecutarMenu() {
        menuCompleto.ejecutarMenu();
    }
}