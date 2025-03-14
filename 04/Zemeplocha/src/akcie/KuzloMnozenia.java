package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class KuzloMnozenia implements Akcia {
    public KuzloMnozenia(Policko mojePolicko, Policko druhePolicko, int koeficientMagie) {
    }

    @Override
    public String getNazov() {
        return "Rozmnož";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {

    }
}
