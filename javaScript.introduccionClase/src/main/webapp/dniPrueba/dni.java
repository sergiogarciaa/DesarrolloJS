package DNI;

import java.util.Scanner;

public class dni {
    public dni(int numero, char letra) {
        super();
        this.numero = numero;
        this.letra = letra;
    }
    public dni() {
        super();
    }
    private int numero;
    private char letra;


    // GETTER AND SETTERS
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    // ---------------
    public char getLetra() {
        return letra;
    }
    public void setLetra(char letra) {
        this.letra = letra;
    }
    // FIN GETTER AND SETTER
    //Sobre escritura toString
    @Override
    public String toString() {
        return "[Numero = " + numero + ", letra=" + letra + ", composición = " + numero + "-" + letra +"]";
    }


    public dni CreacionDni(){
        boolean ok = false;
        Scanner sc = new Scanner(System.in);
        int nDni = 1;
        char lDniUsuario = '-';
        char lDniGenerada;
        String pista;
        char[] calculoLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
            // PEDIMOS LOS DATOS
            System.out.println("Introduzca un número [Longitud de 8 números]: ");
            nDni = sc.nextInt();
            System.out.println("Introduzca una letra para el DNI [Debe ser en Mayúsculas]: ");
            lDniUsuario = sc.next().charAt(0);
            // CONTROL DE ERROR NUMERO DNI
            while (nDni < 0 || nDni > 99999999){
                System.err.println("El número introducido no es válido");
                System.out.println("Introduzca un número [Longitud de 8 números]: ");
                nDni = sc.nextInt();
            }

                // CALCULO DE LETRA Y CONTROL DE ERROR.
                lDniGenerada = (char) (nDni % 23);
                lDniGenerada = calculoLetra[lDniGenerada];

               while (lDniGenerada != lDniUsuario){
                    System.err.println("La letra que ha indicado no es correcta");
                    System.out.println("Quiere saber la letra?: ");
                    pista = sc.next().toLowerCase();
                           if (pista.equals("si")) {
                               System.out.println(lDniGenerada);
                           }
                    System.out.println("Vuelve a introducir la letra");
                    lDniUsuario = sc.next().charAt(0);
                }
                    System.out.println("La letra introducida y el número son correctos.");




        //Opción 1, constructor vacío
        dni dniVacio = new dni();
        dniVacio.setNumero(nDni);
        dniVacio.setLetra(lDniUsuario);
        return dniVacio;
    }
}
