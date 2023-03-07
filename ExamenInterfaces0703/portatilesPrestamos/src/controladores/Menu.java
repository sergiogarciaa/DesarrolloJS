// Sergio García Barrera
// Creado con Intellij IDEA JetBrains

package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Alumnos;
import servicios.ImplementacioMenu;
import servicios.ImplementacionAlumnos;
import servicios.IntAlumnos;
import servicios.IntMenu;

public class Menu {

    public static void main(String[] args) {

        //Inicializa la interfaz de repostaje y menu
        IntAlumnos intA = new ImplementacionAlumnos();
        IntMenu menu = new ImplementacioMenu();
        //Listado de repostajes (BD)
        List<Alumnos> listaAlumnos = new ArrayList<>();
        int borrar;

        // Imprimir el menú por consola
        // Scanner con la opción del usuario
        Scanner sc = new Scanner(System.in);
        Scanner entradaOpcion = new Scanner(System.in);
        Boolean cerrarMenu = false;
        int opcion;
        while(!cerrarMenu) {
            //Mostramos el menú
            menu.mostrarMenu();
            System.out.println("Introduza la opción deseada: ");
            opcion = entradaOpcion.nextInt();
            System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

            switch (opcion) {
                case 0:
                    cerrarMenu = true;
                    break;
                case 1:
                    System.out.println(intA.crearAlumno(listaAlumnos));
                    break;
                case 2:
                    for(int i = 0; i<listaAlumnos.size(); i++){
                        System.out.println(listaAlumnos.get(i).getIdAlumno());
                    }
                    System.out.println("Qué usuario desea borrar [ID]: ");
                    borrar = sc.nextInt();
                    listaAlumnos.remove(borrar-1);
                    break;
                case 3:
                    for(int i = 0; i<listaAlumnos.size(); i++){
                        System.out.println("ID Alumno: " + listaAlumnos.get(i).getIdAlumno() + ", Nombre: " + listaAlumnos.get(i).getNombre() + ", Apellidos: " + listaAlumnos.get(i).getApellidos() + ", telefono: " + listaAlumnos.get(i).getTelefono() + ", ID Portatil: " + listaAlumnos.get(i).getIdPortatil());
                    }
                    break;
                default:

            }
        }

    }

}