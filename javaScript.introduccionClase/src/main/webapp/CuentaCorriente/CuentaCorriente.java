/*Se deberá diseñar una clase llamada "CuentaCorriente" que almacenará los siguientes datos (atributos de la case): dni (un campo alfanumérico), nombre del titular (un campo tipo texto) y el saldo (tipo numérico con decimales).
Además de las propiedades indicadas anteriormente, deberá tener una serie de acciones (métodos); todos ellos públicos (public):

crearCuenta: se le pasará como parámetro el dni y el nombre del titular, siendo el saldo inicial 0,0.
ingresarDinero: se pasará como parámetro la cantidad a ingresar y se sumará al saldo actual.
mostrarInformación: mostrará la información disponible de la cuenta corriente.
sacarDinero: se pasará como parámetro la cantidad de dinero que se quiere sacar y se devolverá si hay suficiente saldo para realizar la operación.
*/


package CuentaCorriente;

import java.util.List;
import java.util.Scanner;

/**
 * Modelo de las cuentas corrientes a gestionar
 */
public class CuentaCorriente {

    /*
     * Si no definimos ningún constructor por campos,
     * se puede utilizar el constructor vacío por defecto.
     * En el momento que se defina un constructor por campos
     * específico, si se quiere usar el constructor por defecto
     * será necesario definirlo en la clase de forma explícita.
     */

    public CuentaCorriente(String dni, String nombreTitular, double saldo) {
        super();
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }

    public CuentaCorriente() {
        super();
    }

    //Atributos
    /*
     * Modificador private: solo la misma clase podrá acceder a los
     * atributos de forma directa.
     */

    private String dni;
    private String nombreTitular;
    private double saldo;

    //Getters y Setters
    /*
     * Se utilizar para que software externo a la clase pueda
     * tener acceso a los atributos.
     */

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Sobre escritura toString
    @Override
    public String toString() {
        return "CuentaCorriente [dni=" + dni + ", nombreTitular=" + nombreTitular + ", saldo=" + saldo + "]";
    }

    //Métodos
    public CuentaCorriente crearCuenta () {

        System.out.println("CREAR CUENTA: ");
        Scanner entradaDni = new Scanner(System.in);
        Scanner entradaNombreTitular = new Scanner(System.in);
        String opcionEntradaDni;
        String opcionEntradaNombreTitular;
        System.out.println("Introduzca el DNI del titular [EJ: 73298749-P]: ");
        opcionEntradaDni = entradaDni.next();
        System.out.println("Introduzca el nombre completo del titular: ");
        opcionEntradaNombreTitular = entradaNombreTitular.next();

        System.out.println("----------------------------------------------------------------------");

        //constructor vacío para crear cuenta
        CuentaCorriente cccVacio = new CuentaCorriente();
        cccVacio.setDni(opcionEntradaDni);
        cccVacio.setNombreTitular(opcionEntradaNombreTitular);
        cccVacio.setSaldo(0);
        return cccVacio;
    }

    public List<CuentaCorriente> ingresoCuenta(List<CuentaCorriente> bd) { // bd es la lista del MAIN la cual guarda la informacion de usuarios
        System.out.println("INGRESO CUENTA: ");
        //pedir dni
        Scanner entradaDni = new Scanner(System.in);
        System.out.println("Introduzca el DNI de la cuenta: ");
        String opcionEntradaDni = entradaDni.next();
        //para buscar la cuenta lo haremos con un foreach con nombre cuenta que recorrera bd (bd es la lista del main)
        // El contador sumará hasta encontrar el usuario que se busca.
        int contador = 0;
        boolean esEncontrado = false;
        for(CuentaCorriente cuenta: bd) {
            String dniBd = cuenta.getDni();
            if(dniBd.equals(opcionEntradaDni)) {
                esEncontrado = true;
                break;
            }
            // Empieza a buscar el usuario una vez comprobado que ese usuario existe
            contador++;
        }

        if(esEncontrado) {
            System.out.println("Indique saldo a ingresar: ");
            Scanner entradaIngreso = new Scanner(System.in);
            double ingreso = entradaIngreso.nextDouble();
            double saldoActual = bd.get(contador).getSaldo();
            bd.get(contador).setSaldo(saldoActual+ingreso);
            double saldoNuevo = saldoActual+ingreso;
            System.out.println("Saldo anterior: " +saldoActual+ " Saldo ingresado: " +ingreso);
            System.out.println("El saldo actual es " + saldoNuevo);
        }else {
            System.err.println("No existe cuenta asociada a ese DNI: "+opcionEntradaDni);
            return bd;
        }
        System.out.println("----------------------------------------------------------------------");
        return bd;
    }

    public List<CuentaCorriente> retiradaCuenta(List<CuentaCorriente> bd) { // bd es la lista del MAIN la cual guarda la informacion de usuarios
        System.out.println("RETIRADA CUENTA: ");
        //pedir dni
        Scanner lectorDni = new Scanner(System.in);
        System.out.println("Introduzca el DNI de la cuenta: ");
        String dniIntroducido = lectorDni.next();
        //para buscar la cuenta lo haremos con un foreach con nombre cuenta que recorrera bd (bd es la lista del main)
        // El contador sumará hasta encontrar el usuario que se busca.
        int contador = 0;
        boolean esEncontrado = false;
        for(CuentaCorriente cuenta: bd) {
            String dniBd = cuenta.getDni();
            if(dniBd.equals(dniIntroducido)) {
                esEncontrado = true;
                break;
            }
            // Empieza a buscar el usuario una vez comprobado que ese usuario existe
            contador++;
        }

        if(esEncontrado) {
            System.out.println("Dispone actualmente de: " + bd.get(contador).getSaldo() + " €");
            System.out.println("¿Cuánto desea retirar?: ");
            Scanner retiraSaldo = new Scanner(System.in);
            double retirada = retiraSaldo.nextDouble();
            // Si el saldo de la cuenta es 0 no puede retirar
            if (bd.get(contador).getSaldo() <= 0){
                System.err.println("No tiene saldo suficiente en la cuenta");
            }
           // Si es mayor que 0 puede retirar
            else if(bd.get(contador).getSaldo() > 0){
                // Si la cantidad que quiere retirar es mayor que el saldo de la cuenta no puede retirar
                if (retirada > bd.get(contador).getSaldo()){
                    System.err.println("No puede retirar más dinero del que tiene");
                }
                // Si la cantidad que quiere retirar está dentro del margen del saldo se puede
                else {
                    double saldoActual = bd.get(contador).getSaldo();
                    bd.get(contador).setSaldo(saldoActual - retirada);
                    double saldoNuevo = saldoActual - retirada;
                    System.out.println("Saldo anterior: " + saldoActual + " Saldo retirado: " + retirada);
                    System.out.println("El saldo actual es " + saldoNuevo);
                }
            }
        }
        //
        else {
            System.err.println("No existe cuenta asociada a ese DNi");
            return bd;
        }
        System.out.println("----------------------------------------------------------------------");
        return bd;
    }

    public List<CuentaCorriente> MostrarinformacionList(List<CuentaCorriente> bd){
        Scanner lector = new Scanner(System.in);
        System.out.println("MOSTRAR INFORMACION:");
        System.out.println("-------------------");
        System.out.println("Introduzca su DNI");
        String nIntroducido = lector.next();
        // Pediremos el DNI para mostrar la informacion de esa cuenta
        boolean encontrado = false;
        // Con el contador indicamos que usuario es, si es el primero, segundo, lo que tarde en encontrarlo
        int contador = 0;
        for (CuentaCorriente info : bd) {
            String guardaDni = info.getDni();
            if (guardaDni.equals(nIntroducido)) {
                encontrado = true;
                break;
            }
            contador++;
        }
        if(encontrado){
            // le pasamos el contador para que sepa de quien queremos la informacion
                System.out.println("Nombre del titular: " + bd.get(contador).getNombreTitular());
                System.out.println("DNI: " + bd.get(contador).getDni());
                System.out.println("Saldo: " + bd.get(contador).getSaldo());
        }
        else{
            System.err.println("No existe cuenta asociada a ese DNI: " + nIntroducido);
            return bd;
        }
        System.out.println("----------------------------------------------------------------------");
        return bd;
    }

}