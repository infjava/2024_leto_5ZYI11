package zemeplocha;

import hlavnyBalik.Policko;
import obyvatelia.*;

public class Zemeplocha {
    //pocet poludnikov aj rovnobeziek je rovnaky
    private final int pocetPolicok;
    private final Policko[][] policka;
    
    public Zemeplocha(int pocet) {
        this.pocetPolicok = pocet;
        this.policka = new Policko[this.pocetPolicok][this.pocetPolicok];
        for (int i = 0; i < this.policka.length; i++) {
            for (int j = 0; j < this.policka[i].length; j++) {
                //vytvorime prazdne policka bez obyvatela
                this.policka[i][j] = new Policko( );
            }
        }
    }

    //nastavime obyvatelov jednotlivym polickam
    public void nastavPolicka() {
        int cislo = 1;
        for (int i = 0; i < this.policka.length; i++) {
            for (int j = 0; j < this.policka[i].length; j++) {

                if ((cislo % 19) == 0) {
                    this.policka[i][j].setObyvatelia(new Magovia(5, 5));
                } else if ((cislo % 23) == 0) {
                    this.policka[i][j].setObyvatelia(new Lovci(50));
                } else if ((cislo % 13) == 0) {
                    this.policka[i][j].setObyvatelia(new Rytieri(25));
                } else if ((cislo % 2) == 0) { //vela zveri
                    this.policka[i][j].setObyvatelia(new Zver(25, TypObyvatela.SRNKY));
                } else {
                    if ((cislo % 5) == 0) {
                        if ((i % 2) == 0) { //sem tam ine
                            this.policka[i][j].setObyvatelia(new Zver(10, TypObyvatela.ZAJACE));
                        } else {
                            this.policka[i][j].setObyvatelia(new Zver(10, TypObyvatela.SLIEPKY));
                        }
                    }
                }

                cislo++;

            }
        }

    }

    //poskytuje policko na danych suradniciach, ak existuje
    public Policko getPolicko(int rovnobezka, int poludnik) {
        return this.policka[rovnobezka][poludnik];
    }
    
    public int getPocetPolicok() {
        return this.pocetPolicok;
    }

}
