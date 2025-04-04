public class Main {
    public static void main(String[] args) {
        // klietka na levy
        var klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(new Lev("Simba"));
        klietkaNaLeva.vypis();

        // klietka na mysi
        var klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vlozZviera(new Mys());
        // Toto nemoze ist:
//        klietkaNaMys.vlozZviera(new Lev("Mysozer"));
        klietkaNaMys.vypis();

        var klietkaNaMacku = new Klietka<Macka>();
        klietkaNaMacku.vlozZviera(new Macka("Tom"));
        klietkaNaMacku.vypis();

        // klietka na cele cisla
//        var divnaKlietka = new Klietka<Integer>();
//        divnaKlietka.vlozZviera(5);
//        divnaKlietka.vypis();
    }
}
