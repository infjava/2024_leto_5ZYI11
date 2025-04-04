import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // klietka na levy
        var klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(new Lev("Simba"));
//        klietkaNaLeva.vlozPotravu(new Syr());
        klietkaNaLeva.vlozPotravu(new Maso());
        klietkaNaLeva.vypis();

//        new Lev("Alex").zozer(new Syr());

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

        for (var macka : klietkaNaMacku) {
            System.out.format("Macka %s%n", macka.getMeno());
        }

//        var cisla = new ArrayList<Integer>();
//
//        for (Integer i : cisla) {
//            System.out.println(i);
//        }
//
//        var iterator = cisla.iterator();
//        while (iterator.hasNext()) {
//            var i = iterator.next();
//
//            System.out.println(i);
//        }
    }
}
