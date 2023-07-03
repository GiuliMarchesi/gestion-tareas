package gestionDeTareas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeTareas lista = new ListaDeTareas();
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do {
            System.out.println("==== Menú ====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Editar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar tareas");
            System.out.println("5. Guardar tareas");
            System.out.println("6. Cargar tareas");
            System.out.println("0. Salir");
            System.out.println("==============");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    Tarea nuevaTarea = new Tarea(nombre, descripcion);
                    lista.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el índice de la tarea a editar: ");
                    int indiceEditar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nuevo nombre de la tarea: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción de la tarea: ");
                    String nuevaDescripcion = scanner.nextLine();
                    lista.editarTarea(indiceEditar, nuevoNombre, nuevaDescripcion);
                    System.out.println("Tarea editada correctamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el índice de la tarea a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    lista.eliminarTarea(indiceEliminar);
                    System.out.println("Tarea eliminada correctamente.");
                    break;
                case 4:
                    System.out.println("== Lista de Tareas ==");
                    lista.mostrarTareas();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del archivo para guardar las tareas: ");
                    String archivoGuardar = scanner.nextLine();
                    lista.guardarTareas(archivoGuardar);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del archivo para cargar las tareas: ");
                    String archivoCargar = scanner.nextLine();
                    lista.cargarTareas(archivoCargar);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
            System.out.println();
        } while (opcion != 0);
        
        scanner.close();
    }
}

