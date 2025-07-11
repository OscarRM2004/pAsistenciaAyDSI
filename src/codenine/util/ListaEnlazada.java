package codenine.util;

import codenine.dto.PersonaDto;

public class ListaEnlazada {

    private Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    // Método para agregar una persona al final de la lista
    public void agregar(PersonaDto persona) {
        Nodo nuevoNodo = new Nodo(persona);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    // Método para eliminar una persona de la lista
    public void eliminar(int idPersona) {
        if (cabeza == null) return;
        if (cabeza.getPersona().getIdPersona() == idPersona) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null && actual.getSiguiente().getPersona().getIdPersona() != idPersona) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
    }

    // Método para recorrer la lista y mostrar los datos
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getPersona().getNombre());
            actual = actual.getSiguiente();
        }
    }

    // Clase Nodo para la lista enlazada
    private static class Nodo {
        private PersonaDto persona;
        private Nodo siguiente;

        public Nodo(PersonaDto persona) {
            this.persona = persona;
            this.siguiente = null;
        }

        public PersonaDto getPersona() {
            return persona;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
