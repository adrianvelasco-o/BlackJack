public class NodoLista {
    Carta carta;
    NodoLista siguiente;

    public NodoLista(Carta carta) { // Nodo1 (As) → Nodo2 (7) → Nodo3 (K) → null.
        this.carta = carta;
        this.siguiente = null;
    }
}