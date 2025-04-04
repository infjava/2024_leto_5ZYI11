public class Klietka {
    private Zviera zviera;

    public Klietka() {
        this.zviera = null;
    }

    public void vlozZviera(Zviera zviera) {
        this.zviera = zviera;
    }

    public void vypis() {
        if (this.zviera == null) {
            System.out.println("Klietka je prazdna");
        } else if (this.zviera instanceof Lev lev) {
            System.out.format("V klietke je %s%n", lev.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }
}
