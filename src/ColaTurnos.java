public class ColaTurnos {
    private NodoCola frente = null;
    private NodoCola fondo = null;

    public void encolar(String n) {
        NodoCola nuevo = new NodoCola(n);
        if (fondo == null) {
            frente = fondo = nuevo;
        } else {
            fondo.siguiente = nuevo;
            fondo = nuevo;
        }
    }

    public String desencolar() {
        if (frente == null) return null;
        String n = frente.nombre;
        frente = frente.siguiente;
        if (frente == null) fondo = null;
        return n;
    }

    public String verFrente() {
        return frente != null ? frente.nombre : null;
    }
}