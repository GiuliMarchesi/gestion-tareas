package gestionDeTareas;

import java.io.*;
import java.util.ArrayList;

public class ListaDeTareas {
    private ArrayList<Tarea> tareas;
    
    public ListaDeTareas() {
        tareas = new ArrayList<>();
    }
    
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    
    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    public void editarTarea(int indice, String nombre, String descripcion) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println("Índice: " + i);
                System.out.println(tareas.get(i));
                System.out.println("------------------------");
            }
        }
    }
    
    public void guardarTareas(String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(tareas);
            System.out.println("Lista de tareas guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de tareas.");
            e.printStackTrace();
        }
    }
    
    public void cargarTareas(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            tareas = (ArrayList<Tarea>) in.readObject();
            System.out.println("Lista de tareas cargada correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la lista de tareas.");
            e.printStackTrace();
        }
    }
}

