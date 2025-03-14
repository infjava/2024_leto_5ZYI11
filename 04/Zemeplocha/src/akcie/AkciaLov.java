package akcie;

import hlavnyBalik.Policko;
import obyvatelia.Tvory;
import zemeplocha.Zemeplocha;

import javax.swing.*;
import java.util.Optional;

public class AkciaLov implements Akcia {
    private final Policko mojePolicko;
    private final Policko druhePolicko;

    public AkciaLov(Policko mojePolicko, Policko druhePolicko) {
        this.mojePolicko = mojePolicko;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Lov";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetLovcov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet lovcov, ktori idu na lov.") );
        var ja = this.mojePolicko.getObyvatelia().orElseThrow();
        if (pocetLovcov > ja.getPopulacia()) {
            JOptionPane.showMessageDialog( null, "Nemas dost lovcov.");
        } else {
            var cieloviObyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();
            cieloviObyvatelia.upravPopulaciu(-pocetLovcov);
            if (cieloviObyvatelia.getPopulacia() <= 0) {
                this.druhePolicko.zruseniObyvatelia();
            }
        }
    }
}
