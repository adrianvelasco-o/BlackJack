public enum Palo {
    CORAZONES("Corazones", "♥"),
    DIAMANTES("Diamantes", "♦"),
    PICAS("Picas", "♠"),
    TREBOLES("Tréboles", "♣");

    private final String nombre;
    private final String simbolo;

    Palo(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public String nombreCompleto() {
        return nombre;
    }
    @Override public String toString() {
        return simbolo;
    }
}