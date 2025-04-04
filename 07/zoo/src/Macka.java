public class Macka extends Zviera implements Nazvany {
    private final String meno;

    public Macka(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo jedlo) {
        System.out.println("Macka si spokojne pradie po dobrom obede");
    }
}
