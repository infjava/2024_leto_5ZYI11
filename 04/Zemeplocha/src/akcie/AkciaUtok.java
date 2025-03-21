package akcie;

import hlavnyBalik.Policko;
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
        var ja = this.mojePolicko.getObyvatelia().orElseThrow();
        if (pocetUtocnikov > ja.getPopulacia()) {
            JOptionPane.showMessageDialog( null, "Nemas dost utocnikov.");
        } else {
            var cieloviObyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();

            if (pocetUtocnikov > cieloviObyvatelia.getPopulacia()) {
                pocetUtocnikov = cieloviObyvatelia.getPopulacia();
            }

            cieloviObyvatelia.upravPopulaciu(-pocetUtocnikov);
            ja.upravPopulaciu(-pocetUtocnikov);

            if (cieloviObyvatelia.getPopulacia() <= 0) {
                this.druhePolicko.zruseniObyvatelia();
            }
            if (ja.getPopulacia() <= 0) {
                this.mojePolicko.zruseniObyvatelia();
            }
        }
    }
}
