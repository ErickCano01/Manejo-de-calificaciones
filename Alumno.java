public class Alumno{
    private Nombre nombre;
    private String matricula;
    private double[] calificaciones;
    private double promedioGeneral;

    public Alumno(Nombre nombre, String matricula, double[] calificaciones){
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificaciones = calificaciones;
        this.promedioGeneral = calcularPromedio(calificaciones);
    }
    
    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
        this.promedioGeneral = calcularPromedio(calificaciones);
    }

    public double getPromedioGeneral() {
        return promedioGeneral;
    }

    public double calcularPromedio(double[] calificaciones){
        double suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
        }
        return suma / calificaciones.length;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre del alumno: " + nombre.getNombreCompleto());
        System.out.println("Matrícula: " + matricula);
        System.out.println("Calificaciones:");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("   Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio General: " + promedioGeneral);
    }
}