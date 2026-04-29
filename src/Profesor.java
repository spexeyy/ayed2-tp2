import java.util.ArrayList;

// Herencia: Profesor extiende Persona
public class Profesor extends Persona {

    private String especialidad;
    private int aniosExperiencia;
    private ArrayList<Materia> materiasAsignadas;

    public Profesor(String nombre, int edad, String apellido,
                    String documento, String especialidad,
                    int aniosExperiencia) {
        super(nombre, edad, apellido, documento);
        setEspecialidad(especialidad);
        setAniosExperiencia(aniosExperiencia);
        this.materiasAsignadas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public ArrayList<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede ser nula o vacía");
        }

        this.especialidad = especialidad;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < 0) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
        }

        this.aniosExperiencia = aniosExperiencia;
    }

    public void asignarMateria(Materia m) {
        if (m == null) {
            throw new IllegalArgumentException("La materia no puede ser nula");
        }

        materiasAsignadas.add(m);
    }

    // Polimorfismo: sobrescribe toString y usa super.toString()
    @Override
    public String toString() {
        return super.toString() +
                ", especialidad='" + especialidad + '\'' +
                ", aniosExperiencia=" + aniosExperiencia +
                ", materiasAsignadas=" + materiasAsignadas +
                '}';
    }
}
