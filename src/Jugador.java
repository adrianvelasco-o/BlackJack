import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> mano = new ArrayList<>();
    private int puntaje = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
        recalcularPuntaje();
    }

    private void recalcularPuntaje() {
        int total = 0, ases = 0;
        for (Carta carta : mano) {
            if (carta.getValor().equals("A")) ases++;
            total += carta.valorNumerico();
        }
        while (total > 21 && ases > 0) { total -= 10; ases--; }
        puntaje = total;
    }

    public void mostrar() {
        System.out.println(nombre + " tiene:");
        for (Carta carta : mano)
            System.out.println("  " + carta);
        System.out.println("Puntaje: " + puntaje + (puntaje > 21 ? " ¡Se pasó!" : ""));
    }

    public String obtenerNombre() {
        return nombre;
    }
    public int obtenerPuntaje() {
        return puntaje;
    }
    public boolean sePaso() {
        return puntaje > 21;
    }
}