import javax.swing.*;

public class HlavneOkno {
    private final JFrame okno;
    private final DefaultListModel<Student> studenti;

    private JTextField meno;
    private JTextField priezvisko;
    private JTextField vek;
    private JButton pridaj;
    private JButton odstran;
    private JButton uprav;
    private JList<Student> zoznam;
    private JPanel hlavnyPanel;

    public HlavneOkno() {
        this.studenti = new DefaultListModel<Student>();
        this.studenti.addElement(new Student("Ferko", "Mrkvicka", 1850));
        this.studenti.addElement(new Student("Jozko", "Pagacik", 2010));
        this.studenti.addElement(new Student("Andy", "Lyzica", 2023));

        this.zoznam.setModel(this.studenti);

        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.hlavnyPanel);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
