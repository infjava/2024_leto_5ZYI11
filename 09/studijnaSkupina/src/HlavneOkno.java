import javax.swing.*;

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
