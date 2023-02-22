package DNI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dni msDni = new dni();
        List<dni> dniList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean cerrarMenu = false;
        int opcion;

        while(!cerrarMenu) {
            //Mostramos el menú
            mostrarMenu();
            System.out.println("Introduza la opción deseada: ");
            opcion = sc.nextInt();
            System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

            switch (opcion) {
                case 0:
                    cerrarMenu = true;
                    break;
                case 1:
                    dniList.add(msDni.CreacionDni());
                    System.out.println("DNI: " + dniList.get(dniList.size() - 1).toString());
                default:

            }
        }
    }
    static void mostrarMenu() {
        System.out.println("0. Salir");
        System.out.println("1. DNI");
    }
}
