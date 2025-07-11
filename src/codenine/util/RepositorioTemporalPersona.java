package codenine.util;

import codenine.dto.PersonaDto;

public class RepositorioTemporalPersona {

    private ListaEnlazada listaEnlazada;

    public RepositorioTemporalPersona() {
        this.listaEnlazada = new ListaEnlazada();  // Crear una lista enlazada vacía
    }

    // Método para agregar una persona a la lista temporal
    public void agregarPersona(PersonaDto persona) {
        listaEnlazada.agregar(persona);
    }

    // Método para eliminar una persona de la lista temporal
    public void eliminarPersona(int idPersona) {
        listaEnlazada.eliminar(idPersona);
    }

    // Método para obtener la lista de personas (opcional)
    public void mostrarPersonas() {
        listaEnlazada.mostrar();
    }
}
