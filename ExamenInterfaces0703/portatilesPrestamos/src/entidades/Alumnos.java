// Sergio García Barrera
// Creado con Intellij IDEA JetBrains


package entidades;


public class Alumnos {

    public Alumnos(String nombre, String apellidos, String telefono, int idAlumno, String marca, String modelo, String idPortatil) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.idAlumno = idAlumno;
        this.marca = marca;
        this.modelo = modelo;
        this.idPortatil = idPortatil;
    }

    public Alumnos(){
        super();
    }
    private String nombre;
    private String apellidos;
    private String telefono;
    private int idAlumno;
    private String marca;
    private String modelo;
    private String idPortatil;


    // Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // -----------------
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    // -----------------
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    // -----------------
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    // -------------------------
    // PORTATILES
    // -------------------------
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    // ---------------------------------
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // ---------------------------------
    public String getIdPortatil() {
        return idPortatil;
    }

    public void setIdPortatil(String idPortatil) {
        this.idPortatil = idPortatil;
    }
    // ----------------- FIN -------------------------
    //Sobre escritura toString
    @Override
    public String toString() {
        return "Alumno creado correctamente.";
    }
}
