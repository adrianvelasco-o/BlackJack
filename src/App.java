import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println(" BLACKJACK 21 ");
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = entradaTeclado.nextLine();

        Baraja baraja = new Baraja();
        PilaHistorial historial = new PilaHistorial();
        ColaTurnos turnos = new ColaTurnos();
        ArbolDecisionCrupier arbol = new ArbolDecisionCrupier();
        TablaHashJugadores tabla = new TablaHashJugadores();

        Jugador persona = new Jugador(nombreJugador);
        Jugador crupier = new Jugador("crupier");

        // Insertamos con el nombre del jugador
        tabla.insertar(nombreJugador, persona);
        tabla.insertar("crupier", crupier);
        tabla.mostrar();

        // Repartir cartas iniciales
        persona.recibirCarta(baraja.tomarCarta());
        crupier.recibirCarta(baraja.tomarCarta());
        persona.recibirCarta(baraja.tomarCarta());
        crupier.recibirCarta(baraja.tomarCarta());

        // Turno del jugador
        while (true) {
            System.out.println("\nTurno de: " + nombreJugador);
            persona.mostrar();
            if (persona.obtenerPuntaje() >= 21) break;
            System.out.print("¿Otra carta? (s/n): ");
            if (!entradaTeclado.nextLine().equalsIgnoreCase("s")) break;
            Carta carta = baraja.tomarCarta();
            persona.recibirCarta(carta);
            historial.push(carta);
        }

        // Turno del crupier
        if (persona.obtenerPuntaje() <= 21) {
            System.out.println("\nTurno del crupier");
            crupier.mostrar();
            while (crupier.obtenerPuntaje() < 17) {
                System.out.println("El crupier pide carta...");
                Carta carta = baraja.tomarCarta();
                crupier.recibirCarta(carta);
                historial.push(carta);
                crupier.mostrar();
            }
            System.out.println("El crupier se planta.");
        }

        // RESULTADO FINAL
        System.out.println("\n=== RESULTADO FINAL ===");
        persona.mostrar();
        crupier.mostrar();

        int posH = tabla.buscar(nombreJugador);
        int posD = tabla.buscar("crupier");

        Jugador j1 = tabla.obtenerJugador(posH);
        Jugador j2 = tabla.obtenerJugador(posD);

        if (j1.sePaso()) {
            System.out.println("¡crupier gana!");
        } else if (j2.sePaso() || j1.obtenerPuntaje() > j2.obtenerPuntaje()) {
            System.out.println(nombreJugador + " gana! Felicidades");
        } else if (j1.obtenerPuntaje() < j2.obtenerPuntaje()) {
            System.out.println("crupier gana");
        } else {
            System.out.println("Empate!");
        }

        entradaTeclado.close();
    }
}