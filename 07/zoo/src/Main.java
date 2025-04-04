public class Main {
    public static void main(String[] args) {
        // klietka na levy
        var klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(new Lev("Simba"));
//        klietkaNaLeva.vlozPotravu(new Syr());
        klietkaNaLeva.vlozPotravu(new Maso());
        klietkaNaLeva.vypis();

        // klietka na mysi
        var klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vlozZviera(new Mys());
        klietkaNaMys.vlozPotravu(new Syr());
        // Toto nemoze ist:
//        klietkaNaMys.vlozZviera(new Lev("Mysozer"));
        klietkaNaMys.vypis();

        var klietkaNaMacku = new Klietka<Macka>();
        klietkaNaMacku.vlozZviera(new Macka("Tom"));
        klietkaNaMacku.vlozPotravu(new Mlieko());
        klietkaNaMacku.vypis();

        // klietka na cele cisla
//        var divnaKlietka = new Klietka<Integer>();
//        divnaKlietka.vlozZviera(5);
//        divnaKlietka.vypis();
    }
}
