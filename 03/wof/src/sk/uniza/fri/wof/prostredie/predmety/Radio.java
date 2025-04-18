package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Radio implements Predmet, ReakciaNaChodenie {
    private boolean maBaterky;

    public Radio() {
        this.maBaterky = false;
    }

    @Override
    public String getNazov() {
        return "radio";
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }

    @Override
    public void hracSaPohol(Hrac hrac) {
        if (this.maBaterky) {
            System.out.println("Radio hra, lalala");
        }
    }

    public void vlozBaterky() {
        this.maBaterky = true;
    }
}
