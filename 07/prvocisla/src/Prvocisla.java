import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {
    private final int pocet;

    public Prvocisla(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrvocislaIterator(this.pocet);
    }
}
