public class TablaHashJugadores {
    private Jugador[] tabla;
    private String[] claves;
    private int tamaño = 10;

    public TablaHashJugadores() {
        tabla = new Jugador[tamaño];
        claves = new String[tamaño];
        for (int i = 0; i < tamaño; i++) claves[i] = "";
    }

    private int hash(String clave) {
        int h = 0;
        for (int i = 0; i < clave.length(); i++) h += clave.charAt(i);
        return h % tamaño;
    }

    public void insertar(String clave, Jugador j) {
        int i = hash(clave);
        while (!claves[i].isEmpty()) {
            i = (i + 1) % tamaño;
        }
        claves[i] = clave;
        tabla[i] = j;
    }

    // Devuelve posición o -1
    public int buscar(String clave) {
        int i = hash(clave);
        int cont = 0;
        while (cont < tamaño) {
            if (claves[i].isEmpty()) return -1;
            if (claves[i].equals(clave)) return i;
            i = (i + 1) % tamaño;
            cont++;
        }
        return -1;
    }

    public Jugador obtenerJugador(int pos) {
        return (pos != -1) ? tabla[pos] : null;
    }

    public void mostrar() {
        System.out.println("\n=== TABLA HASH ===");
        for (int i = 0; i < tamaño; i++) {
            System.out.println(i + " → " + (claves[i].isEmpty() ? "vacío" : claves[i]));
        }
        System.out.println("==================\n");
    }
}