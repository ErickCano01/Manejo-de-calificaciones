import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        String archivo = "practica3.2.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] calificacionesStr = linea.split(",");
                if (calificacionesStr.length < 21) {
                    throw new NumException("El número de calificaciones en la línea del archivo CSV es incorrecto");
                }

                ArrayList<Alumno> alumnos = AlumnoFactory.crearAlumnos(calificacionesStr);
                
                
                for (Alumno alumno : alumnos) {
                    alumno.mostrarInformacion();
                }

                guardarInformacion(alumnos);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NumException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void guardarInformacion(ArrayList<Alumno> alumnos) {
        File archivo = new File("guardado.txt");
        if (!archivo.exists()) {
            try (FileWriter escribir = new FileWriter(archivo, true)) {
                for (Alumno alumno : alumnos) {
                    escribir.write("Nombre del alumno: " + alumno.getNombre().getNombreCompleto() + "\n");
                    escribir.write("Matrícula: " + alumno.getMatricula() + "\n");
                    escribir.write("Calificaciones:" + "\n");
                    for (int i = 0; i < alumno.getCalificaciones().length; i++) {
                        escribir.write("   Calificación " + (i + 1) + ": " + alumno.getCalificaciones()[i] + "\n");
                    }
                    escribir.write("Promedio General: " + alumno.getPromedioGeneral() + "\n");
                    escribir.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
