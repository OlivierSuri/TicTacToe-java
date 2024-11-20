public abstract class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    // Méthode abstraite à implémenter dans les sous-classes
    public abstract int[] getMove(Board board);
}
