package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class KuzloMnozenia implements Akcia {
    private final Policko druhePolicko;
    private final int koeficientMagie;

    public KuzloMnozenia(Policko druhePolicko, int koeficientMagie) {
        this.druhePolicko = druhePolicko;
        this.koeficientMagie = koeficientMagie;
    }

    @Override
    public String getNazov() {
        return "Rozmnož";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var mnozeniObyvatelia = this.druhePolicko.getObyvatelia().get();
        mnozeniObyvatelia.rozmnoz(this.koeficientMagie);
    }
}
