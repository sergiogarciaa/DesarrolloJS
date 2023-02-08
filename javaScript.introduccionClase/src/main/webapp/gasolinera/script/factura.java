import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class factura {
    /*
     * Si no definimos ningún constructor por campos,
     * se puede utilizar el constructor vacío por defecto.
     * En el momento que se defina un constructor por campos
     * específico, si se quiere usar el constructor por defecto
     * será necesario definirlo en la clase de forma explícita.
     */

    public factura(String fecha, int litros, float importe, String DNI, String matricula) {
        super();
        this.fecha = fecha;
        this.litros = litros;
        this.importe = importe;
        this.DNI = DNI;
        this.matricula = matricula;
    }

    public factura() {
        super();
    }

    //Atributos
    /*
     * Modificador private: solo la misma clase podrá acceder a los
     * atributos de forma directa.
     */
    private String fecha;
    private int litros;
    private float importe;
    private String DNI;
    private String matricula;

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
    public int getlitros() {
        return litros;
    }
    public void setlitros(int litros) {
        this.litros = litros;
    }
    public float getimporte(){
        return importe;
    }
    public void setimporte(float importe) {
        this.importe = importe;
    }
    public String getDNI(){
        return DNI;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    public String getmatricula(){
        return matricula;
    }
    public void setmatricula(String matricula){
        this.matricula = matricula;
    }
    //Sobre escritura toString
    @Override
    public String toString() {
        return "Gasolinera Factura [fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + ", DNI=" + DNI + ", matricula=" + matricula + "]";
    }

    public factura RepostajeFactura(){
        Boolean ok = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime fecha = LocalTime.now();
        System.out.println("Echar Gasolina Normal: ");
        Scanner litrosSC = new Scanner(System.in);
        Scanner importeSC = new Scanner(System.in);
        Scanner dniSC = new Scanner(System.in);
        Scanner matriculaSC = new Scanner(System.in);

        int cLitros;
        int cImporte;
        String nDNI;
        String nMatricula;

        System.out.println("¿Cuántos litros quiere rellenar: ");
        cLitros = litrosSC.nextInt();
        cImporte = cLitros * 5 / 9;
        System.out.println(" Usted ha rellenado " + cLitros + " litros, el importe serían: " + cImporte + "€");
        System.out.println(" Introduzca su DNI: ");
        nDNI = dniSC.next();
        System.out.println("Introduzca la matrícula de su vehículo: ");
        nMatricula = matriculaSC.next();




        //Opción 1, constructor vacío
        factura gfVacio = new factura();
        gfVacio.setFecha(dtf.format(fecha));
        gfVacio.setlitros(cLitros);
        gfVacio.setimporte(cImporte);
        gfVacio.setDNI(nDNI);
        gfVacio.setmatricula(nMatricula);

        return gfVacio;
    }
}
