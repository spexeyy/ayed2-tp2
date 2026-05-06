import java.util.ArrayList;

// Herencia: Estudiante extiende Persona, heredando nombre, apellido, edad y documento.
public class Estudiante extends Persona implements  MiembroUniversidad {

    private String carrera;
    private double promedio;
    private ArrayList<Materia> materias;

    public Estudiante(String nombre, int edad, String apellido,
                      String documento, String carrera,
                      double promedio, ArrayList<Materia> materias) {
        super(nombre, edad, apellido, documento);
        setCarrera(carrera);
        setPromedio(promedio);
        this.materias = materias;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.isBlank()) {
            throw new IllegalArgumentException("La carrera no puede ser nula o vacia");
        }

        this.carrera = carrera;
    }

    public void setPromedio(double promedio) {
        if (promedio < 0 || promedio > 10) {
            throw new IllegalArgumentException("El promedio  debe estar entre 0 y 10");
        }

        this.promedio = promedio;
    }

    public void agregarMateria(Materia m) {
        if (m == null) {
            throw new IllegalArgumentException("La materia no puede ser nula");
        }

        materias.add(m);
    }

    public void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("No esta matriculado en ninguna materia");
            return;
        }

        for (Materia m : materias) {
            System.out.println(m.getNombre());
        }
    }

    public double calcularPromedio() {
        if (materias.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for (Materia m : materias) {
            suma += m.getCalificacion();
        }

        return (suma / materias.size());
    }

    // Polimorfismo: sobrescribe toString y usa super.toString()
    @Override
    public String toString() {
        return super.toString() +
                ", carrera='" + carrera + '\'' +
                ", promedio=" + promedio +
                ", materias=" + materias +
                '}';
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Nombre: " + getNombre() + " " + getApellido() +
                ", Documento: " + getDocumento() +
                ", Edad: " + getEdad() +
                ", Rol: " + obtenerRol() +
                ", Carrera: " + carrera +
                ", Promedio: " + promedio;
    }
}
