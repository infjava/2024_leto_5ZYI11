package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Rytieri extends Tvory {
    public Rytieri(int populacia) {
        super(populacia, TypObyvatela.RYTIERI);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        ArrayList<Akcia> akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && !(obyvatelia.get() instanceof Zver) && obyvatelia.get() != this) {
            akcie.add(new AkciaUtok(mojePolicko, druhePolicko));
        }

        return akcie;
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Rytieri(pocetTvorov);
    }

    public void zautoc(Policko mojePolicko, Policko druhePolicko, int pocetUtocnikov) {
        var cieloviObyvatelia = druhePolicko.getObyvatelia().orElseThrow();

        cieloviObyvatelia.upravPopulaciu(-pocetUtocnikov);
        this.upravPopulaciu(-pocetUtocnikov);

        if (cieloviObyvatelia.getPopulacia() <= 0) {
            druhePolicko.zruseniObyvatelia();
        }
        if (this.getPopulacia() <= 0) {
            mojePolicko.zruseniObyvatelia();
        }
    }
}
