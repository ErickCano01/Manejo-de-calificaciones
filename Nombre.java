public class Nombre {
    private String nombre1;
    private String nombre2;
    private String apellido_paterno;
    private String apellido_materno;

    // Constructor con 1 nombre y 2 apellidos
    public Nombre(String nombre1, String apellido_paterno, String apellido_materno){
        this.nombre1 = nombre1;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    // Constructor con 2 nombres y 2 apellidos
    public Nombre(String nombre1, String nombre2, String apellido_paterno, String apellido_materno){
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellidoPaterno() {
        return apellido_paterno;
    }

    public void setApellidoPaterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellidoMaterno() {
        return apellido_materno;
    }

    public void setApellidoMaterno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombreCompleto() {
        String nombreCompleto = "";
        if (nombre1 != null) {
            nombreCompleto += nombre1;
            if (nombre2 != null) {
                nombreCompleto += " " + nombre2;
            }
        }
        if (apellido_paterno != null) {
            nombreCompleto += " " + apellido_paterno;
        }
        if (apellido_materno != null) {
            nombreCompleto += " " + apellido_materno;
        }
        return nombreCompleto.trim();
    }
}
