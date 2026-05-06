
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int AGREGAR_CARRERA = 1;
    private static final int AGREGAR_ESTUDIANTE = 2;
    private static final int AGREGAR_MATERIA = 3;
    private static final int LISTAR_ESTUDIANTES = 4;
    private static final int VER_MATERIAS = 5;
    private static final int BUSCAR_ESTUDIANTE = 6;
    private static final int SALIR = 7;

    public static void main(String[] args) {
        ArrayList<Carrera> carreras = new ArrayList<>();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != SALIR) {
            System.out.println("\nMENU");
            System.out.println(AGREGAR_CARRERA + ". Agregar carrera");
            System.out.println(AGREGAR_ESTUDIANTE + ". Agregar estudiante");
            System.out.println(AGREGAR_MATERIA + ". Agregar materia a un estudiante");
            System.out.println(LISTAR_ESTUDIANTES + ". Listar estudiantes de una carrera");
            System.out.println(VER_MATERIAS + ". Ver materias de un estudiante");
            System.out.println(BUSCAR_ESTUDIANTE + ". Buscar estudiante por nombre");
            System.out.println(SALIR + ". Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case AGREGAR_CARRERA:
                    System.out.print("Nombre de la carrera: ");
                    String nombreCarrera = sc.nextLine();

                    Carrera nuevaCarrera = new Carrera(nombreCarrera);
                    carreras.add(nuevaCarrera);
                    System.out.println("Carrera '" + nombreCarrera + "' agregada correctamente");
                    break;

                case AGREGAR_ESTUDIANTE:
                    if (carreras.isEmpty()) {
                        System.out.println("No hay carreras cargadas. Agregue una primero");
                        break;
                    }

                    System.out.println("Carreras disponibles:");
                    for (int i = 0; i < carreras.size(); i++) {
                        System.out.println((i + 1) + ". " + carreras.get(i).getNombre());
                    }

                    System.out.print("Seleccione una carrera: ");
                    int idxCarrera = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxCarrera < 0 || idxCarrera >= carreras.size()) {
                        System.out.println("Indice invalido");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Documento: ");
                    String documento = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = sc.nextDouble();
                    sc.nextLine();

                    Estudiante nuevo = new Estudiante(
                            nombre, edad, apellido, documento,
                            carreras.get(idxCarrera).getNombre(),
                            promedio, new ArrayList<>());
                    estudiantes.add(nuevo);
                    carreras.get(idxCarrera).agregarEstudiante(nuevo);
                    System.out.println("Estudiante agregado correctamente");
                    break;

                case AGREGAR_MATERIA:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes cargados");
                        break;
                    }

                    System.out.println("Estudiantes:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre()
                                + " " + estudiantes.get(i).getApellido());
                    }

                    System.out.print("Seleccione un estudiante: ");
                    int indice = sc.nextInt() - 1;
                    sc.nextLine();

                    if (indice < 0 || indice >= estudiantes.size()) {
                        System.out.println("Indice invalido");
                        break;
                    }

                    System.out.print("Nombre de la materia: ");
                    String nombreMateria = sc.nextLine();

                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.print("Creditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();

                    Materia materia = new Materia(nombreMateria, codigo, creditos);
                    estudiantes.get(indice).agregarMateria(materia);
                    System.out.println("Materia agregada correctamente");
                    break;

                case LISTAR_ESTUDIANTES:
                    if (carreras.isEmpty()) {
                        System.out.println("No hay carreras cargadas");
                        break;
                    }

                    System.out.println("Carreras disponibles:");
                    for (int i = 0; i < carreras.size(); i++) {
                        System.out.println((i + 1) + ". " + carreras.get(i).getNombre());
                    }

                    System.out.print("Seleccione una carrera: ");
                    int idxListar = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxListar < 0 || idxListar >= carreras.size()) {
                        System.out.println("Indice invalido");
                        break;
                    }

                    carreras.get(idxListar).listarEstudiantes();
                    break;

                case VER_MATERIAS:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes cargados");
                        break;
                    }

                    System.out.println("Estudiantes:");
                    for (int i = 0; i < estudiantes.size(); i++) {
                        System.out.println((i + 1) + ". " + estudiantes.get(i).getNombre()
                                + " " + estudiantes.get(i).getApellido());
                    }

                    System.out.print("Seleccione un estudiante: ");
                    int idx = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idx < 0 || idx >= estudiantes.size()) {
                        System.out.println("Indice invalido");
                        break;
                    }

                    System.out.println("Materias de " + estudiantes.get(idx).getNombre() + ":");
                    estudiantes.get(idx).listarMaterias();
                    break;

                case BUSCAR_ESTUDIANTE:
                    if (carreras.isEmpty()) {
                        System.out.println("No hay carreras cargadas");
                        break;
                    }

                    System.out.println("Carreras disponibles:");
                    for (int i = 0; i < carreras.size(); i++) {
                        System.out.println((i + 1) + ". " + carreras.get(i).getNombre());
                    }

                    System.out.print("Seleccione una carrera: ");
                    int idxBuscar = sc.nextInt() - 1;
                    sc.nextLine();

                    if (idxBuscar < 0 || idxBuscar >= carreras.size()) {
                        System.out.println("Indice invalido");
                        break;
                    }

                    System.out.print("Texto a buscar: ");
                    String texto = sc.nextLine();
                    carreras.get(idxBuscar).buscarEstudiante(texto);
                    break;

                case SALIR:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
}
