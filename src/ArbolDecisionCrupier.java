public class ArbolDecisionCrupier {
    private NodoArbol raiz;

    public ArbolDecisionCrupier() {
        raiz = new NodoArbol(null);
        raiz.izquierda = new NodoArbol("PEDIR");
        raiz.derecha = new NodoArbol("PLANTARSE");
    }

    public String decidir(int puntaje) {
        return puntaje < 17 ? "PEDIR" : "PLANTARSE";
    }
}