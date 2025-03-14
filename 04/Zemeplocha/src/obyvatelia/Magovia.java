package obyvatelia;

import akcie.Akcia;
import akcie.KuzloMnozenia;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Magovia extends Tvory {
    private final int koeficientMagie;

    public Magovia(int populacia, int koeficientMagie) {
        super(populacia, TypObyvatela.MAGOVIA);
        this.koeficientMagie = koeficientMagie;
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = new ArrayList<Akcia>();

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && obyvatelia.get().getTypObyvatela() != TypObyvatela.MAGOVIA) {
            akcie.add(new KuzloMnozenia(druhePolicko, this.koeficientMagie));
        }

        return akcie;
    }
}
