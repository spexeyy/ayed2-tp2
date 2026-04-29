import java.util.ArrayList;

public class Carrera {

    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Carrera(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }

        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEstudiante(Estudiante e) {
        if (e == null) {
            throw new IllegalArgumentException("El estudiante no puede ser null");
        }

        estudiantes.add(e);
    }

    public void listarEstudiantes() {
        for (Estudiante e : estudiantes) {
            System.out.println("Nombre: " + e.getNombre() + " | " + "Apellido: " + e.getApellido());
        }
    }

    public void buscarEstudiante(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser null");
        }

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes");
            return;
        }

        boolean encontrado = false;

        for (Estudiante e : estudiantes) {
            if (e.getNombre().contains(texto)) {
                System.out.println("Nombre: " + e.getNombre() + " | Apellido: " + e.getApellido() + " | Carrera: " + e.getCarrera());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado un alumno con ese nombre");
        }
    }
}