// Sergio García Barrera
// Creado con Intellij IDEA JetBrains


package servicios;

public class ImplementacioMenu implements IntMenu{
        @Override
        public void mostrarMenu() {
            System.out.println("0. Salir");
            System.out.println("1. Matrícula de alumno");
            System.out.println("2. Borrar alumno");
            System.out.println("3. Listar alumnos con su portatil asignado");
        }

    }
