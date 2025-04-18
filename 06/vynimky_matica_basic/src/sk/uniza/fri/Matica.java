package sk.uniza.fri;


import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 08-Apr-22 - 08:34
 *
 * @author milan
 */
public class Matica {
    private final double [][] polePrvkov;
    private final int pocetRiadkov;
    private final int pocetStlpcov;

    public Matica(double[][] polePrvkov) {
        this.polePrvkov = polePrvkov;
        //this.polePrvkov = null;
        this.pocetRiadkov = polePrvkov.length;
        this.pocetStlpcov = polePrvkov[0].length;
    }

    // naplni maticu nahodnymi prvkami
    public Matica(int pocetRiadkov, int pocetStlpcov, double rozsahOd, double rozsahDo) {
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        Random rnd = new Random();
        this.polePrvkov = new double[pocetRiadkov][pocetStlpcov];
        for (int i = 0; i < pocetRiadkov; i++) {
            for (int j = 0; j < pocetStlpcov; j++) {
                this.polePrvkov[i][j] = rozsahOd + rnd.nextDouble() * (rozsahDo - rozsahOd);
            }
        }
    }

    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }

    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }

    public double dajPrvok(int i, int j) {
        return this.polePrvkov[i][j];
    }

    public Matica vykonajOperaciuPoPrvkoch(Matica mat2, Operacia operacia) throws ZleRozmeryMaticException {
        if (mat2 == null) {
            throw new InvalidParameterException("mat2 nemoze byt null");
        }

        if (this.pocetStlpcov != mat2.getPocetStlpcov() || this.pocetRiadkov != mat2.getPocetRiadkov()) {
            throw new ZleRozmeryMaticException();
        }

        double[][] vysledok = new double[this.pocetRiadkov][this.pocetStlpcov];
        for (int i = 0; i < vysledok.length; i++) {
            for (int j = 0; j < vysledok[0].length; j++) {
                try {
                    vysledok[i][j] = operacia.vykonaj(this.dajPrvok(i, j), mat2.dajPrvok(i, j));
                } catch (Exception e) {
                    throw new ChybaNaPrvkuException(i, j, e);
                }
            }
        }
        return new Matica(vysledok);
    }

    // operacia jednej s druhou
    public Matica vynasobMaticou(Matica mat2) throws ZleRozmeryMaticException {
        if (mat2 == null) {
            throw new InvalidParameterException("mat2 nemoze byt null");
        }

        if (this.pocetStlpcov != mat2.getPocetRiadkov()) {
            throw new ZleRozmeryMaticException();
        }

        double[][] result = new double[this.pocetRiadkov][mat2.pocetStlpcov];
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < mat2.pocetStlpcov; j++) {
                for (int k = 0; k < mat2.pocetRiadkov; k++) {
                    result[i][j] += this.polePrvkov[i][k] * mat2.dajPrvok(k, j);
                }
            }
        }

        return new Matica(result);
    }

    //  metoda sa vypise aj inak
    public void vypisMaticuDoKonzoly() {
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.pocetStlpcov; j++) {
                System.out.printf(" %9.3f", this.polePrvkov[i][j]);
            }
            System.out.println();
        }
    }

}
