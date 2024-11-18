public class Player {
    private  String name;
    private String representation;

    public Player(String representation) {
        this.representation = representation;
        this.name = "Joueur " + representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public String getName() {
        return name;
    }
}
