import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HlavneOkno {
    private final JFrame okno;
    private final DefaultListModel<Student> studenti;

    private JTextField meno;
    private JTextField priezvisko;
    private JTextField rokNarodenia;
    private JButton pridaj;
    private JButton odstran;
    private JButton uprav;
    private JList<Student> zoznam;
    private JPanel hlavnyPanel;

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
