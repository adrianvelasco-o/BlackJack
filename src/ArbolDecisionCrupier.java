public class ArbolDecisionCrupier {
    private NodoArbol raiz;

    public ArbolDecisionCrupier() {
        raiz = new NodoArbol(null);
        raiz.izq = new NodoArbol("PEDIR");
        raiz.der = new NodoArbol("PLANTARSE");
    }

    public String decidir(int puntaje) {
        return puntaje < 17 ? "PEDIR" : "PLANTARSE";
    }
}