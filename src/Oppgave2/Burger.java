package Oppgave2;

public class Burger {
    private static int burger;
    private final int id;

    public Burger(){
        id = burger++;
    }

    @Override
    public String toString(){
        return String.format("(%s)", id);
    }
}
