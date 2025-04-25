import javax.swing.*;

public class HlavneOkno {
    private final JFrame okno;
    private JTextField meno;
    private JTextField priezvisko;
    private JTextField vek;
    private JButton pridaj;
    private JButton odstran;
    private JButton uprav;
    private JList zoznam;
    private JPanel hlavnyPanel;

    public HlavneOkno() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(this.hlavnyPanel);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
