package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Automat implements Vybavenie, Pouzitelny {
    @Override
    public String getNazov() {
        return "automat";
    }

    @Override
    public String getPopis() {
        return "Výpredaj bagiet a minerálok";
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("Pouzil si automat!");
    }
}
