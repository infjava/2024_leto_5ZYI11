import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class HlavneOkno {
    private static final int SUBOR_MAGIC_NUMBER = 1534343123;
    private static final int SUBOR_VERZIA = 1;

    private final JFrame okno;
    private DefaultListModel<Student> studenti;

    private JTextField meno;
    private JTextField priezvisko;
    private JTextField rokNarodenia;
    private JButton pridaj;
    private JButton odstran;
    private JButton uprav;
    private JList<Student> zoznam;
    private JPanel hlavnyPanel;
    private JButton uloz;
    private JButton nacitaj;

    public HlavneOkno() {
        this.studenti = new DefaultListModel<Student>();
        this.zoznam.setModel(this.studenti);

        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.hlavnyPanel);
        this.okno.pack();

        this.pridaj.addActionListener(e -> this.pridajStudenta());

        this.meno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }
        });

        this.priezvisko.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }
        });

        this.rokNarodenia.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujTlacitka();
            }
        });

        this.zoznam.addListSelectionListener(e -> this.aktualizujTlacitka());

        this.uloz.addActionListener(e -> this.ulozStudentovDoSuboru());
        this.nacitaj.addActionListener(e -> this.nacitajStudentovZoSuboru());
    }

    private void ulozStudentovDoSuboru() {
        var vyberSuboru = new JFileChooser();

        var vyber = vyberSuboru.showSaveDialog(this.okno);

        if (vyber == JFileChooser.APPROVE_OPTION) {
            try (var zapisovac = new DataOutputStream(new FileOutputStream(vyberSuboru.getSelectedFile()))) {
                zapisovac.writeInt(SUBOR_MAGIC_NUMBER);
                zapisovac.writeInt(SUBOR_VERZIA);
                zapisovac.writeInt(this.studenti.getSize());
                for (int i = 0; i < this.studenti.getSize(); i++) {
                    var student = this.studenti.get(i);
                    student.ulozDoSuboru(zapisovac);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this.okno, "Nastala chyba pri ukladani. Chyba: " + e.getMessage());
            }
        }
    }

    private void nacitajStudentovZoSuboru() {
        var vyberSuboru = new JFileChooser();

        var vyber = vyberSuboru.showOpenDialog(this.okno);

        if (vyber == JFileChooser.APPROVE_OPTION) {
            try (var citac = new ObjectInputStream(new FileInputStream(vyberSuboru.getSelectedFile()))) {
                this.studenti = (DefaultListModel<Student>) citac.readObject();
                this.zoznam.setModel(this.studenti);
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this.okno, "Nastala chyba pri nacitavani. Chyba: " + e.getMessage());
            }
        }
    }

    private void aktualizujTlacitka() {
        var jeMeno = !this.meno.getText().isBlank();
        var jePriezvisko = !this.priezvisko.getText().isBlank();

        var jeRokNarodenia = true;
        try {
            var x = Integer.parseInt(this.rokNarodenia.getText());
        } catch (NumberFormatException e) {
            jeRokNarodenia = false;
        }

        this.pridaj.setEnabled(jeMeno && jePriezvisko && jeRokNarodenia);
    }

    private void pridajStudenta() {
        var meno = this.meno.getText();
        var priezvisko = this.priezvisko.getText();
        var rokNarodenia = Integer.parseInt(this.rokNarodenia.getText());

        var student = new Student(meno, priezvisko, rokNarodenia);

        this.studenti.addElement(student);
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
