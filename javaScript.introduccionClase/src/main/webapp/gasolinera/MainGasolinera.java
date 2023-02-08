/*Desarrollar una aplicación para la gestión de una gasolinera.
Hay que registrar cada vez que un cliente realiza un repostaje. Existen dos tipos de repostajes:
        NORMAL: se guarda la fecha, los litros y el importe.
        FACTURA: se guarda la fecha, los litros, el importe, el DNI del cliente y la matrícula del vehículo.
Al inicializar la aplicación, deberá aparecer un menú con las siguientes opciones:
        Repostaje normal.
        Repostaje factura.
        Ver todos los repostajes.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGasolinera {
    public static void main(String[] args) {

        //Inicializar el tipo cuenta
        normal gN = new normal();
        factura gF = new factura();
        //Listado de cuentas (BD)
        List<normal> listagN = new ArrayList<>();
        List<factura> listagF = new ArrayList<>();

        // Imprimir el menú por consola
        // Scanner con la opción del usuario
        Scanner entradaOpcion = new Scanner(System.in);
        Boolean cerrarMenu = false;

        int opcion;
        while(!cerrarMenu) {
            //Mostramos el menú
            mostrarMenu();
            System.out.println("Introduza la opción deseada: ");
            opcion = entradaOpcion.nextInt();
            System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

            switch (opcion) {
                case 1:
                    listagN.add(gN.RepostajeNormal());
                    System.out.println("Repostaje Correcto: " + listagN.get(listagN.size()-1).toString());
                    break;
                case 2:
                    listagF.add(gF.RepostajeFactura());
                    System.out.println("Repostaje Correcto: " + listagF.get(listagF.size()-1).toString());
                    break;
                /*case 3:
                    //llamams al método
                    listagN = gN.VerRepostajes(listagN);
                    break;*/
                case 4:
                    cerrarMenu = true;
                    break;
                default:

            }
        }

    }
    static void mostrarMenu() {
        System.out.println("1. Repostaje Normal");
        System.out.println("2. Repostaje Factura");
        System.out.println("3. Ver todos los repostajes");
        System.out.println("4. Salir");
    }
}