import java.util.Objects;

// Clase base abstracta: define los atributos comunes a Estudiante, Profesor y Personal.
public abstract class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private final String documento;

    public Persona(String nombre, int edad,
                   String apellido, String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacio");
        }

        setNombre(nombre);
        setEdad(edad);
        setApellido(apellido);
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        this.edad = edad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }

        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacio");
        }

        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{"
                + "nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", edad=" + edad
                + ", documento='" + documento + '\''
                + '}';
    }

    // equals y hashCode usan el documento como identificador unico.
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Persona persona))
            return false;
        return Objects.equals(documento, persona.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
