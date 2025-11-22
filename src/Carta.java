public class Carta {
    private String valor;  // "A","2"..."10","J","Q","K"
    private Palo palo;

    public Carta(String valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int valorNumerico() {
        return switch (valor) {
            case "A" -> 11;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(valor);
        };
    }

    @Override
    public String toString() {
        return valor + " de " + palo.nombreCompleto() + " " + palo;
    }

    public String getValor() { return valor; }
}