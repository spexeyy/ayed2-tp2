import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private String direccion;
    private ArrayList<Estudiante> estudiantes;

    public Universidad(String nombre, String direccion, ArrayList<Estudiante> estudiantes) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacio o nulo");
        }

        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La direccion no puede ser vacia o nula");
        }

        if (estudiantes == null) {
            throw new IllegalArgumentException("La lista de estudiantes no puede ser nula");
        }

        this.nombre = nombre;
        this.direccion = direccion;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
