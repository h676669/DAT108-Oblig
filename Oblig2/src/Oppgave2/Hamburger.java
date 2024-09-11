package Oppgave2;

public class Hamburger {
    private final int id;
    private static int idCount;

    public Hamburger() {
        this.id = ++idCount;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Hamburger " + id;
    }
}
