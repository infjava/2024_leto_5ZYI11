package akcie;

import hlavnyBalik.Policko;
import obyvatelia.Rytieri;
import zemeplocha.Zemeplocha;

import javax.swing.*;

public class AkciaUtok implements Akcia {
    private final Policko mojePolicko;
    private final Policko druhePolicko;

    public AkciaUtok(Policko mojePolicko, Policko druhePolicko) {
        this.mojePolicko = mojePolicko;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Zaútoč";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetUtocnikov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet utocnikov.") );
        var ja = (Rytieri) this.mojePolicko.getObyvatelia().orElseThrow();
        if (pocetUtocnikov > ja.getPopulacia()) {
            JOptionPane.showMessageDialog( null, "Nemas dost utocnikov.");
        } else {
            var cieloviObyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();

            if (pocetUtocnikov > cieloviObyvatelia.getPopulacia()) {
                pocetUtocnikov = cieloviObyvatelia.getPopulacia();
            }

            ja.zautoc(this.mojePolicko, this.druhePolicko, pocetUtocnikov);
        }
    }
}
