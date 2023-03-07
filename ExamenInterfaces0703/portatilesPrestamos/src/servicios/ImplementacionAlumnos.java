// Sergio García Barrera
// Creado con Intellij IDEA JetBrains


package servicios;

import java.util.List;
import java.util.Scanner;
import entidades.Alumnos;

public class ImplementacionAlumnos implements IntAlumnos {

    // Configuracion de crear Alumno
    @Override
    public List<Alumnos> crearAlumno(List<Alumnos> listaAntAlumnos) {
        Alumnos alumnos = new Alumnos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca su nombre: ");
        alumnos.setNombre(sc.next());
        System.out.println("Introduzca su apellido: ");
        alumnos.setApellidos(sc.next());
        System.out.println("Introduzca su teléfono ");
        alumnos.setTelefono(sc.next());
        System.out.println("Introduzca la márca del portatil");
        alumnos.setMarca(sc.next());
        System.out.println("Introduzca el modelo de portatil");
        alumnos.setModelo(sc.next());

        // Crear ID Portatil
        if(alumnos.getMarca().length() < 3 || alumnos.getModelo().length() < 3){
            alumnos.setIdPortatil(alumnos.getMarca() + "-" + alumnos.getModelo());
        }
        else{
            alumnos.setIdPortatil(alumnos.getMarca().substring(0,3) + "-" + alumnos.getModelo().substring(0,3));
        }


        alumnos.setIdAlumno(calculoNuevoId(listaAntAlumnos));
        listaAntAlumnos.add(alumnos);
        return listaAntAlumnos;
    }

    private int calculoNuevoId(List<Alumnos> listaIdAlumnos) {
        int auxiliar = 0;

        for (int i = 0; i < listaIdAlumnos.size(); i++) {

            int j = listaIdAlumnos.get(i).getIdAlumno();
            if (auxiliar < j) {
                auxiliar = j;
            }

        }
        return auxiliar + 1;
    }

}

