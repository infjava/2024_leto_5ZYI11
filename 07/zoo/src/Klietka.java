public class Klietka {
    private Lev lev;

    public Klietka() {
        this.lev = null;
    }

    public void vlozLeva(Lev lev) {
        this.lev = lev;
    }

    public void vypis() {
        if (this.lev == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.format("V klietke je %s%n", this.lev.getMeno());
        }
    }
}
