import java.time.LocalDate;

// Herencia: Personal extiende Persona
public class Personal extends Persona implements MiembroUniversidad {

    private String departamento;
    private String puesto;
    private LocalDate fechaIngreso;

    public Personal(String nombre, int edad, String apellido,
                    String documento, String departamento,
                    String puesto, LocalDate fechaIngreso) {
        super(nombre, edad, apellido, documento);
        setDepartamento(departamento);
        setPuesto(puesto);
        setFechaIngreso(fechaIngreso);
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("El departamento no puede ser nulo o vacío");
        }

        this.departamento = departamento;
    }

    public void setPuesto(String puesto) {
        if (puesto == null || puesto.isBlank()) {
            throw new IllegalArgumentException("El puesto no puede ser nulo o vacío");
        }

        this.puesto = puesto;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso == null) {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser nula");
        }

        if (fechaIngreso.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser futura");
        }

        this.fechaIngreso = fechaIngreso;
    }

    // Polimorfismo: sobrescribe toString y usa super.toString()
    @Override
    public String toString() {
        return super.toString() +
                ", departamento='" + departamento + '\'' +
                ", puesto='" + puesto + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }

    @Override
    public String obtenerRol() {
        return "Personal";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Nombre: " + getNombre() + " " + getApellido() +
                ", Documento: " + getDocumento() +
                ", Edad: " + getEdad() +
                ", Rol: " + obtenerRol() +
                ", Departamento: " + departamento +
                ", Puesto: " + puesto +
                ", Fecha de ingreso: " + fechaIngreso;
    }
}