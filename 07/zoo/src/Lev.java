public class Lev extends Zviera implements Nazvany {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo jedlo) {
        if (!(jedlo instanceof Maso)) {
            throw new ToNelubimException();
        }

        System.out.println("Lev zozral jedlo");
    }
}
