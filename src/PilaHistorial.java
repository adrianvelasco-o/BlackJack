public class PilaHistorial {
    private NodoPila cima = null;

    public void push(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public void mostrarUltimas(int cantidadCartas) {
        System.out.println("Últimas " + cantidadCartas + " cartas jugadas:");
        NodoPila temporal = cima;
        int i = 0;
        while (temporal != null && i < cantidadCartas) {
            System.out.println("  " + temporal.carta);
            temporal = temporal.siguiente;
            i++;
        }
    }
}