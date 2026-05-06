import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private String direccion;
    private ArrayList<MiembroUniversidad> miembros;

    public Universidad(String nombre, String direccion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacio o nulo");
        }

        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La direccion no puede ser vacia o nula");
        }

        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<MiembroUniversidad> getMiembros() {
        return miembros;
    }

    public void agregarMiembro(MiembroUniversidad m) {
        if (m == null) {
            throw new IllegalArgumentException("El miembro no puede ser nulo");
        }
        miembros.add(m);
    }

    public void listarMiembros() {
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros en la universidad");
            return;
        }

        for (MiembroUniversidad m : miembros) {
            System.out.println(m.obtenerInformacionCompleta());
        }
    }

    public void listarPorRol(String rol) {
        if (rol == null || rol.isBlank()) {
            throw new IllegalArgumentException("El rol no puede ser vacio o nulo");
        }

        for (MiembroUniversidad m : miembros) {
            if (m.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println(m.obtenerInformacionCompleta());
            }
        }
    }
}
