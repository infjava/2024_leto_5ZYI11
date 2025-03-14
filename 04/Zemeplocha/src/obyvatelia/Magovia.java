package obyvatelia;

public class Magovia extends Tvory {
    private final int koeficientMagie;

    public Magovia(int populacia, int koeficientMagie) {
        super(populacia, TypObyvatela.MAGOVIA);
        this.koeficientMagie = koeficientMagie;
    }
}
