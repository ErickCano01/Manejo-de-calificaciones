import java.util.ArrayList;

class AlumnoFactory {

    public static ArrayList<Alumno> crearAlumnos(String[] calificacionesStr) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        double[] calificaciones1 = obtenerCalificaciones(calificacionesStr, 0);
        double[] calificaciones2 = obtenerCalificaciones(calificacionesStr, 7);
        double[] calificaciones3 = obtenerCalificaciones(calificacionesStr, 14);
        
        alumnos.add(new Alumno(new Nombre("Erick","Eduardo","Cano", "Osorio"), "1279386", calificaciones1));
        alumnos.add(new Alumno(new Nombre("pepito", "lalo", "gonzalez"), "1234567", calificaciones2));
        alumnos.add(new Alumno(new Nombre("pancho", "matiaz", "Perez"), "9023457", calificaciones3));
        
        return alumnos;
    }
    
    private static double[] obtenerCalificaciones(String[] calificacionesStr, int inicio) {
        double[] calificaciones = new double[7];
        for (int i = 0; i < 7; i++) {
            try {
                // para quitar el Bom https://stackoverflow.com/questions/21891578/removing-bom-characters-using-java
                String valor = calificacionesStr[inicio + i];
                if (valor.startsWith("\uFEFF")) {
                    valor = valor.substring(1);
                }
                
                calificaciones[i] = Double.parseDouble(valor.trim());
            } catch (NumberFormatException e) {
                //para ver que porque no convertia el valor en double
                throw new NumberFormatException("Error al convertir la cadena '" + calificacionesStr[inicio + i] + "' en un número en la posición " + (inicio + i + 1) + ". Valor exacto: '" + calificacionesStr[inicio + i] + "'");
            }
        }
        return calificaciones;
    }
}