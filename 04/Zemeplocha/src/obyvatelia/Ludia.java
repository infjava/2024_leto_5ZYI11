package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public abstract class Ludia extends Tvory {
    public Ludia(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        ArrayList<Akcia> akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && obyvatelia.get() instanceof Ludia && obyvatelia.get() != this) {
            akcie.add(new AkciaUtok(mojePolicko, druhePolicko));
        }

        return akcie;
    }

    public void zautoc(Policko mojePolicko, Policko druhePolicko, int pocetUtocnikov) {
        var cieloviObyvatelia = (Ludia)druhePolicko.getObyvatelia().orElseThrow();

        cieloviObyvatelia.prijmiUtok(this.vypocitajSiluUtoku(pocetUtocnikov));
        this.prijmiUtok(cieloviObyvatelia.vypocitajSiluUtoku(pocetUtocnikov));

        if (cieloviObyvatelia.getPopulacia() <= 0) {
            druhePolicko.zruseniObyvatelia();
        }
        if (this.getPopulacia() <= 0) {
            mojePolicko.zruseniObyvatelia();
        }
    }

    protected abstract int vypocitajSiluUtoku(int pocetUtocnikov);

    protected abstract void prijmiUtok(int silaUtoku);
}
