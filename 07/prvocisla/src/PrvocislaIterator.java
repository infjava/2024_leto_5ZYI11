import java.util.Iterator;

public class PrvocislaIterator implements Iterator<Integer> {
    private final int pocet;
    private int poradoveCislo;
    private int aktualnePrvocislo;

    public PrvocislaIterator(int pocet) {
        this.pocet = pocet;
        this.poradoveCislo = 0;
        this.aktualnePrvocislo = 1;
    }

    @Override
    public boolean hasNext() {
        return this.poradoveCislo < this.pocet;
    }

    @Override
    public Integer next() {
        this.poradoveCislo++;
        this.aktualnePrvocislo++;

        while (!this.jePrvocislo()) {
            this.aktualnePrvocislo++;
        }

        return this.aktualnePrvocislo;
    }

    private boolean jePrvocislo() {
        var max = (int) Math.sqrt(this.aktualnePrvocislo);

        for (int i = 2; i <= max; i++) {
            if ((this.aktualnePrvocislo % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
