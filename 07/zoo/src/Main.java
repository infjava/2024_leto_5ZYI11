public class Main {
    public static void main(String[] args) {
        var klietkaNaLeva = new Klietka();
        klietkaNaLeva.vlozZviera(new Lev("Simba"));
        klietkaNaLeva.vypis();

        var klietkaNaMys = new Klietka();
        klietkaNaMys.vlozZviera(new Mys());
        klietkaNaMys.vypis();
    }
}
