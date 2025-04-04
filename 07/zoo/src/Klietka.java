import java.util.Iterator;

public class Klietka<E extends Zviera> implements Iterable<E> {
    private E zviera;

    public Klietka() {
        this.zviera = null;
    }

    public void vlozZviera(E zviera) {
        this.zviera = zviera;
    }

    public void vypis() {
        if (this.zviera == null) {
            System.out.println("Klietka je prazdna");
        } else if (this.zviera instanceof Nazvany nazvaneZviera) {
            System.out.format("V klietke je %s%n", nazvaneZviera.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vlozPotravu(Jedlo<E> jedlo) {
        this.zviera.zozer(jedlo);
    }

    @Override
    public Iterator<E> iterator() {
        return new KlietkaIterator(this.zviera);
    }
}
