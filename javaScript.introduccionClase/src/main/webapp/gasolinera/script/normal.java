package gasolinera;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class normal {
    /*
     * Si no definimos ningún constructor por campos,
     * se puede utilizar el constructor vacío por defecto.
     * En el momento que se defina un constructor por campos
     * específico, si se quiere usar el constructor por defecto
     * será necesario definirlo en la clase de forma explícita.
     */



    public normal(String fecha, int litros, float importe, int id) {
        super();
        this.fecha = fecha;
        this.litros = litros;
        this.importe = importe;
        this.id = id;
    }


    public normal() {
        super();
    }

    //Atributos
    /*
     * solo la misma clase podrá acceder a los
     * atributos de forma directa.
     */
    private String fecha;
    private int litros;
    private float importe;
    private int id;

    //Getters y Setters
    /*
     * Se utilizar para que software externo a la clase pueda
     * tener acceso a los atributos.
     */

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    // ---------------
    public int getlitros() {
        return litros;
    }
    public void setlitros(int litros) {
        this.litros = litros;
    }
    // ---------------
    public float getimporte(){
        return importe;
    }
    public void setimporte(float importe) {
        this.importe = importe;
    }
    // ---------------
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    // ---------------
    //Sobre escritura toString
    @Override
    public String toString() {
        return "Gasolinera Normal [fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + ", ID = " + id + "]";
    }

    public normal RepostajeNormal(){
        Boolean ok = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime fecha = LocalTime.now();
        System.out.println("Echar Gasolina Normal: ");
        Scanner litrosSC = new Scanner(System.in);
        Scanner importeSC = new Scanner(System.in);
        int cLitros;
        int cImporte;
        System.out.println("¿Cuántos litros quiere rellenar: ");
        cLitros = litrosSC.nextInt();
        cImporte = cLitros * 5 / 9;
        System.out.println(" Usted ha rellenado " + cLitros + " litros, el importe serían: " + cImporte + "€");



        //Opción 1, constructor vacío
        normal gnVacio = new normal();
        gnVacio.setFecha(dtf.format(fecha));
        gnVacio.setlitros(cLitros);
        gnVacio.setimporte(cImporte);
        gnVacio.setid(id++);
        return gnVacio;
    }
}