import java.util.Random;

public class Baraja {
    private NodoLista cabeza;
    private int tamaño = 0;

    public Baraja() {
        crearBaraja();
        mezclar();
    }

    private void crearBaraja() {
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; // lista de valores
        for (Palo palo : Palo.values()) {
            for (String valor : valores) {
                agregarAlFinal(new Carta(valor, palo));
            }
        }
    }

    private void agregarAlFinal(Carta carta) {
        NodoLista nuevo = new NodoLista(carta);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista temporal = cabeza;
            while (temporal.siguiente != null) temporal = temporal.siguiente;
            temporal.siguiente = nuevo;
        }
        tamaño++;
    }

    private void mezclar() {
        Carta[] array = toArray();
        Random random = new java.util.Random();
        for (int i = array.length-1; i > 0; i--) {  //Fisher-Yates
            int j = random.nextInt(i+1);
            Carta temporal = array[i];
            array[i] = array[j];
            array[j] = temporal;
        }
        cabeza = null;
        tamaño = 0;
        for (Carta carta : array) agregarAlFinal(carta);
    }

    private Carta[] toArray() {
        Carta[] array = new Carta[tamaño];
        NodoLista temporal = cabeza;
        int i = 0;
        while (temporal != null) {
            array[i++] = temporal.carta;
            temporal = temporal.siguiente;
        }
        return array;
    }

    public Carta tomarCarta() { // Saca la primera carta y actualiza la cabeza
        if (cabeza == null) return null;
        Carta carta = cabeza.carta;
        cabeza = cabeza.siguiente;
        tamaño--;
        return carta;
    }

    // MergeSort
    public void ordenarMergeSort() {
        cabeza = mergeSort(cabeza);
    }

    private NodoLista mergeSort(NodoLista nodo) {
        if (nodo == null || nodo.siguiente == null) return nodo;
        NodoLista medio = obtenerMedio(nodo);
        NodoLista sig = medio.siguiente;
        medio.siguiente = null;
        NodoLista izquierda = mergeSort(nodo);
        NodoLista derecha = mergeSort(sig);
        return merge(izquierda, derecha);
    }

    private NodoLista merge(NodoLista a, NodoLista b) {
        NodoLista dummy = new NodoLista(null);
        NodoLista cola = dummy;
        while (a != null && b != null) {
            if (valorOrden(a.carta) <= valorOrden(b.carta)) {
                cola.siguiente = a; a = a.siguiente;
            } else {
                cola.siguiente = b; b = b.siguiente;
            }
            cola = cola.siguiente;
        }
        cola.siguiente = (a != null) ? a : b;
        return dummy.siguiente;
    }

    private int valorOrden(Carta carta) {
        return switch (carta.getValor()) {
            case "A" -> 1; case "J" -> 11; case "Q" -> 12; case "K" -> 13;
            default -> Integer.parseInt(carta.getValor());
        };
    }

    private NodoLista obtenerMedio(NodoLista nodo) {
        NodoLista lento = nodo, rapido = nodo;
        while (rapido.siguiente != null && rapido.siguiente.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        return lento;
    }
}