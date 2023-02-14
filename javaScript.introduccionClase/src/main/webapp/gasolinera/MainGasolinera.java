package gasolinera;
/*Desarrollar una aplicación para la gestión de una gasolinera.
Hay que registrar cada vez que un cliente realiza un repostaje. Existen dos tipos de repostajes:
    NORMAL: se guarda la fecha, los litros y el importe.
    FACTURA: se guarda la fecha, los litros, el importe, el DNI del cliente y la matrícula del vehículo.
Al inicializar la aplicación, deberá aparecer un menú con las siguientes opciones:
    Repostaje normal.
    Repostaje factura.
    Ver todos los repostajes.*/

/*Siguiendo el ejercicio de Gestión de Gasolinera, buscaremos ampliar su funcionalidad.
    El listar repostajes se dividirá, según el usuario quiera ver los normales o los que incluyen factura.
    Se dará la posibilidad al usuario de eliminar los repostajes.
    Se dará la posibilidad al usuario de modificar un repostaje guardado.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGasolinera {
    public static void main(String[] args) {

        //Inicializamos el tipo cuenta
        normal gN = new normal();
        factura gF = new factura();
        //Listado de cuentas (BD)
        List < normal > listagN = new ArrayList < >();
        List < factura > listagF = new ArrayList < >();

        // Imprimir el menú por consola
        // Scanners
        Scanner entradaOpcion = new Scanner(System. in );
        Scanner respuesta = new Scanner(System. in );
        Scanner eliminar = new Scanner(System. in );
        Scanner nuevoLitro = new Scanner(System. in );
        Scanner modificar = new Scanner(System. in );
        String modify;
        boolean cerrarMenu = false;

        int opcion;
        while (!cerrarMenu) {
            //Mostrar menú
            mostrarMenu();

            System.out.println("Introduza la opción deseada: ");
            opcion = entradaOpcion.nextInt();
            System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

            switch (opcion) {
                case 1:
                    cerrarMenu = true;
                    break;
                case 2:
                    listagN.add(gN.RepostajeNormal());
                    System.out.println("Repostaje Correcto: " + listagN.get(listagN.size() - 1).toString());
                    break;
                case 3:
                    listagF.add(gF.RepostajeFactura());
                    System.out.println("Repostaje Correcto: " + listagF.get(listagF.size() - 1).toString());
                    break;
                case 4:
                    //Recorremos la lista
                    for (gasolinera.normal normal: listagN) {
                        System.out.println(normal);
                    }

                    // Eliminar repostaje
                    System.out.println("¿Desea eliminar algún repostaje? [Si/No]");
                    String borrar = eliminar.next();
                    borrar.toLowerCase();
                    if (borrar.equals("si")) {
                        System.out.println("Qué ID desea eliminar");
                        int id = respuesta.nextInt();
                        listagN.remove(id);
                    }

                    // Modificar Litros
                    System.out.println("Desea modificar los litros, se modificará tambien el coste de forma automatizada: [Si/No]");
                    borrar = eliminar.next();
                    borrar.toLowerCase();
                    if (borrar.equals("si")) {
                        System.out.println("Litros para modificar");
                        int nLitros = nuevoLitro.nextInt();
                        listagN.get(0).setlitros(nLitros);
                        listagN.get(0).setimporte((nLitros * 5) / 9);
                    }

                    break;
                case 5:
                    for (gasolinera.factura factura: listagF) {
                        System.out.println(factura);
                    }
                    System.out.println("¿Desea eliminar algún repostaje? [Si/No]");
                    String quitar = eliminar.next();
                    String a = quitar.toLowerCase();
                    if (a.equals("si")) {
                        System.out.println("Qué ID desea eliminar");
                        int id = respuesta.nextInt();
                        listagF.remove(id);
                    }
                    // Modificar registros
                    System.out.println("Desea modificar registros? [Si/No]");
                    borrar = eliminar.next();
                    borrar.toLowerCase();
                    if (borrar.equals("si")) {
                        System.out.println("Desea modificar los litros? [Si/No]");
                        modify = modificar.next();
                        modify.toLowerCase();
                        if (modify.equals("si")) {
                            System.out.println("Litros para modificar");
                            int nLitros = nuevoLitro.nextInt();
                            listagF.get(0).setlitros(nLitros);
                            listagF.get(0).setimporte((nLitros * 5) / 9);
                        }
                        System.out.println("Desea modificar el DNI? [Si/No]");
                        modify = modificar.next();
                        modify.toLowerCase();
                        if (modify.equals("si")) {
                            System.out.println("Introduzca un nuevo DNI");
                            modify = modificar.next();
                            listagF.get(0).setDNI(modify);
                        }
                        System.out.println("Desea modificar la matrícula? [Si/No]");
                        modify = modificar.next();
                        modify.toLowerCase();
                        if (modify.equals("si")) {
                            System.out.println("Introduzca una nueva matrícula");
                            modify = modificar.next();
                            listagF.get(0).setmatricula(modify);
                        }
                    }
                    break;
                default:

            }
        }

    }
    static void mostrarMenu() {
        System.out.println("1. Salir");
        System.out.println("2. Repostaje Normal");
        System.out.println("3. Repostaje Factura");
        System.out.println("4. Ver Respostaje Normal");
        System.out.println("5. Ver Respostaje Factura");
    }
}