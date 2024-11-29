package common.model;

public enum Status {
    EMPTY ("   "),
    X(" X "),
    O(" O ");

    private final String value;
    Status(String value) { this.value = value; }
    public String getValue() { return this.value; }
}
